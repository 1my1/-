package cn.edu.nuc.spring.dao;

import cn.edu.nuc.spring.entity.ExamFinished;

public interface ExamFinishedMapper {
    int deleteByPrimaryKey(Integer efid);

    int insert(ExamFinished record);

    int insertSelective(ExamFinished record);

    ExamFinished selectByPrimaryKey(Integer efid);

    int updateByPrimaryKeySelective(ExamFinished record);

    int updateByPrimaryKey(ExamFinished record);
}