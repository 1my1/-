package cn.edu.nuc.spring.service.interfaces;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Admin;
import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.entity.Dept;
import cn.edu.nuc.spring.entity.Role;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface IAdminService extends IBaseService{
     public Admin find(Integer aid);

	public Admin checklogin(Admin admin,String sessionid);

	public PageInfo<Admin> adminLists(Admin admin, PageControl pc);

	public boolean delete(Integer adid);

	public boolean deleteMany(List<Integer> ids);

	public List<Role> loadRole();

	public boolean addAdmin(Admin admin);

	public boolean doUpdate(Admin admin);

	public PageInfo<Dept> deptLists(Dept dept, PageControl pc);

	public Dept findDeptById(Integer deptid);

	public PageInfo<Classes> classesLists(Classes classes,PageControl pc);

	public Classes findClassesById(Integer claid);

	public boolean doUpdate(List<Integer> claid,Integer deptid);
}
