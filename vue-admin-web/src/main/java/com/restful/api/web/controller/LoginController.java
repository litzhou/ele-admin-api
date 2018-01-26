package com.restful.api.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 标准的Rest接口,实例控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */

import com.restful.api.core.Rest;
@RestController
@RequestMapping("/login")
public class LoginController{  
	
	/**
	 * 执行登录
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/doLogin")
	public Rest doLogin(String username,String password){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("token", "admin");
		return Rest.okData(map);
	}
	
	/**
	 * 获取用户信息
	 * @param token
	 * @return
	 */
	@GetMapping("/info")
	public Rest info(String token){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "admin");
		map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		map.put("role", new String[]{"admin"});
		map.put("roles", new String[]{"admin"});
		
		return Rest.okData(map);
	}
	
	/**
	 * 退出
	 * @return
	 */
	@PostMapping("/logout")
	public Rest logout(){
		return Rest.ok();
	}
	
}
