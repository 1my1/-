package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.entity.Title;
import cn.edu.nuc.spring.util.PageControl;

public interface TitleMapper {
    int deleteByPrimaryKey(Integer titid);

	int insert(Title record);

	int insertSelective(Title record);

    Title selectByPrimaryKey(Integer titid);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);

	List<Title> titleLists(@Param("title")Title title,@Param("pc")PageControl pc);

	Integer rsCount(Title title);


	List<Course> courseLists();

	int addTitle(Title title);

	List<TestQuestion> tqLists();
}