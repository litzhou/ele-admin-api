package com.vacomall.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.vacomall.common.bean.Rest;
import com.vacomall.common.controller.SuperController;
import com.vacomall.common.util.IpUtil;
import com.vacomall.entity.SysUser;
import com.vacomall.service.ISysLogService;

/**
 * 登录控制器
 * 
 * @author Gaojun.Zhou
 * @date 2016年12月14日 下午2:54:01
 */
@Controller
@RequestMapping("/login")
public class LoginController extends SuperController {
	/**
	 * 日志服务
	 */
	@Autowired
	private ISysLogService sysLogService;

	/**
	 * 执行登录
	 */
	@PostMapping("/doLogin")
	@ResponseBody
	public Rest doLogin(String username, String password, String captcha) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		if (!currentUser.isAuthenticated()) {
			// token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				return Rest.failure("未知用户");
			} catch (IncorrectCredentialsException ice) {
				return Rest.failure("密码错误");
			} catch (LockedAccountException lae) {
				return Rest.failure("账号被锁定,请联系超级管理员");
			} catch (AuthenticationException ae) {
				// unexpected condition? error?
				return Rest.failure("服务繁忙,请稍后");
			}
		}
		/**
		 * 记录登录日志
		 */
		Subject subject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser) subject.getPrincipal();
		sysLogService.insertLog("用户登录成功", sysUser.getUserName(), request.getRequestURI(), "",request.getMethod(),IpUtil.getIpAddr(request));
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("token", sysUser.getUserName());
		return Rest.okData(map);
	}
	
	/**
	 * 获取用户信息
	 * @param token
	 * @return
	 */
	@GetMapping("/info")
	@ResponseBody
	public Rest info(String token){
		Subject subject = SecurityUtils.getSubject();
		if(subject == null) {
			throw new RuntimeException("登录失效");
		}
		SysUser sysUser = (SysUser) subject.getPrincipal();
		if(!sysUser.getUserName().equals(token)) {
			throw new RuntimeException("登录失效");
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", sysUser.getUserName());
		map.put("avatar", sysUser.getUserImg());
		map.put("role", new String[]{"admin"});
		map.put("roles", new String[]{"admin"});
		return Rest.okData(map);
	}
	
	/**
	 * 验证码
	 */
	@GetMapping("/captcha")
	public void captcha() throws ServletException, IOException {
		KaptchaExtend kaptchaExtend = new KaptchaExtend();
		kaptchaExtend.captcha(request, response);
	}

	/**
	 * 退出系统
	 * 
	 * @return
	 */
	@PostMapping("/logout")
	@ResponseBody
	public Rest logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		return Rest.ok();
	}
}
