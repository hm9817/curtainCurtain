package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CompanyDao;
import com.entity.Company;

/**
 * 公司信息
 */
@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	/**
	 * 获取
	 * @return
	 */
	public Company get(){
		return companyDao.selectById(1);
	}
	
	/**
	 * 修改
	 * @param company
	 * @return
	 */
	public boolean update(Company company) {
		return companyDao.updateById(company) > 0;
	}

}
