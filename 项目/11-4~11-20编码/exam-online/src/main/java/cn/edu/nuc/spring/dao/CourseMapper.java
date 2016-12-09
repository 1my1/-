package cn.edu.nuc.spring.dao;

import cn.edu.nuc.spring.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer couid);

	int insert(Course record);

	int insertSelective(Course record);


	

    Course selectByPrimaryKey(Integer couid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}