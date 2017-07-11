package main.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017/6/27.
 */
public class Music {
    private int musicId;
    private String musicName;
    private String musicSinger;
    private String musicType;
    private String musicDate;
    private String musicPub;
    private String musicIntro;
    private String musicSongs;
    private Double musicSc;
    private Double musicDbsc;
    private Long musicScTime;
    private Set<MusicScom> musicScoms=new HashSet<>();
    private Set<MusicLcom> musicLcoms=new HashSet<>();

    public Set<MusicScom> getMusicScoms() {
        return musicScoms;
    }

    public void setMusicScoms(Set<MusicScom> musicScoms) {
        this.musicScoms = musicScoms;
    }

    public Set<MusicLcom> getMusicLcoms() {
        return musicLcoms;
    }

    public void setMusicLcoms(Set<MusicLcom> musicLcoms) {
        this.musicLcoms = musicLcoms;
    }

    public Long getMusicScTime() {
        return musicScTime;
    }

    public void setMusicScTime(Long musicScTime) {
        this.musicScTime = musicScTime;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getMusicDate() {
        return musicDate;
    }

    public void setMusicDate(String musicDate) {
        this.musicDate = musicDate;
    }

    public String getMusicPub() {
        return musicPub;
    }

    public void setMusicPub(String musicPub) {
        this.musicPub = musicPub;
    }

    public String getMusicIntro() {
        return musicIntro;
    }

    public void setMusicIntro(String musicIntro) {
        this.musicIntro = musicIntro;
    }

    public String getMusicSongs() {
        return musicSongs;
    }

    public void setMusicSongs(String musicSongs) {
        this.musicSongs = musicSongs;
    }

    public Double getMusicSc() {
        return musicSc;
    }

    public void setMusicSc(Double musicSc) {
        this.musicSc = musicSc;
    }

    public Double getMusicDbsc() {
        return musicDbsc;
    }

    public void setMusicDbsc(Double musicDbsc) {
        this.musicDbsc = musicDbsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        if (musicId != music.musicId) return false;
        if (musicName != null ? !musicName.equals(music.musicName) : music.musicName != null) return false;
        if (musicSinger != null ? !musicSinger.equals(music.musicSinger) : music.musicSinger != null) return false;
        if (musicType != null ? !musicType.equals(music.musicType) : music.musicType != null) return false;
        if (musicDate != null ? !musicDate.equals(music.musicDate) : music.musicDate != null) return false;
        if (musicPub != null ? !musicPub.equals(music.musicPub) : music.musicPub != null) return false;
        if (musicIntro != null ? !musicIntro.equals(music.musicIntro) : music.musicIntro != null) return false;
        if (musicSongs != null ? !musicSongs.equals(music.musicSongs) : music.musicSongs != null) return false;
        if (musicSc != null ? !musicSc.equals(music.musicSc) : music.musicSc != null) return false;
        if (musicDbsc != null ? !musicDbsc.equals(music.musicDbsc) : music.musicDbsc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = musicId;
        result = 31 * result + (musicName != null ? musicName.hashCode() : 0);
        result = 31 * result + (musicSinger != null ? musicSinger.hashCode() : 0);
        result = 31 * result + (musicType != null ? musicType.hashCode() : 0);
        result = 31 * result + (musicDate != null ? musicDate.hashCode() : 0);
        result = 31 * result + (musicPub != null ? musicPub.hashCode() : 0);
        result = 31 * result + (musicIntro != null ? musicIntro.hashCode() : 0);
        result = 31 * result + (musicSongs != null ? musicSongs.hashCode() : 0);
        result = 31 * result + (musicSc != null ? musicSc.hashCode() : 0);
        result = 31 * result + (musicDbsc != null ? musicDbsc.hashCode() : 0);
        return result;
    }
}
