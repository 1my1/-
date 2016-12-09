package cn.edu.nuc.spring.entity;

public class Course {
    private Integer couid;

    private String couname;

    private String couremark;

    private Integer coustatus;

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname == null ? null : couname.trim();
    }

    public String getCouremark() {
        return couremark;
    }

    public void setCouremark(String couremark) {
        this.couremark = couremark == null ? null : couremark.trim();
    }

    public Integer getCoustatus() {
        return coustatus;
    }

    public void setCoustatus(Integer coustatus) {
        this.coustatus = coustatus;
    }
}