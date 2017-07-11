package main.entities;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class Film {
    private int filmId;
    private String filmName;
    private String filmDirec;
    private String filmWri;
    private String filmHero;
    private String filmArea;
    private String filmType;
    private String filmLang;
    private String filmDate;
    private String filmLen;
    private String filmIntro;
    private String filmImg;
    private Double filmSc;
    private Double filmDbsc;
    private Long FilmScTime;

    private Set<FilmScom> filmScoms;
    private Set<FilmLcom> filmLcoms;

    public Set<FilmScom> getFilmScoms() {
        return filmScoms;
    }

    public void setFilmScoms(Set<FilmScom> filmScoms) {
        this.filmScoms = filmScoms;
    }

    public Set<FilmLcom> getFilmLcoms() {
        return filmLcoms;
    }

    public void setFilmLcoms(Set<FilmLcom> filmLcoms) {
        this.filmLcoms = filmLcoms;
    }

    public Long getFilmScTime() {
        return FilmScTime;
    }

    public void setFilmScTime(Long filmScTime) {
        FilmScTime = filmScTime;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmDirec() {
        return filmDirec;
    }

    public void setFilmDirec(String filmDirec) {
        this.filmDirec = filmDirec;
    }

    public String getFilmWri() {
        return filmWri;
    }

    public void setFilmWri(String filmWri) {
        this.filmWri = filmWri;
    }

    public String getFilmHero() {
        return filmHero;
    }

    public void setFilmHero(String filmHero) {
        this.filmHero = filmHero;
    }

    public String getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(String filmArea) {
        this.filmArea = filmArea;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getFilmLen() {
        return filmLen;
    }

    public void setFilmLen(String filmLen) {
        this.filmLen = filmLen;
    }

    public String getFilmIntro() {
        return filmIntro;
    }

    public void setFilmIntro(String filmIntro) {
        this.filmIntro = filmIntro;
    }

    public String getFilmImg() {
        return filmImg;
    }

    public void setFilmImg(String filmImg) {
        this.filmImg = filmImg;
    }

    public Double getFilmSc() {
        return filmSc;
    }

    public void setFilmSc(Double filmSc) {
        this.filmSc = filmSc;
    }

    public Double getFilmDbsc() {
        return filmDbsc;
    }

    public void setFilmDbsc(Double filmDbsc) {
        this.filmDbsc = filmDbsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (filmId != film.filmId) return false;
        if (filmName != null ? !filmName.equals(film.filmName) : film.filmName != null) return false;
        if (filmDirec != null ? !filmDirec.equals(film.filmDirec) : film.filmDirec != null) return false;
        if (filmWri != null ? !filmWri.equals(film.filmWri) : film.filmWri != null) return false;
        if (filmHero != null ? !filmHero.equals(film.filmHero) : film.filmHero != null) return false;
        if (filmArea != null ? !filmArea.equals(film.filmArea) : film.filmArea != null) return false;
        if (filmType != null ? !filmType.equals(film.filmType) : film.filmType != null) return false;
        if (filmLang != null ? !filmLang.equals(film.filmLang) : film.filmLang != null) return false;
        if (filmDate != null ? !filmDate.equals(film.filmDate) : film.filmDate != null) return false;
        if (filmLen != null ? !filmLen.equals(film.filmLen) : film.filmLen != null) return false;
        if (filmIntro != null ? !filmIntro.equals(film.filmIntro) : film.filmIntro != null) return false;
        if (filmImg != null ? !filmImg.equals(film.filmImg) : film.filmImg != null) return false;
        if (filmSc != null ? !filmSc.equals(film.filmSc) : film.filmSc != null) return false;
        if (filmDbsc != null ? !filmDbsc.equals(film.filmDbsc) : film.filmDbsc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + (filmName != null ? filmName.hashCode() : 0);
        result = 31 * result + (filmDirec != null ? filmDirec.hashCode() : 0);
        result = 31 * result + (filmWri != null ? filmWri.hashCode() : 0);
        result = 31 * result + (filmHero != null ? filmHero.hashCode() : 0);
        result = 31 * result + (filmArea != null ? filmArea.hashCode() : 0);
        result = 31 * result + (filmType != null ? filmType.hashCode() : 0);
        result = 31 * result + (filmLang != null ? filmLang.hashCode() : 0);
        result = 31 * result + (filmDate != null ? filmDate.hashCode() : 0);
        result = 31 * result + (filmLen != null ? filmLen.hashCode() : 0);
        result = 31 * result + (filmIntro != null ? filmIntro.hashCode() : 0);
        result = 31 * result + (filmImg != null ? filmImg.hashCode() : 0);
        result = 31 * result + (filmSc != null ? filmSc.hashCode() : 0);
        result = 31 * result + (filmDbsc != null ? filmDbsc.hashCode() : 0);
        return result;
    }
}
