package com.dao;

import com.entity.Company;

public interface CompanyDao {
    int deleteById(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectById(Integer id);

    int updateByIdSelective(Company record);

    int updateById(Company record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    
}