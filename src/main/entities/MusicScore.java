package main.entities;

/**
 * Created by Dell on 2017/6/27.
 */
public class MusicScore {
    private int musicScoreId;
    private Double musicScore;
    private User user;
    private Music music;

    public void setMusicScore(Double musicScore) {
        this.musicScore = musicScore;
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
    public int getMusicScoreId() {
        return musicScoreId;
    }

    public void setMusicScoreId(int musicScoreId) {
        this.musicScoreId = musicScoreId;
    }

    public double getMusicScore() {
        return musicScore;
    }

    public void setMusicScore(double musicScore) {
        this.musicScore = musicScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicScore that = (MusicScore) o;

        if (user.getUsername() != that.user.getUsername()) return false;
        if (music.getMusicName() != null ? !music.getMusicName().equals(that.music.getMusicName()) : that.music.getMusicName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (music.getMusicName() != null ? music.getMusicName().hashCode() : 0) + (user.getUsername() != null ? user.getUsername().hashCode() : 0);
        return result;
    }
}
