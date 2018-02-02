package com.vacomall.service;

import com.baomidou.mybatisplus.service.IService;
import com.vacomall.entity.SysLog;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysLogService extends IService<SysLog> {

	/**
	 * 记录日志
	 * @param title
	 * @param uname
	 * @param url
	 * @param parms
	 * @param ip 
	 * @param method 
	 */
	void insertLog(String title,String uname,String url,String parms, String method, String ip);


}