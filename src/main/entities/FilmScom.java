package main.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class FilmScom {
    private int filmScomId;
    private String filmScomContent;
    private Date filmScomDate;
    private Integer filmScomLike;
    private User user;
    private Film film;
    private Set<Comment> comments=new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    public int getFilmScomId() {
        return filmScomId;
    }

    public void setFilmScomId(int filmScomId) {
        this.filmScomId = filmScomId;
    }

    public String getFilmScomContent() {
        return filmScomContent;
    }

    public void setFilmScomContent(String filmScomContent) {
        this.filmScomContent = filmScomContent;
    }

    public Date getFilmScomDate() {
        return filmScomDate;
    }

    public void setFilmScomDate(Date filmScomDate) {
        this.filmScomDate = filmScomDate;
    }

    public Integer getFilmScomLike() {
        return filmScomLike;
    }

    public void setFilmScomLike(Integer filmScomLike) {
        this.filmScomLike = filmScomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmScom filmScom = (FilmScom) o;

        if (user != null ? !user.getUsername().equals(filmScom.user.getUsername()) : filmScom.user.getUsername() != null)
            return false;
        if (film != null ? !film.getFilmName().equals(filmScom.film.getFilmName()) : filmScom.film.getFilmName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(film != null ? film.getFilmName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
