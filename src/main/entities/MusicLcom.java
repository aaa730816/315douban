package main.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class MusicLcom {
    private int musicLcomId;
    private String title;
    private String musicLcomContent;
    private Timestamp musicLcomDate;
    private Integer musicLcomLike;
    private User user;
    private Music music;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public int getMusicLcomId() {
        return musicLcomId;
    }

    public void setMusicLcomId(int musicLcomId) {
        this.musicLcomId = musicLcomId;
    }

    public String getMusicLcomContent() {
        return musicLcomContent;
    }

    public void setMusicLcomContent(String musicLcomContent) {
        this.musicLcomContent = musicLcomContent;
    }

    public Timestamp getMusicLcomDate() {
        return musicLcomDate;
    }

    public void setMusicLcomDate(Timestamp musicLcomDate) {
        this.musicLcomDate = musicLcomDate;
    }

    public Integer getMusicLcomLike() {
        return musicLcomLike;
    }

    public void setMusicLcomLike(Integer musicLcomLike) {
        this.musicLcomLike = musicLcomLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicLcom musicLcom = (MusicLcom) o;

        if (user != null ? !user.getUsername().equals(musicLcom.music.getMusicName()) : musicLcom.music.getMusicName() != null)
            return false;
        if (music != null ? !music.getMusicName().equals(musicLcom.music.getMusicName()) : musicLcom.music.getMusicName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(music != null ? music.getMusicName().hashCode() : 0) + (user != null ? user.getUsername().hashCode() : 0);

        return result;
    }
}
