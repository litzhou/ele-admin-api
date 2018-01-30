package com.restful.api.web.service.impl;

import java.util.Date;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.restful.api.core.util.MD5Tools;
import com.restful.api.web.entity.User;
import com.restful.api.web.entity.UserRole;
import com.restful.api.web.mapper.UserMapper;
import com.restful.api.web.mapper.UserRoleMapper;
import com.restful.api.web.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2017-06-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired private UserRoleMapper userRoleMapper;
	
	@Override
	public void addUser(User user, String[] roleIds) {
		// TODO Auto-generated method stub
		user.setCreateTime(new Date());
    	user.setPassword(MD5Tools.MD5(user.getPassword()));
		//保存用户
    	super.insert(user);
		//绑定角色
		if(!ArrayUtils.isEmpty(roleIds)){
			for(String rid : roleIds){
				UserRole sysUserRole = new UserRole();
				sysUserRole.setUserId(user.getId());
				sysUserRole.setRoleId(rid);
				userRoleMapper.insert(sysUserRole);
			}
		}
	}
	
	@Override
	public void updateUser(User user, String[] roleIds) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(user.getPassword())){
			user.setPassword(MD5Tools.MD5(user.getPassword()));
		}else{
			user.setPassword(null);
		}
		//更新用户
		super.updateById(user);
		//删除已有权限
		userRoleMapper.delete(new EntityWrapper<UserRole>().eq("userId",user.getId()));
		//重新绑定角色
		if(!ArrayUtils.isEmpty(roleIds)){
			for(String rid : roleIds){
				UserRole sysUserRole = new UserRole();
				sysUserRole.setUserId(user.getId());
				sysUserRole.setRoleId(rid);
				userRoleMapper.insert(sysUserRole);
			}
		}
	}
	
}
