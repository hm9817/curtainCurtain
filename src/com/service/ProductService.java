package com.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.entity.Product;

/**
 * 产品服务
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryService categoryService;


	/**
	 * 获取
	 * @param id
	 * @return
	 */
	public Product get(int id) {
		return packCategory(productDao.selectById(id));
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Product> getList(int page, int size) {
		return packCategory(productDao.getList(size*(page-1), size));
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Product> getListById(int id) {
		return packCategory(productDao.getListById(id));
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Product> getListByName(String name) {
		return packCategory(productDao.getListByName(name));
	}
	
	/**
	 * 通过类目获取总数
	 * @return
	 */
	public int getTotal(){
		return productDao.getTotal();
	}
	
	/**
	 * 通过类目获取列表
	 * @param begin
	 * @param rows
	 * @return
	 */
	public List<Product> getListByCategory(int categoryId, int page, int size) {
		return productDao.getListByCategory(categoryId, size*(page-1) ,size);
	}
	
	/**
	 * 获取总数
	 * @param type
	 * @return
	 */
	public int getTotalByCategory(int categoryId) {
		return productDao.getTotalByCategory(categoryId);
	}
	
	/**
	 * 添加
	 * @param product
	 * @return
	 */
	public boolean add(Product product) {
		product.setTime(new Date());
		return productDao.insert(product) > 0;
	}
	
	/**
	 * 修改
	 * @param product
	 * @return
	 */
	public boolean update(Product product) {
		product.setTime(new Date());
		return productDao.updateById(product) > 0;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return productDao.deleteById(id) > 0;
	}	
	
	
	/**
	 * 封装类目信息
	 * @param product
	 * @return
	 */
	private Product packCategory(Product product) {
		if(Objects.nonNull(product)) {
			product.setCategory(categoryService.get(product.getCategoryId()));
		}
		return product;
	}
	
	/**
	 * 封装类目信息
	 * @param product
	 * @return
	 */
	private List<Product> packCategory(List<Product> productList) {
		if(Objects.nonNull(productList) && !productList.isEmpty()) {
			for(Product product : productList) {
				product = packCategory(product);
			}
		}
		return productList;
	}

}
