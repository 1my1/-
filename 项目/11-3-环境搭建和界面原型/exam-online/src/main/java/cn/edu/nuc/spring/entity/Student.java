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

    private Integer deptid;

    private Integer roleid;

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
}