package cn.edu.nuc.spring.entity;

public class TestQuestion {
    private Integer tqid;

    private String tqname;
    
    private Integer couid;

    private Integer tqscore;

    private String tqinstruduce;

    private Integer duration;

    public Integer getTqid() {
        return tqid;
    }
    
    public Integer getCouid() {
		return couid;
	}

	public void setCouid(Integer couid) {
		this.couid = couid;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

	@Override
	public String toString() {
		return "TestQuestion [tqid=" + tqid + ", tqname=" + tqname + ", couid=" + couid + ", tqscore=" + tqscore
				+ ", tqinstruduce=" + tqinstruduce + ", duration=" + duration + "]";
	}
    
}