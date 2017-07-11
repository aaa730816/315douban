package main.daompl;

import main.dao.FilmLcomDao;
import main.dao.FilmScomDao;
import main.entities.FilmLcom;
import main.entities.FilmScom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tony on 2017/7/6.
 */
@Repository("filmLcomDao")
public class FilmLcomDaoImpl implements FilmLcomDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void saveFilmLcom(FilmLcom filmLcom) {
        getSession().save(filmLcom);
    }

    @Override
    public List<FilmLcom> getFilmLcomsByPage(String filmName, int page, int perPage) {
        return getSession().createQuery("from FilmLcom where film.filmName=?").setParameter(0,filmName).setFirstResult(page*perPage).setMaxResults(perPage).list();
    }

    @Override
    public FilmLcom getFilmLcomById(Integer id) {
        return getSession().get(FilmLcom.class,id);
    }
}
