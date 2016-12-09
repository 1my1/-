package cn.edu.nuc.spring.entity;

import java.io.Serializable;

public class Role implements Serializable{
    private Integer roleid;

    private String rolename;

    private String rolestatus;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus == null ? null : rolestatus.trim();
    }

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", rolestatus=" + rolestatus + "]";
	}
    
}