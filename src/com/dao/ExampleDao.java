package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Example;

public interface ExampleDao {
    int deleteById(Integer id);

    int insert(Example record);

    int insertSelective(Example record);

    Example selectById(Integer id);

    int updateByIdSelective(Example record);

    int updateById(Example record);
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    @Select("select * from example order by id desc limit #{begin}, ${size}")
	List<Example> getList(@Param("begin")int begin, @Param("size")int size);

    @Select("select count(*) from example")
	int getTotal();
    
    @Select("select * from example where category_id=#{categoryId} order by id desc limit #{begin}, ${size}")
    List<Example> getListByCategory(@Param("categoryId")int categoryId, @Param("begin")int begin, @Param("size")int size);
    
    @Select("select count(*) from example where category_id=#{categoryId}")
    int getTotalByCategory(@Param("categoryId")int categoryId);
    
}