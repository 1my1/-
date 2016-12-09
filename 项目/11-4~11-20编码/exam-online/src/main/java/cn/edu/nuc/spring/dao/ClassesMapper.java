package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Classes;
import cn.edu.nuc.spring.util.PageControl;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer claid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer claid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

	List<Classes> classesLists(@Param("classes")Classes classes,@Param("pc")PageControl pc);

	Integer rsCount(Classes classes);

	int doUpdate(@Param("claid")Integer claid,@Param("deptid")Integer deptid);

	List<Classes> claList();
}