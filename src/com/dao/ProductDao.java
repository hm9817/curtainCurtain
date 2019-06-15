package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Product;

public interface ProductDao {
    int deleteById(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectById(Integer id);

    int updateByIdSelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateById(Product record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    @Select("select * from product order by id desc limit #{begin}, #{size}")
	List<Product> getList(@Param("begin")int begin, @Param("size")int size);
    
    @Select("select * from product where id=#{id}")
    List<Product> getListById(int id);
    
    @Select("select * from product where name like concat('%',#{name},'%')")
    List<Product> getListByName(String name);

    @Select("select count(*) from product")
	int getTotal();
    
    @Select("select * from product where category_id=#{categoryId} order by id desc limit #{begin}, #{size}")
    List<Product> getListByCategory(@Param("categoryId")int categoryId, @Param("begin")int begin, @Param("size")int size);
    
    @Select("select count(*) from product where category_id=#{categoryId}")
    int getTotalByCategory(@Param("categoryId")int categoryId);
    
    
}