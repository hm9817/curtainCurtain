package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Gbook;

public interface GbookDao {
    int deleteById(Integer id);

    int insert(Gbook record);

    int insertSelective(Gbook record);

    Gbook selectById(Integer id);

    int updateByIdSelective(Gbook record);

    int updateById(Gbook record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    
    @Select("select * from gbook order by id desc limit #{begin}, ${size}")
	List<Gbook> getList(@Param("begin")int begin, @Param("size")int size);

    @Select("select count(*) from gbook")
	int getTotal();
}