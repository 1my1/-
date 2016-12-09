package cn.edu.nuc.spring.service.interfaces;

import cn.edu.nuc.spring.entity.Admin;

public interface IAdminService extends IBaseService{
     public Admin find(Integer aid);
}
