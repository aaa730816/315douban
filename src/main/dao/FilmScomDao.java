package main.dao;

import main.entities.FilmScom;

import java.util.List;

/**
 * Created by Tony on 2017/7/6.
 */
public interface FilmScomDao {
    void saveFilmScom(FilmScom filmScom);
    List<FilmScom> getFilmScomsByPage(String filmName,int page,int perPage);
    FilmScom getFilmScomById(Integer id);
}
