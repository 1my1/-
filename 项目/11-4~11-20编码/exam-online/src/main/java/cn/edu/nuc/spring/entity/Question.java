package cn.edu.nuc.spring.entity;

import java.util.Date;

public class Question {
    private Integer tqid;

    private String tqname;

    private Integer tqscore;

    private String tqinstruduce;

    private Date tqstarttime;

    private Date tqstoptime;

    public Integer getTqid() {
        return tqid;
    }

    public void setTqid(Integer tqid) {
        this.tqid = tqid;
    }

    public String getTqname() {
        return tqname;
    }

    public void setTqname(String tqname) {
        this.tqname = tqname == null ? null : tqname.trim();
    }

    public Integer getTqscore() {
        return tqscore;
    }

    public void setTqscore(Integer tqscore) {
        this.tqscore = tqscore;
    }

    public String getTqinstruduce() {
        return tqinstruduce;
    }

    public void setTqinstruduce(String tqinstruduce) {
        this.tqinstruduce = tqinstruduce == null ? null : tqinstruduce.trim();
    }

    public Date getTqstarttime() {
        return tqstarttime;
    }

    public void setTqstarttime(Date tqstarttime) {
        this.tqstarttime = tqstarttime;
    }

    public Date getTqstoptime() {
        return tqstoptime;
    }

    public void setTqstoptime(Date tqstoptime) {
        this.tqstoptime = tqstoptime;
    }
}