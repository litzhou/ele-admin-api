package com.vacomall.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacomall.common.bean.Rest;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequiresRoles("b1f9ce5543a049be9f169a3f5e6b72a8")
	//@RequiresPermissions("testAdd")
	@GetMapping("/test1")
	public Rest test(){
		return Rest.ok();
	}
}
