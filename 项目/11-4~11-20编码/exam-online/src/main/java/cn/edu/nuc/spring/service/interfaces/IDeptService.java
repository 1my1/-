package cn.edu.nuc.spring.service.interfaces;

import java.util.List;

import cn.edu.nuc.spring.entity.Dept;

public interface IDeptService {

	boolean delete(Integer deptid);

	List<Dept> deptLists();

	boolean insertDept(Dept dept);

}
