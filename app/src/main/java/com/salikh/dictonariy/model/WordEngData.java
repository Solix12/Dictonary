package com.salikh.dictonariy.model;

public class WordEngData {

    private String eng;
    private String uzb;
    private int id;
    private int tick;

    public WordEngData(int tick) {
        this.tick = tick;
    }

    public WordEngData(String eng, String uzb, int id) {
        this.eng = eng;
        this.uzb = uzb;
        this.id = id;
    }

    public WordEngData(String eng, String uzb) {
        this.eng = eng;
        this.uzb = uzb;
    }

    public WordEngData(String eng) {
        this.eng = eng;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getUzb() {
        return uzb;
    }

    public void setUzb(String uzb) {
        this.uzb = uzb;
    }

    @Override
    public String toString() {
        return "WordEngData{" +
                "eng='" + eng + '\'' +
                ", uzb='" + uzb + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
