package com.restful.api.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restful.api.core.Rest;
import com.restful.api.core.anno.Log;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.User;
import com.restful.api.web.service.IUserService;

/**
 * 标准的Rest接口,实例控制器 Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/user")
public class UserController extends AppController<User, IUserService> {

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @param roleIds
	 * @return
	 */
	@Log("新增用户")
	@PostMapping("/add")
	public Rest add(@Valid User user, @RequestParam(value = "roleIds[]", required = false) String[] roleIds) {
		user.setCreateTime(new Date());
		super.getS().addUser(user, roleIds);
		return Rest.ok();
	}

	/**
	 * 执行编辑
	 */
	@Log("编辑用户")
	@PutMapping("/edit")
	public Rest update(@Valid User user, @RequestParam(value = "roleIds[]", required = false) String[] roleIds) {
		super.getS().updateUser(user, roleIds);
		return Rest.ok();
	}

}
