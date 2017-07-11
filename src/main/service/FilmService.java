package main.service;

import main.dao.*;
import main.entities.*;
import main.util.CountFilmTypeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Tony on 2017/7/3.
 */
@Service
public class FilmService {
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private FilmScoreDao filmScoreDao;
    @Autowired
    private FilmScomDao filmScomDao;
    @Autowired
    private FilmLcomDao filmLcomDao;

    public Set<String> getAllTypes() {
        Set<String> types = new HashSet<String>();
        ForkJoinPool pool = new ForkJoinPool();
        List<Film> films = filmDao.getAll();
        CountFilmTypeTask task = new CountFilmTypeTask(films, 0, films.size());
        Future<Set<String>> result = pool.submit(task);
        try {
            types = result.get();
            pool.shutdown();
            return types;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void updateFilm(Film film){
        filmDao.updateFilm(film);
    }
    public List<Film> getFilmByType(String type,int page,int max){
        return filmDao.getFilmByType(type,page,max);
    }

    public Film getFilmByName(String filmName){
        return filmDao.getFilmByName(filmName);
    }

    public FilmScore getScoreByUserAndFilm(String username,String filmName){
        return filmScoreDao.getScoreByUserAndFilm(username,filmName);
    }

    public void saveFilmScore(FilmScore filmScore){
        filmScoreDao.saveFilmScore(filmScore);
    }

    public void setScore(User user,Film film,Double score){
        Long filmScTime=film.getFilmScTime();
        Double filmSc=film.getFilmSc();
        if (filmScTime==null)
            filmScTime=0L;
        if (filmSc==null)
            filmSc=0.0;
        filmSc=(filmSc*filmScTime+score)/(filmScTime+1);
        film.setFilmSc(filmSc);
        film.setFilmScTime(filmScTime+1);
        filmDao.updateFilm(film);

        FilmScore filmScore=new FilmScore();
        filmScore.setFilm(film);
        filmScore.setFilmScore(score);
        filmScore.setUser(user);

        user.getFilmScores().add(filmScore);
        userDao.updateUser(user);
        filmScoreDao.saveFilmScore(filmScore);
    }

    public String adddFilmScom(String comment,Film film,User user){
        FilmScom filmScom=new FilmScom();
        filmScom.setFilm(film);
        filmScom.setUser(user);
        if (film.getFilmScoms().contains(filmScom))
            return "N";
        filmScom.setFilmScomContent(comment);
        filmScom.setFilmScomDate(new Date());

        film.getFilmScoms().add(filmScom);
        user.getFilmScoms().add(filmScom);

        userDao.updateUser(user);
        filmDao.updateFilm(film);
        filmScomDao.saveFilmScom(filmScom);
        return "Y";
    }
    public String adddFilmLcom(String title,String comment,Film film,User user){
        FilmLcom filmLcom=new FilmLcom();
        filmLcom.setFilm(film);
        filmLcom.setUser(user);
        if (film.getFilmLcoms().contains(filmLcom))
            return "N";
        filmLcom.setFilmLcomDate(new Date());
        filmLcom.setTitle(title);
        filmLcom.setFilmLcomContent(comment);

        film.getFilmLcoms().add(filmLcom);
        user.getFilmLcoms().add(filmLcom);

        userDao.updateUser(user);
        filmDao.updateFilm(film);
        filmLcomDao.saveFilmLcom(filmLcom);
        return "Y";
    }

    public List<FilmScom> getFilmScomByPage(String filmName,int page){
        return filmScomDao.getFilmScomsByPage(filmName,page,5);
    }
    public List<FilmLcom> getFilmLcomByPage(String filmName,int page){
        return filmLcomDao.getFilmLcomsByPage(filmName,page,5);
    }
    public FilmScom getFilmScomById(Integer id){
        return filmScomDao.getFilmScomById(id);
    }
    public FilmLcom getFilmLcomById(Integer id){
        return filmLcomDao.getFilmLcomById(id);
    }
    public Integer likeFilmScom(FilmScom filmScom){
        Integer like=(filmScom.getFilmScomLike()==null?0:filmScom.getFilmScomLike())+1;
        filmScom.setFilmScomLike(like);
        filmScomDao.saveFilmScom(filmScom);
        return like;
    }
    public Integer likeFilmLcom(FilmLcom filmLcom){
        Integer like=(filmLcom.getFilmLcomLike()==null?0:filmLcom.getFilmLcomLike())+1;
        filmLcom.setFilmLcomLike(like);
        filmLcomDao.saveFilmLcom(filmLcom);
        return like;
    }
}
