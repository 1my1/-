package cn.edu.nuc.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.DeptMapper;
import cn.edu.nuc.spring.entity.Dept;
import cn.edu.nuc.spring.service.interfaces.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private DeptMapper deptMapper;
	@Override
	public boolean delete(Integer deptid) {
		Integer count=deptMapper.deleteByPrimaryKey(deptid);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public List<Dept> deptLists() {

		List<Dept> deptLists=deptMapper.lists();
		
		return null;
	}
	@Override
	public boolean insertDept(Dept dept) {

		Integer count = deptMapper.insertSelective(dept);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

}
