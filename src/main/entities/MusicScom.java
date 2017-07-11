package main.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class MusicScom {
    private int musicScomId;
    private String musicScomContent;
    private Timestamp musicScomDate;
    private Integer musicScomLike;
    private User user;
    private Music music;
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

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
    public int getMusicScomId() {
        return musicScomId;
    }

    public void setMusicScomId(int musicScomId) {
        this.musicScomId = musicScomId;
    }

    public String getMusicScomContent() {
        return musicScomContent;
    }

    public void setMusicScomContent(String musicScomContent) {
        this.musicScomContent = musicScomContent;
    }

    public Timestamp getMusicScomDate() {
        return musicScomDate;
    }

    public void setMusicScomDate(Timestamp musicScomDate) {
        this.musicScomDate = musicScomDate;
    }

    public Integer getMusicScomLike() {
        return musicScomLike;
    }

    public void setMusicScomLike(Integer musicScomLike) {
        this.musicScomLike = musicScomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicScom musicScom = (MusicScom) o;

        if (user != null ? !user.getUsername().equals(musicScom.music.getMusicName()) : musicScom.music.getMusicName() != null)
            return false;
        if (music != null ? !music.getMusicName().equals(musicScom.music.getMusicName()) : musicScom.music.getMusicName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(music != null ? music.getMusicName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);

        return result;
    }
}
