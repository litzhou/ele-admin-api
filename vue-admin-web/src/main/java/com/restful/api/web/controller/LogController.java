package com.restful.api.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Log;
import com.restful.api.web.service.ILogService;
/**
 * 日志控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/log")
public class LogController extends AppController<Log,ILogService>{  
	   
}
