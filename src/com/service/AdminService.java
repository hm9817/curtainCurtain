package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.entity.Admin;
import com.util.SafeUtil;

@Service	// 注解为service层spring管理bean
public class AdminService {

	@Autowired		//spring注入类对象
	private AdminDao adminDao;
	
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public Admin get(int id) {
		return adminDao.selectById(id);
	}	
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<Admin> getList() {
		return adminDao.getList();
	}

	/**
	 * 添加
	 * @param category
	 * @return
	 */
	public boolean add(Admin admin) {
		admin.setPassword(SafeUtil.encode(admin.getPassword()));
		return adminDao.insert(admin) > 0;
	}
	
	/**
	 * 验证用户密码
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username, String password){
		Admin user = adminDao.selectByUsername(username);
		return user!=null && user.getPassword().equals(SafeUtil.encode(password));
	}

	/**
	 * 通过username获取
	 * @param username
	 * @return
	 */
	public Admin getByUsername(String username){
		return adminDao.selectByUsername(username);
	}
	
	/**
	 * 更新
	 * @param admin
	 */
	public boolean update(Admin admin) {
		return adminDao.updateByIdSelective(admin) > 0;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return adminDao.deleteById(id) > 0;
	}
	
}
