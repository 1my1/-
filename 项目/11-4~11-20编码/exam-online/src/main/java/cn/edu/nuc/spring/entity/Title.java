package cn.edu.nuc.spring.entity;

public class Title {
    private Integer titid;

    private String titname;

    private String titA;

    private String titB;

    private String titC;

    private String titD;

    private String titE;

    private String titF;

    private Integer titanswer;

    private Integer titscore;

    private Integer couid;
    
    private String couname;

    private Integer tqid;
    
    private String tqname;

    public Integer getTitid() {
        return titid;
    }

    public void setTitid(Integer titid) {
        this.titid = titid;
    }

    public String getTitname() {
        return titname;
    }

    public void setTitname(String titname) {
        this.titname = titname == null ? null : titname.trim();
    }

    public String getTitA() {
        return titA;
    }

    public void setTitA(String titA) {
        this.titA = titA == null ? null : titA.trim();
    }

    public String getTitB() {
        return titB;
    }

    public void setTitB(String titB) {
        this.titB = titB == null ? null : titB.trim();
    }

    public String getTitC() {
        return titC;
    }

    public void setTitC(String titC) {
        this.titC = titC == null ? null : titC.trim();
    }

    public String getTitD() {
        return titD;
    }

    public void setTitD(String titD) {
        this.titD = titD == null ? null : titD.trim();
    }

    public String getTitE() {
        return titE;
    }

    public void setTitE(String titE) {
        this.titE = titE == null ? null : titE.trim();
    }

    public String getTitF() {
        return titF;
    }

    public void setTitF(String titF) {
        this.titF = titF == null ? null : titF.trim();
    }

    public Integer getTitanswer() {
        return titanswer;
    }

    public void setTitanswer(Integer titanswer) {
        this.titanswer = titanswer;
    }

    public Integer getTitscore() {
        return titscore;
    }

    public void setTitscore(Integer titscore) {
        this.titscore = titscore;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getTqid() {
        return tqid;
    }

    public void setTqid(Integer tqid) {
        this.tqid = tqid;
    }

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public String getTqname() {
		return tqname;
	}

	public void setTqname(String tqname) {
		this.tqname = tqname;
	}

	@Override
	public String toString() {
		return "Title [titid=" + titid + ", titname=" + titname + ", titA=" + titA + ", titB=" + titB + ", titC=" + titC
				+ ", titD=" + titD + ", titE=" + titE + ", titF=" + titF + ", titanswer=" + titanswer + ", titscore="
				+ titscore + ", couid=" + couid + ", couname=" + couname + ", tqid=" + tqid + ", tqname=" + tqname
				+ "]";
	}
    
}