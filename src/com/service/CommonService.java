package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommonDao;
import com.entity.Common;

/**
 * 基础信息
 */
@Service
public class CommonService {

	@Autowired
	private CommonDao commonDao;
	
	
	/**
	 * 获取轮播图列表
	 * @return
	 */
	public List<String> getBannerList(){
		return commonDao.getList(Common.TYPE_BANNER);
	}
	
	/**
	 * 获取二维码
	 * @return
	 */
	public String getQrcode(){
		return commonDao.get(Common.TYPE_QRCODE);
	}
	
	
	/**
	 * 获取横幅文字
	 * @return
	 */
	public List<String> getTextList(){
		return commonDao.getList(Common.TYPE_TEXT);
	}
	
	
	/**
	 * 修改轮播图列表
	 * @return
	 */
	public void updateBannerList(List<String> list){
		commonDao.delete(Common.TYPE_BANNER);
		for(String str : list) {
			Common common = new Common();
			common.setType(Common.TYPE_BANNER);
			common.setValue(str);
			commonDao.insert(common);
		}
	}
	
	/**
	 * 修改二维码
	 * @return
	 */
	public void updateQrcode(String str){
		commonDao.delete(Common.TYPE_QRCODE);
		Common common = new Common();
		common.setType(Common.TYPE_QRCODE);
		common.setValue(str);
		commonDao.insert(common);
	}
	
	
	/**
	 * 修改横幅文字
	 * @return
	 */
	public void updateTextList(List<String> list){
		commonDao.delete(Common.TYPE_TEXT);
		for(String str : list) {
			Common common = new Common();
			common.setType(Common.TYPE_TEXT);
			common.setValue(str);
			commonDao.insert(common);
		}
	}

}
