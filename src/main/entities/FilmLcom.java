package main.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class FilmLcom {
    private int filmLcomId;
    private String title;
    private String filmLcomContent;
    private Date filmLcomDate;
    private Integer filmLcomLike;
    private User user;
    private Film film;
    private Set<Comment> comments=new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


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

    public int getFilmLcomId() {
        return filmLcomId;
    }

    public void setFilmLcomId(int filmLcomId) {
        this.filmLcomId = filmLcomId;
    }

    public String getFilmLcomContent() {
        return filmLcomContent;
    }

    public void setFilmLcomContent(String filmLcomContent) {
        this.filmLcomContent = filmLcomContent;
    }

    public Date getFilmLcomDate() {
        return filmLcomDate;
    }

    public void setFilmLcomDate(Date filmLcomDate) {
        this.filmLcomDate = filmLcomDate;
    }

    public Integer getFilmLcomLike() {
        return filmLcomLike;
    }

    public void setFilmLcomLike(Integer filmLcomLike) {
        this.filmLcomLike = filmLcomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmLcom filmLcom = (FilmLcom) o;

        if (user != null ? !user.getUsername().equals(filmLcom.user.getUsername()) : filmLcom.user.getUsername() != null)
            return false;
        if (film != null ? !film.getFilmName().equals(filmLcom.film.getFilmName()) : filmLcom.film.getFilmName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(film != null ? film.getFilmName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
