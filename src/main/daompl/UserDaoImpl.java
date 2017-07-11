package main.daompl;

import main.dao.UserDao;
import main.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tony on 2017/6/28.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public void saveUser(User user) {
        getSession().save(user);
    }

    public void updateUser(User user) {
        getSession().update(user);
    }

    public User getUserByUsername(String username) {
        return (User) getSession().createQuery("from User where username=?").setParameter(0,username).uniqueResult();
    }

    public List<User> searchUser(String username) {
        return getSession().createQuery("from User where username like ?").setParameter(0,"%"+username+"%").list();
    }
}
