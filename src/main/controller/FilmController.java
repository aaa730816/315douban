package main.controller;

import main.entities.*;
import main.service.FilmService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Tony on 2017/7/3.
 */
@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllTypes")
    public String getAllTypes(Map<String, Object> map) {
        Set<String> types = filmService.getAllTypes();
        map.put("filmTypes", types);
        return "filmTypes";
    }

    @RequestMapping("/toFilmsOfTypePage")
    public String toFilmsOfTypePage(@RequestParam("type") String type, Map<String, Object> map) {
        map.put("typeName", type);
        return "filmsOfType";
    }

    @ResponseBody
    @RequestMapping("/getFilmOFType")
    public List<Map<String, String>> getFilmOFType(@RequestParam("page") int page, @RequestParam("type") String type) {
        List<Map<String, String>> result = new ArrayList<>();
        List<Film> films = filmService.getFilmByType(type, page, 20);
        for (Film f : films) {
            Map<String, String> filmMap = new HashMap<>();
            filmMap.put("img", f.getFilmImg());
            filmMap.put("filmName", f.getFilmName());
            result.add(filmMap);
        }
        return result;
    }

    @RequestMapping("/filmInfo")
    public String filmInfo(HttpSession session, @RequestParam("filmName") String filmName, Map<String, Object> map) {
//        System.out.println(filmName);
        System.out.println(filmName);
        filmName.replaceAll("%20"," ");
        System.out.println(filmName);
        Film film = filmService.getFilmByName(filmName);
        boolean isScored=false;
        if (session.getAttribute("currentUser") != null) {
            User currentUser = userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
            FilmScore filmScore=new FilmScore();
            filmScore.setUser(currentUser);
            filmScore.setFilm(film);
            if (currentUser.getFilmScores().contains(filmScore)) {
                isScored = true;
            }
            else
                isScored=false;
        }
        Set<FilmScom> filmScoms = film.getFilmScoms();
        Set<FilmLcom> filmLcoms = film.getFilmLcoms();
        map.put("film", film);
        map.put("filmScoms", filmScoms);
        map.put("filmLcoms", filmLcoms);
        map.put("isScored",isScored);
        map.put("sComs",filmService.getFilmScomByPage(filmName,0));
        map.put("lComs",filmService.getFilmLcomByPage(filmName,0));
        return "filmInfo";
    }
    @ResponseBody
    @RequestMapping("/userScore")
    public String userScore(HttpSession session,@RequestParam("filmName")String filmName,@RequestParam("score")Double score){
        User currentUser=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        Film film=filmService.getFilmByName(filmName);
        try{
            filmService.setScore(currentUser,film,score);
            return "Y";
        }catch (Exception e){
            e.printStackTrace();
            return "N";
        }
    }
    @ResponseBody
    @RequestMapping("/addFilmScom")
    public String addFilmScom(HttpSession session,@RequestParam("comment")String comment,@RequestParam("filmName")String filmName){
        User currentUser=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        Film film=filmService.getFilmByName(filmName);
        try{
            return filmService.adddFilmScom(comment,film,currentUser);
        }catch (Exception e){
            e.printStackTrace();
            return "N";
        }
    }
    @ResponseBody
    @RequestMapping("/addFilmLcom")
    public String addFilmLcom(HttpSession session,@RequestParam("comment")String comment,@RequestParam("filmName")String filmName,@RequestParam("title")String title){
        User currentUser=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        Film film=filmService.getFilmByName(filmName);
        try{
            return filmService.adddFilmLcom(title,comment,film,currentUser);
        }catch (Exception e){
            e.printStackTrace();
            return "N";
        }
    }
    @ResponseBody
    @RequestMapping("/getMoreScom")
    public List<Map<String,Object>> getMoreScom(@RequestParam("page")int page,@RequestParam("filmName")String filmName)
    {
        List<Map<String,Object>> sComs=new ArrayList<>();
        List<FilmScom> scomList=filmService.getFilmScomByPage(filmName,page);
        for (FilmScom scom:scomList){
            Map<String,Object> sMap=new HashMap<>();
            sMap.put("userName",scom.getUser().getUsername());
            sMap.put("commentDate",scom.getFilmScomDate().toString());
            sMap.put("commentContent",scom.getFilmScomContent());
            sMap.put("sComId",scom.getFilmScomId());
            sMap.put("like",scom.getFilmScomLike()==null?0:scom.getFilmScomLike());
            sComs.add(sMap);
        }
        return sComs;
    }
    @ResponseBody
    @RequestMapping("/getMoreLcom")
    public List<Map<String,Object>> getMoreLcom(@RequestParam("page")int page,@RequestParam("filmName")String filmName)
    {
        List<Map<String,Object>> lComs=new ArrayList<>();
        List<FilmLcom> lcomList=filmService.getFilmLcomByPage(filmName,page);
        for (FilmLcom lcom:lcomList){
            Map<String,Object> lMap=new HashMap<>();
            lMap.put("userName",lcom.getUser().getUsername());
            lMap.put("lComDate",lcom.getFilmLcomDate().toString());
            lMap.put("lComTitle",lcom.getTitle());
            lMap.put("lComContent",lcom.getFilmLcomContent());
            lMap.put("lComId",lcom.getFilmLcomId());
            lMap.put("like",lcom.getFilmLcomLike()==null?0:lcom.getFilmLcomLike());
            lComs.add(lMap);
        }
        return lComs;
    }

    @ResponseBody
    @RequestMapping("/likeScom")
    public Integer likeScom(@RequestParam("filmScomId")Integer id){
        FilmScom filmScom=filmService.getFilmScomById(id);
        Integer like=filmService.likeFilmScom(filmScom);
        return like;
    }
    @ResponseBody
    @RequestMapping("/likeLcom")
    public Integer likeLcom(@RequestParam("filmLcomId")Integer id){
        FilmLcom filmLcom=filmService.getFilmLcomById(id);
        Integer like=filmService.likeFilmLcom(filmLcom);
        return like;
    }
}
