package cn.edu.nuc.spring.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.spring.dao.AdminMapper;
import cn.edu.nuc.spring.dao.ClassesMapper;
import cn.edu.nuc.spring.dao.DeptMapper;
import cn.edu.nuc.spring.entity.Admin;
import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.entity.Dept;
import cn.edu.nuc.spring.entity.Role;
import cn.edu.nuc.spring.service.interfaces.IAdminService;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;
@Service
public class AdminServiceImpl extends BaseServiceImpl implements IAdminService {
	@Autowired
    AdminMapper adminMapper;
	@Autowired
	DeptMapper deptMapper;
	@Autowired
	ClassesMapper classesMapper;
	@Override
	public Admin find(Integer aid) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(aid);
	}
	@Override
	public Admin checklogin(Admin admin,String sessionid) {
		
		Admin a=adminMapper.selectOneAdmin(admin);
		
		
		if(a==null){
			Log.debug("管理员登录失败----->返回值为空");
			return null;
		}else{
			if(!a.getAdsessionid().equals(sessionid)){
				
				int count=updateSessionID(sessionid,a.getAdname(),a.getAdid());
				if(count>0)
					a.setAdsessionid(sessionid);
			}
			return a;
		}
	}
	private int updateSessionID(Admin admin){
		int count=adminMapper.updateAdminBySessionID(admin);
		if(count<=0){
			return -1;
		}
		return count;
	}
	private int updateSessionID(String sessionid,String adname,Integer adid){
		
		int count=adminMapper.updateSessionID(sessionid, adname, adid);
		if(count<0){
			return -1;
		}
		return count;
	}
	/**
	 * 获取页面信息
	 */
	@Override
	public PageInfo<Admin> adminLists(Admin admin, PageControl pc) {
        PageInfo<Admin> pi=new PageInfo<Admin>();
		Integer count=rsCount(admin);
		List<Admin> adLists=adminMapper.adminLists(admin,pc);
        Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(adLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	/**
	 * 获取总记录数
	 * @param admin
	 * @return
	 */
	private Integer rsCount(Admin admin){
		
		Integer count=adminMapper.rsCount(admin);
		{
			return count;
		}
		
	}
	
	@Override
	public boolean delete(Integer adid) {
		int count=adminMapper.deleteByPrimaryKey(adid);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteMany(List<Integer> ids) {
		int count = adminMapper.deleteMany(ids);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public List<Role> loadRole() {
		
		List<Role> roleLists=adminMapper.loadRole();
		
		return roleLists;
	}
	@Override
	public boolean addAdmin(Admin admin) {
		
		int count=adminMapper.addAdmin(admin);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean doUpdate(Admin admin) {
		int count = adminMapper.doUpdate(admin);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public PageInfo<Dept> deptLists(Dept dept, PageControl pc) {
		PageInfo<Dept> pi=new PageInfo<Dept>();
		Integer count=rsCount(dept);
		List<Dept> adLists=deptMapper.deptLists(dept,pc);
        Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(adLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	private Integer rsCount(Dept dept) {
		Integer count=deptMapper.rsCount(dept);
		{
			return count;
		}
	}
	private Integer rsCount(Classes classes) {
		Integer count=adminMapper.rsCountCla(classes);
		{
			return count;
		}
	}
	@Override
	public Dept findDeptById(Integer deptid) {
		Dept dept=deptMapper.selectByPrimaryKey(deptid);
		return dept;
	}
	@Override
	public PageInfo<Classes> classesLists(Classes classes, PageControl pc) {
        PageInfo<Classes> pi=new PageInfo<Classes>();
		List<Classes> classesLists=adminMapper.classesLists(classes,pc);
		Integer count=rsCount(classes);
		Integer c=0;
		if(count!=null){
			c=count;
		}
		pi.setLists(classesLists);
		pc.setRscount(c);
		pc=dealpage(pc);
		pi.setPc(pc);
		return pi;
	}
	@Override
	public Classes findClassesById(Integer claid) {

		Classes classes=classesMapper.selectByPrimaryKey(claid);
		
		return classes;
	}
	@Override
	public boolean doUpdate(List<Integer> claid,Integer deptid) {

		for(int i=0;i<claid.size();i++){
			int count = classesMapper.doUpdate(claid.get(i),deptid);
			if(count<=0){
				return false;
			}else{
				continue;
			}
		}
		return true;
	}
      
}
