package com.restful.api.web.common.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.restful.api.web.service.IMenuService;
import com.restful.api.web.service.IUserService;

public class AdminController {

	@Autowired protected IUserService userService;
	@Autowired protected IMenuService menuService;
	
}
