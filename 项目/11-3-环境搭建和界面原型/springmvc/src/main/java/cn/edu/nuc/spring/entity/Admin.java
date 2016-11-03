package cn.edu.nuc.spring.entity;

public class Admin {
    private Integer adid;

    private String adname;

    private String adpass;

    private Integer roleid;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }

    public String getAdpass() {
        return adpass;
    }

    public void setAdpass(String adpass) {
        this.adpass = adpass == null ? null : adpass.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}