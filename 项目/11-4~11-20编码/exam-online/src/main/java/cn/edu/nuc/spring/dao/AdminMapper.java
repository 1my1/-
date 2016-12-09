package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Admin;
import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.entity.Role;
import cn.edu.nuc.spring.util.PageControl;
import cn.edu.nuc.spring.util.PageInfo;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

	Admin selectOneAdmin(Admin admin);
	
	int updateAdminBySessionID(Admin admin);
	
	int updateSessionID(@Param("sessionid")String sessionid,@Param("adname")String adname,@Param("adid")Integer adid);

	List<Admin> adminLists(@Param("admin")Admin admin,@Param("pc")PageControl pc);

	int rsCount(Admin admin);

	int deleteMany(List<Integer> ids);
	
	List<Role> loadRole();

	int addAdmin(Admin admin);

	int doUpdate(Admin admin);

	Integer rsCountCla(Classes classes);

	List<Classes> classesLists(@Param("classes")Classes classes,@Param("pc")PageControl pc);
}