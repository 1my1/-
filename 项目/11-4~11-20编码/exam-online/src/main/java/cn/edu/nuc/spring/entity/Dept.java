package cn.edu.nuc.spring.entity;

public class Dept {
    private Integer deptid;

    private String deptname;

    private Integer deptstatus;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getDeptstatus() {
        return deptstatus;
    }

    public void setDeptstatus(Integer deptstatus) {
        this.deptstatus = deptstatus;
    }
}