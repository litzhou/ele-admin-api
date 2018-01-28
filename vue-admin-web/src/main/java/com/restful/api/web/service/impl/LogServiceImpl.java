package com.restful.api.web.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.restful.api.core.log.LogApi;
import com.restful.api.core.log.LogBean;
import com.restful.api.web.entity.Log;
import com.restful.api.web.mapper.LogMapper;
import com.restful.api.web.service.ILogService;

/**
 * 记录日志业务,开发这个实现LogApi接口的log方法可灵活处理日志，如记录在数据库
 * Created by Gaojun.Zhou 2017年6月20日
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService, LogApi {

	public static final Logger logger = Logger.getLogger(LogServiceImpl.class);

	@Transactional
	@Override
	public void log(LogBean logBean) {
		// TODO Auto-generated method stub
		Log log = new Log();
		log.setClientIp(logBean.getClientIp());
		log.setLogContent(logBean.getLogContent());
		log.setLogTime(logBean.getLogTime());
		log.setLogTitle(logBean.getLogTitle());
		log.setOther(logBean.getOther());
		log.setRequestMethod(logBean.getRequestMethod());
		log.setRequestParams(logBean.getRequestParams());
		log.setLogUrl(logBean.getLogUrl());
		super.insert(log);
	}
	
}