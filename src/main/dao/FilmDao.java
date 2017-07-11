package main.dao;

import main.entities.Film;

import java.util.List;

/**
 * Created by Tony on 2017/7/2.
 */
public interface FilmDao {
    List<Film> getAll();
    List<Film> getFilmByType(String type,int page,int max);
    Film getFilmByName(String filmName);
    void updateFilm(Film film);
}
