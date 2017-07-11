package main.controller;

import main.entities.User;
import main.service.UserService;
import main.util.CreateImageCode;
import main.util.ImageProcess;
import main.util.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Tony on 2017/6/28.
 */
@SessionAttributes(names = {"currentUser"})
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private CreateImageCode createImageCode;
    @Autowired
    private UserService userService;
    private static String imageCode = null;

    //定位至电影首页
    @RequestMapping("/toMainPage")
    public String toMainPage() {
        return "filmMain";
    }

    //获取验证码返回到前端
    @RequestMapping(value = "/getImageCode", method = RequestMethod.GET)
    public void getImageCode(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setCharacterEncoding("utf-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            createImageCode.creatImage();
            createImageCode.write(outputStream);
            imageCode = createImageCode.getCode();
            System.out.println(imageCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //用户注册
    @ResponseBody
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request,
                             @RequestParam(value = "image", required = false) MultipartFile file,
                             @RequestParam(value = "username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("imageCode") String imageCode) throws IOException {
        String path=request.getSession().getServletContext().getRealPath("/");
        try {
            password = PasswordEncode.encode(username, password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "N";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (file != null && file.getSize() > 0) {
            String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            String fileName = new StringBuffer().append(username).append(".").append(fileSuffix).toString();
            File srcFile = new File(fileName);
            file.transferTo(srcFile);
            user.setImage(fileName);
            try {
                ImageProcess.saveUserIcon(path,srcFile, username);
            } catch (Exception e) {
                e.printStackTrace();
                return "N";
            }
        }
        user.setRegisterDate(new Date());
        userService.saveUser(user);
        return "Y";

    }

    //验证用户是否存在
    @ResponseBody
    @RequestMapping("/isUserExist")
    public String isUserExist(@RequestParam("username") String username) {
        boolean isExist = userService.isUserExist(username);
        if (isExist)
            return "Y";
        else
            return "N";
    }

    //验证码输入是否正确
    @ResponseBody
    @RequestMapping("/isCodeRight")
    public String isCodeRight(@RequestParam("imageCode") String code) {
        if (imageCode.equalsIgnoreCase(code))
            return "Y";
        else
            return "N";
    }

    //登陆
    @ResponseBody
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (userService.isUserExist(username)) {
            User user = userService.getUserByUsername(username);
            password = PasswordEncode.encode(username, password);
            if (user.getPassword().equals(password)) {
                map.put("currentUser", user);
                return "Y";
            } else
                return "N";
        } else
            return "N";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:toMainPage";
    }
}
