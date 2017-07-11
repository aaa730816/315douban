package main.entities;

/**
 * Created by Dell on 2017/6/27.
 */
public class FilmScore {
    private int filmScoreId;
    private Double filmScore;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Film film;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    public int getFilmScoreId() {
        return filmScoreId;
    }

    public void setFilmScoreId(int filmScoreId) {
        this.filmScoreId = filmScoreId;
    }

    public Double getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(Double filmScore) {
        this.filmScore = filmScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmScore filmScore1 = (FilmScore) o;

        if (user.getUsername() != filmScore1.user.getUsername()) return false;
        if (film.getFilmName() != null ? !film.getFilmName().equals(filmScore1.film.getFilmName()) : filmScore1.film.getFilmName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =  (film!= null ? film.getFilmName().hashCode() : 0) + (user!= null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
