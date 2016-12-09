package cn.edu.nuc.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.AdminMapper;
import cn.edu.nuc.spring.entity.Admin;
import cn.edu.nuc.spring.service.interfaces.IAdminService;
@Service
public class AdminServiceImpl extends BaseServiceImpl implements IAdminService {
	@Autowired
    AdminMapper adminMapper;
	@Override
	public Admin find(Integer aid) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(aid);
	}
      
}
