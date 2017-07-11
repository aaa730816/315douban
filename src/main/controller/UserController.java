package main.controller;

import main.entities.User;
import main.service.UserService;
import main.util.ImageProcess;
import main.util.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2017/6/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserIcon")
    public void getUserIcon(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "image",required = false) String image) throws IOException {
//        String path = ImageProcess.ICON_PATH;
        String path=request.getSession().getServletContext().getRealPath("/");
        System.out.println(path);
        File file = new File(path+"userIcons", image);
        if (!file.exists()||image.equals("")||image==null) {
            file=new File(path+"image","user.png");
            System.out.println(file.exists());
            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            fileInputStream.close();
        }
        else {
            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            fileInputStream.close();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/changeUserIcon", method = RequestMethod.POST)
    public String changeUserIcon(HttpSession session,@RequestParam("image") MultipartFile file, @RequestParam("username") String username) {
        String path=session.getServletContext().getRealPath("/");
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String fileName = new StringBuffer().append(username).append(".").append(fileSuffix).toString();
        User user= (User) session.getAttribute("currentUser");
        if (file != null || file.getSize() != 0) {
            File srcFile = new File(fileName);
            try {
                file.transferTo(srcFile);
                user.setImage(fileName);
                ImageProcess.saveUserIcon(path,srcFile, username);
                userService.updateUser(user);
                return "Y";
            } catch (Exception e) {
                return "N";
            }
        } else
            return "N";
    }
    @ResponseBody
    @RequestMapping("/isPassRight")
    public String isPassRight(HttpSession session,@RequestParam("oriPass")String oriPass){
        User currentUser= (User) session.getAttribute("currentUser");
        try {
            oriPass= PasswordEncode.encode(currentUser.getUsername(),oriPass);
            if (currentUser.getPassword().equals(oriPass))
                return "Y";
            else
                return "N";
        } catch (Exception e) {
            e.printStackTrace();
            return "N";
        }
    }
    @RequestMapping("/toMyFriendPage")
    public String toMyFriendPage(HttpSession session, Map<String,Object> map){
        User user=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        map.put("friends",user.getFriends());
        return "myFriends";
    }
    @ResponseBody
    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,@RequestParam("newPass")String newPass){
        User user= (User) session.getAttribute("currentUser");
        try {
            newPass=PasswordEncode.encode(user.getUsername(),newPass );
            user.setPassword(newPass);
            userService.updateUser(user);
            return "Y";
        } catch (Exception e) {
            e.printStackTrace();
            return "N";
        }
    }
    @ResponseBody
    @RequestMapping("/searchUser")
    public List<String> searchUser(@RequestParam("username")String username){
        return userService.searchUser(username);
    }
    @ResponseBody
    @RequestMapping("/addFriend")
    public String addFriend(HttpSession session,@RequestParam("friendName")String friendName){
        User currentUser=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        User friend=userService.getUserByUsername(friendName);
        if (!currentUser.getFriends().contains(friend)&&!(currentUser.getUsername().equals(friend.getUsername()))){
            currentUser.getFriends().add(friend);
            userService.updateUser(currentUser);
            return "Y";
        }
        else
            return "N";
    }

    @ResponseBody
    @RequestMapping("/delFriend")
    public String delFriend(HttpSession session,@RequestParam("friendName")String friendName){
        User currentUser=userService.getUserByUsername(((User)session.getAttribute("currentUser")).getUsername());
        User friend=userService.getUserByUsername(friendName);
        System.out.println("friend:"+friend+";friends:"+currentUser.getFriends().size());
        if (currentUser.getFriends().contains(friend)) {
            currentUser.getFriends().remove(friend);
            userService.updateUser(currentUser);
            return "Y";
        }
        else {
            return "N";
        }
    }
}
