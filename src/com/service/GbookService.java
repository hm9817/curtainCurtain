package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GbookDao;
import com.entity.Gbook;

/**
 * 留言服务
 */
@Service
public class GbookService {

	@Autowired
	private GbookDao gbookDao;

	
	/**
	 * 获取列表
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Gbook> getList(int page, int size) {
		return gbookDao.getList(size*(page-1), size);
	}
	
	/**
	 * 获取总数
	 * @return
	 */
	public int getTotal(){
		return gbookDao.getTotal();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return gbookDao.deleteById(id) > 0;
	}

	/**
	 * 添加
	 * @param gbook
	 * @return
	 */
	public boolean add(Gbook gbook) {
		return gbookDao.insert(gbook) > 0;
	}


}
