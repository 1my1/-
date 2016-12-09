package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Dept;
import cn.edu.nuc.spring.util.PageControl;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

	Integer rsCount(Dept dept);

	List<Dept> deptLists(@Param("dept")Dept dept,@Param("pc")PageControl pc);

	List<Dept> lists();

	int doUpdate(Integer integer, Integer deptid);
}