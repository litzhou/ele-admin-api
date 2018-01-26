package com.restful.api.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Role;
import com.restful.api.web.service.IRoleService;
/**
 * 角色控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AppController<Role,IRoleService>{  
	   
}
