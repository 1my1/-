package cn.edu.nuc.spring.dao;

import cn.edu.nuc.spring.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}