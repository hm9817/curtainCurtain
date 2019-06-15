package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.News;

public interface NewsDao {
    int deleteById(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectById(Integer id);

    int updateByIdSelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateById(News record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现

    
    @Select("select * from news order by id desc limit #{begin}, ${size}")
	List<News> getList(@Param("begin")int begin, @Param("size")int size);

    @Select("select count(*) from news")
	int getTotal();
    
    @Select("select * from news where type=#{type} order by id desc limit #{begin}, ${size}")
    List<News> getListByType(@Param("type")int type, @Param("begin")int begin, @Param("size")int size);
    
    @Select("select count(*) from news where type=#{type}")
    int getTotalByType(@Param("type")int type);
    
}