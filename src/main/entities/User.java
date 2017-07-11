package main.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class User {
    private int userId;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", image='" + image + '\'' +
                '}';
    }

    private Date registerDate;
    private String image;
    //电影长评、短评及评分
    private Set<FilmLcom> filmLcoms=new HashSet<FilmLcom>();
    private Set<FilmScom> filmScoms=new HashSet<FilmScom>();
    private Set<FilmScore> filmScores=new HashSet<FilmScore>();
    //音乐长评、短评及评分
    private Set<MusicLcom> musicLcoms=new HashSet<MusicLcom>();
    private Set<MusicScom> musicScoms=new HashSet<MusicScom>();
    private Set<MusicScore> musicScores=new HashSet<MusicScore>();
    //书籍长评、短评及评分
    private Set<BookLcom> bookLcoms=new HashSet<BookLcom>();
    private Set<BookScom> bookScoms=new HashSet<BookScom>();
    private Set<BookScore> bookScores=new HashSet<BookScore>();
    //收藏的电影
    private Set<Film> favouriteFilms=new HashSet<Film>();
    //收藏的音乐
    private Set<Music> favouriteMusics=new HashSet<Music>();
    //收藏的书籍
    private Set<Book> favouriteBooks=new HashSet<Book>();
    //好友
    private Set<User> friends=new HashSet<User>();

    public Set<FilmLcom> getFilmLcoms() {
        return filmLcoms;
    }

    public void setFilmLcoms(Set<FilmLcom> filmLcoms) {
        this.filmLcoms = filmLcoms;
    }

    public Set<FilmScom> getFilmScoms() {
        return filmScoms;
    }

    public void setFilmScoms(Set<FilmScom> filmScoms) {
        this.filmScoms = filmScoms;
    }

    public Set<FilmScore> getFilmScores() {
        return filmScores;
    }

    public void setFilmScores(Set<FilmScore> filmScores) {
        this.filmScores = filmScores;
    }

    public Set<MusicLcom> getMusicLcoms() {
        return musicLcoms;
    }

    public void setMusicLcoms(Set<MusicLcom> musicLcoms) {
        this.musicLcoms = musicLcoms;
    }

    public Set<MusicScom> getMusicScoms() {
        return musicScoms;
    }

    public void setMusicScoms(Set<MusicScom> musicScoms) {
        this.musicScoms = musicScoms;
    }

    public Set<MusicScore> getMusicScores() {
        return musicScores;
    }

    public void setMusicScores(Set<MusicScore> musicScores) {
        this.musicScores = musicScores;
    }

    public Set<BookLcom> getBookLcoms() {
        return bookLcoms;
    }

    public void setBookLcoms(Set<BookLcom> bookLcoms) {
        this.bookLcoms = bookLcoms;
    }

    public Set<BookScom> getBookScoms() {
        return bookScoms;
    }

    public void setBookScoms(Set<BookScom> bookScoms) {
        this.bookScoms = bookScoms;
    }

    public Set<BookScore> getBookScores() {
        return bookScores;
    }

    public void setBookScores(Set<BookScore> bookScores) {
        this.bookScores = bookScores;
    }

    public Set<Film> getFavouriteFilms() {
        return favouriteFilms;
    }

    public void setFavouriteFilms(Set<Film> favouriteFilms) {
        this.favouriteFilms = favouriteFilms;
    }

    public Set<Music> getFavouriteMusics() {
        return favouriteMusics;
    }

    public void setFavouriteMusics(Set<Music> favouriteMusics) {
        this.favouriteMusics = favouriteMusics;
    }

    public Set<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public void setFavouriteBooks(Set<Book> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (registerDate != null ? !registerDate.equals(user.registerDate) : user.registerDate != null) return false;
        if (image != null ? !image.equals(user.image) : user.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
