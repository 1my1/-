package cn.edu.nuc.spring.entity;

import java.util.Date;

public class Student {
    private Integer stuid;

    private String stuname;

    private String stupass;

    private String stuemail;

    private String stuphone;

    private Date stubirth;

    private Integer stusex;

    private Integer claid;
    private Integer claname;

    private Integer deptid;
    private String deptname;

    private Integer roleid;
    private Integer rolename;
    
    private String sessionid;
    

    public Integer getClaname() {
		return claname;
	}

	public void setClaname(Integer claname) {
		this.claname = claname;
	}

    
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getRolename() {
		return rolename;
	}

	public void setRolename(Integer rolename) {
		this.rolename = rolename;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStupass() {
        return stupass;
    }

    public void setStupass(String stupass) {
        this.stupass = stupass == null ? null : stupass.trim();
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail == null ? null : stuemail.trim();
    }

    public String getStuphone() {
        return stuphone;
    }

    public void setStuphone(String stuphone) {
        this.stuphone = stuphone == null ? null : stuphone.trim();
    }

    public Date getStubirth() {
        return stubirth;
    }

    public void setStubirth(Date stubirth) {
        this.stubirth = stubirth;
    }

    public Integer getStusex() {
        return stusex;
    }

    public void setStusex(Integer stusex) {
        this.stusex = stusex;
    }

    public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", stupass=" + stupass + ", stuemail=" + stuemail
				+ ", stuphone=" + stuphone + ", stubirth=" + stubirth + ", stusex=" + stusex + ", claid=" + claid
				+ ", claname=" + claname + ", deptid=" + deptid + ", deptname=" + deptname + ", roleid=" + roleid
				+ ", rolename=" + rolename + ", sessionid=" + sessionid + "]";
	}
    
}