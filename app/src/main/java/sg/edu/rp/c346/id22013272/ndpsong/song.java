package sg.edu.rp.c346.id22013272.ndpsong;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class song implements Serializable {
    private int id;
    private String title;
    private String singer;
    private String songContent;

    private int year;
    private int star;
    public song(int id, String songContent, String title, String singer, int year, int star) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.star = star;
        this.songContent=songContent;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getSinger() {
        return singer;
    }

    public String getSongContent() {
        return songContent;
    }

    public void setSongContent(String songContent) {
        this.songContent = songContent;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return star;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public String toString() { return "ID:" + id + ", " + songContent;  }
}
