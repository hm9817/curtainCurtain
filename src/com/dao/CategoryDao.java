package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.entity.Category;

public interface CategoryDao {
    int deleteById(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectById(Integer id);

    int updateByIdSelective(Category record);

    int updateById(Category record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    

    @Select("select * from category order by number")
	List<Category> getList();
    
    @Select("select count(*) from category")
    int getTotal();
}