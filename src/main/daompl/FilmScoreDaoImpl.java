package main.daompl;

import main.dao.FilmScoreDao;
import main.entities.FilmScore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Tony on 2017/7/4.
 */
@Repository("filmScoreDao")
public class FilmScoreDaoImpl implements FilmScoreDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public FilmScore getScoreByUserAndFilm(String username, String filmName) {
        return (FilmScore) getSession().createQuery("from FilmScore where user.username =? and film.filmName=?")
                .setParameter(0,username).setParameter(1,filmName).uniqueResult();
    }

    @Override
    public void saveFilmScore(FilmScore filmScore) {
        getSession().save(filmScore);
    }
}
