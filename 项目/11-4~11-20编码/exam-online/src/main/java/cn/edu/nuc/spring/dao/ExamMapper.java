package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.util.PageControl;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

	List<Exam> examLists(@Param("exam")Exam exam,@Param("pc")PageControl pc);

	Integer rsCount(Exam exam);
}