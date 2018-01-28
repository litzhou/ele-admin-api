package com.restful.api.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.api.core.Rest;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.User;
import com.restful.api.web.service.IUserService;
/**
 * 标准的Rest接口,实例控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/user")
public class UserController extends AppController<User,IUserService>{  
	
	@PostMapping
	public Rest add(@Valid User user,BindingResult result) {
		user.setCreateTime(new Date());
		return super.add(user, result);
	}
	
}
