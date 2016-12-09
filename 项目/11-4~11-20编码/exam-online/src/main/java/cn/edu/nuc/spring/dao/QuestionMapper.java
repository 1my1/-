package cn.edu.nuc.spring.dao;

import cn.edu.nuc.spring.entity.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer tqid);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer tqid);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}