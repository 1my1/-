package cn.edu.nuc.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.spring.entity.Exam;
import cn.edu.nuc.spring.entity.ExamFinished;
import cn.edu.nuc.spring.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	Student selectOneStudent(Student student);

	int updateSessionID(@Param("sessionid")String sessionid, @Param("stuname")String stuname,@Param("stuid")Integer stuid);

	List<Exam> examLists(@Param("stuname")String stuname);

	List<ExamFinished> historyExamList(@Param("stuname")String stuname);
}