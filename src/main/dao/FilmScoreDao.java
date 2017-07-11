package main.dao;

import main.entities.FilmScore;

/**
 * Created by Tony on 2017/7/4.
 */
public interface FilmScoreDao {
    FilmScore getScoreByUserAndFilm(String username,String filmName);
    void saveFilmScore(FilmScore filmScore);
}
