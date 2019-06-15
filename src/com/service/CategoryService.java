package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.entity.Category;

/**
 * 类目服务
 */
@Service 
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	
	/**
	 * 获取
	 * @return
	 */
	public Category get(int id) {
		return categoryDao.selectById(id);
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<Category> getList() {
		return categoryDao.getList();
	}

	/**
	 * 添加
	 * @param category
	 * @return
	 */
	public boolean add(Category category) {
		return categoryDao.insert(category) > 0;
	}

	/**
	 * 更新
	 * @param category
	 * @return
	 */
	public boolean update(Category category) {
		return categoryDao.updateById(category) > 0;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return categoryDao.deleteById(id) > 0;
	}

}
