package main.dao;

import main.entities.User;

import java.util.List;

/**
 * Created by Tony on 2017/6/28.
 */
public interface UserDao {
    void saveUser(User user);
    void updateUser(User user);
    User getUserByUsername(String username);
    List<User> searchUser(String username);
}
