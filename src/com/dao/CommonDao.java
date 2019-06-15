package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.entity.Common;

public interface CommonDao {
    int deleteById(Integer id);

    int insert(Common record);

    int insertSelective(Common record);

    Common selectById(Integer id);

    int updateByIdSelective(Common record);

    int updateById(Common record);
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    @Select("select value from common where type=#{type}")
    List<String> getList(byte type);
    
    @Select("select value from common where type=#{type} limit 1")
    String get(byte type);
    
    @Delete("delete from common where type=#{type}")
    int delete(byte type);
}