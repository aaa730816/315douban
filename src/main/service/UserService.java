package main.service;

import main.dao.UserDao;
import main.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 2017/6/28.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void saveUser(User user){
        userDao.saveUser(user);
    }
    public boolean isUserExist(String username){
        if (userDao.getUserByUsername(username)!=null)
            return true;
        else
            return false;
    }
    public User getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    public List<String> searchUser(String username){
        List<User> users=userDao.searchUser(username);
        if (users!=null&&users.size()>0){
            List<String> usernames=new ArrayList<String>();
            for (User u:users) {
                usernames.add(u.getUsername());
            }
            return usernames;
        }
        else
            return null;
    }
}
