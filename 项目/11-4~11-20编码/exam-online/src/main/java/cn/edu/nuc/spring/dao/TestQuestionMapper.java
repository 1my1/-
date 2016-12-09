package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Course;
import cn.edu.nuc.spring.entity.TestQuestion;
import cn.edu.nuc.spring.util.PageControl;

public interface TestQuestionMapper {
    int deleteByPrimaryKey(Integer tqid);

    int insert(TestQuestion record);

    int insertSelective(TestQuestion record);

    TestQuestion selectByPrimaryKey(Integer tqid);

    int updateByPrimaryKeySelective(TestQuestion record);

    int updateByPrimaryKey(TestQuestion record);

	List<TestQuestion> testQuestionLists(@Param("testQuestion")TestQuestion testQuestion, @Param("pc")PageControl pc);

	Integer rsCount(TestQuestion testQuestion);

	List<Course> courseLists();

	int updateTitleTqid(@Param("titid")Integer titid,@Param("tqid")Integer tqid);

	List<TestQuestion> tqLists();
}