package main.daompl;

import main.dao.FilmScomDao;
import main.entities.FilmScom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tony on 2017/7/6.
 */
@Repository("filmScomDao")
public class FilmScomDaoImpl implements FilmScomDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void saveFilmScom(FilmScom filmScom) {
        getSession().save(filmScom);
    }

    @Override
    public List<FilmScom> getFilmScomsByPage(String filmName,int page,int perPage) {
        return getSession().createQuery("from FilmScom where film.filmName=?").setParameter(0,filmName).setFirstResult(page*perPage).setMaxResults(perPage).list();
    }

    @Override
    public FilmScom getFilmScomById(Integer id) {
        return getSession().get(FilmScom.class,id);
    }
}
