package cn.edu.nuc.spring.entity;

public class Classes {
    private Integer claid;

    private String claname;

    private Integer clastatus;

    private Integer deptid;
    
    private String deptname;

    public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }

    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname == null ? null : claname.trim();
    }

    public Integer getClastatus() {
        return clastatus;
    }

    public void setClastatus(Integer clastatus) {
        this.clastatus = clastatus;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}