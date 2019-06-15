package com.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExampleDao;
import com.entity.Example;

/**
 * 案例服务
 */
@Service//spring管理对象
public class ExampleService {

	@Autowired
	private ExampleDao exampleDao;
	@Autowired
	private CategoryService categoryService;

	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public Example get(int id) {
		return packCategory(exampleDao.selectById(id));
	}
	
	/**
	 * 获取列表
	 * @param begin
	 * @param rows
	 * @return
	 */
	public List<Example> getList(int page, int size) {
		return packCategory(exampleDao.getList(size*(page-1) ,size));
	}
	
	/**
	 * 获取总数
	 * @param type
	 * @return
	 */
	public int getTotal() {
		return exampleDao.getTotal();
	}
	
	/**
	 * 通过类目获取列表
	 * @param begin
	 * @param rows
	 * @return
	 */
	public List<Example> getListByCategory(int category, int page, int size) {
		return exampleDao.getListByCategory(category, size*(page-1) ,size);
	}
	
	/**
	 * 通过类目获取总数
	 * @param type
	 * @return
	 */
	public int getTotalByCategory(int category) {
		return exampleDao.getTotalByCategory(category);
	}
	
	
	/**
	 * 添加案例
	 * @param example
	 * @return
	 */
	public boolean add(Example example) {
		example.setTime(new Date());
		return exampleDao.insert(example) > 0;
	}

	/**
	 * 更新案例
	 * @param example
	 * @return
	 */
	public boolean update(Example example) {
		example.setTime(new Date());
		return exampleDao.updateById(example) > 0;
	}

	/**
	 * 删除案例
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return exampleDao.deleteById(id) > 0;
	}
	
	
	/**
	 * 封装类目信息
	 * @param example
	 * @return
	 */
	private Example packCategory(Example example) {
		if(Objects.nonNull(example)) {
			example.setCategory(categoryService.get(example.getCategoryId()));
		}
		return example;
	}
	
	/**
	 * 封装类目信息
	 * @param example
	 * @return
	 */
	private List<Example> packCategory(List<Example> exampleList) {
		if(Objects.nonNull(exampleList) && !exampleList.isEmpty()) {
			for(Example example : exampleList) {
				example = packCategory(example);
			}
		}
		return exampleList;
	}
}
