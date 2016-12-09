package cn.edu.nuc.spring.entity;

public class ExamFinished {
    private Integer efid;

    private Integer stuid;
    private String stuname;

    private Integer stuscore;

    private Integer examid;
    
    private String examname;

    private Integer tqid;
    private String tqname;

    public Integer getEfid() {
        return efid;
    }

    public void setEfid(Integer efid) {
        this.efid = efid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getStuscore() {
        return stuscore;
    }

    public void setStuscore(Integer stuscore) {
        this.stuscore = stuscore;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getTqid() {
        return tqid;
    }

    public void setTqid(Integer tqid) {
        this.tqid = tqid;
    }

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getTqname() {
		return tqname;
	}

	public void setTqname(String tqname) {
		this.tqname = tqname;
	}

	@Override
	public String toString() {
		return "ExamFinished [efid=" + efid + ", stuid=" + stuid + ", stuname=" + stuname + ", stuscore=" + stuscore
				+ ", examid=" + examid + ", examname=" + examname + ", tqid=" + tqid + ", tqname=" + tqname + "]";
	}
}