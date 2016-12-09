package cn.edu.nuc.spring.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Exam {
    private Integer examid;

    private String examname;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date examstarttime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date examstoptime;

    private Integer claid;
    
    private String claname;

    private Integer tqid;
    
    private String tqname;

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname == null ? null : examname.trim();
    }

    public Date getExamstarttime() {
        return examstarttime;
    }

    public void setExamstarttime(Date examstarttime) {
        this.examstarttime = examstarttime;
    }

    public Date getExamstoptime() {
        return examstoptime;
    }

    public void setExamstoptime(Date examstoptime) {
        this.examstoptime = examstoptime;
    }

    public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }

    public Integer getTqid() {
        return tqid;
    }

    public void setTqid(Integer tqid) {
        this.tqid = tqid;
    }

	public String getClaname() {
		return claname;
	}

	public void setClaname(String claname) {
		this.claname = claname;
	}

	public String getTqname() {
		return tqname;
	}

	public void setTqname(String tqname) {
		this.tqname = tqname;
	}
	//{examid}
	@Override
	public String toString() {
		return "{\"examid\":" + examid + ",\"examname\":" + examname + ",\"examstarttime\":" + examstarttime
				+ ",\"examstoptime\":" + examstoptime + ",\"claid\":" + claid + ",\"claname\":" + claname + ",\"tqid\":" + tqid
				+ ",\"tqname\":" + tqname + "}";
	}

	
	
    
}