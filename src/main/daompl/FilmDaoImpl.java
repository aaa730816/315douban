package main.daompl;

import main.dao.FilmDao;
import main.entities.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2017/7/3.
 */
@Repository("filmDao")
public class FilmDaoImpl implements FilmDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public List<Film> getAll() {
        return getSession().createQuery("from Film ").list();
    }

    public List<Film> getFilmByType(String type,int page,int max) {
        return getSession().createQuery("from Film where filmType like ?").
                setParameter(0,"%"+type+"%").setFirstResult((page-1)*10).setMaxResults(max).list();
    }

    @Override
    public Film getFilmByName(String filmName) {
        return (Film) getSession().createQuery("from Film where filmName=?").setParameter(0,filmName).uniqueResult();
    }

    @Override
    public void updateFilm(Film film) {
        getSession().update(film);
    }
}
