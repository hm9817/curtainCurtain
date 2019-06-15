package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NewsDao;
import com.entity.News;

/**
 * 新闻服务
 */
@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;


	/**
	 * 获取
	 * @param id
	 * @return
	 */
	public News get(int id) {
		return newsDao.selectById(id);
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<News> getList(int page, int size) {
		return newsDao.getList(size*(page-1), size);
	}
	
	/**
	 * 获取总数
	 * @return
	 */
	public int getTotal(){
		return newsDao.getTotal();
	}
	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<News> getListByType(int type, int page, int size) {
		return newsDao.getListByType(type, size*(page-1), size);
	}
	
	/**
	 * 获取总数
	 * @return
	 */
	public int getTotalByType(int type){
		return newsDao.getTotalByType(type);
	}
	
	/**
	 * 添加
	 * @param news
	 * @return
	 */
	public boolean add(News news) {
		news.setTime(new Date());
		return newsDao.insert(news) > 0;
	}
	
	/**
	 * 修改
	 * @param news
	 * @return
	 */
	public boolean update(News news) {
		news.setTime(new Date());
		return newsDao.updateByIdSelective(news) > 0;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return newsDao.deleteById(id) > 0;
	}	

}
