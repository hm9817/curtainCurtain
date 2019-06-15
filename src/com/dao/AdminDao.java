package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.entity.Admin;

public interface AdminDao {
    int deleteById(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectById(Integer id);

    int updateByIdSelective(Admin record);

    int updateById(Admin record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    

    @Select("select * from admin where username=#{username}")
	Admin selectByUsername(String username);    
    
    @Select("select * from admin order by id desc")
	List<Admin> getList();
}