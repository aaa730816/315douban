package main.dao;

import main.entities.FilmLcom;

import java.util.List;

/**
 * Created by Tony on 2017/7/6.
 */
public interface FilmLcomDao {
    void saveFilmLcom(FilmLcom filmLcom);
    List<FilmLcom> getFilmLcomsByPage(String filmName, int page, int perPage);
    FilmLcom getFilmLcomById(Integer id);
}
