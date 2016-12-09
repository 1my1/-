package cn.edu.nuc.spring.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class Admin {
    private Integer adid;
    @NotEmpty
    private String adname;
    @NotEmpty
    private String adpass;

    private Role role;

    private String adsessionid;
    
	public String getAdsessionid() {
		return adsessionid;
	}

	public void setAdsessionid(String adsessionid) {
		this.adsessionid = adsessionid;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adid=" + adid + ", adname=" + adname + ", adpass=" + adpass + ", role=" + role + ", adsessionid="
				+ adsessionid + "]";
	}

	

	
    
}