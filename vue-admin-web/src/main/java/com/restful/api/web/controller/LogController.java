package com.restful.api.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.restful.api.core.Rest;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Log;
import com.restful.api.web.service.ILogService;

/**
 * 日志控制器
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/log")
public class LogController extends AppController<Log, ILogService> {

	@Override
	@GetMapping("/page")
	public Rest page(@RequestParam(required = true, defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, String field, String search) {

		EntityWrapper<Log> ew = new EntityWrapper<Log>();
		ew.orderBy("logTime",false);
		if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(search)) {
			ew.like(field, search);
		}
		Page<Log> pageData = getS().selectPage(new Page<Log>(page, size), ew);
		return Rest.okData(pageData);
	}

}
