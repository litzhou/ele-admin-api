package com.restful.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.restful.api.core.Rest;
import com.restful.api.core.anno.Log;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Role;
import com.restful.api.web.entity.RoleMenu;
import com.restful.api.web.entity.UserRole;
import com.restful.api.web.service.IRoleMenuService;
import com.restful.api.web.service.IRoleService;
import com.restful.api.web.service.IUserRoleService;
/**
 * 角色控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AppController<Role,IRoleService>{  
	
	@Autowired private IRoleMenuService roleMenuService;
	@Autowired private IUserRoleService userRoleService;
	
	/**
	 * 获取权限ID
	 * @param roleId
	 * @return
	 */
	@GetMapping("/auth")
	public Rest getRoleMenuIds(String roleId){
		EntityWrapper<RoleMenu> ew = new EntityWrapper<RoleMenu>();
		ew.setSqlSelect("menuId").eq("roleId", roleId);
		return Rest.okData(roleMenuService.selectObjs(ew));
	}
	
	/**
	 * 执行权限分配
	 * @param roleId
	 * @return
	 */
	@Log("分配权限")
	@PostMapping("/doAuth")
	public Rest doAuth(String roleId, @RequestParam(value="menuIds[]",required=false) String[] menuIds){
		super.getS().updateAuth(roleId,menuIds);
		return Rest.ok();
	}
	
	@GetMapping("/uid")
	public Rest getRoleIdByUid(String userId){
		EntityWrapper<UserRole> ew = new EntityWrapper<UserRole>();
		ew.setSqlSelect("roleId").eq("userId", userId);
		return Rest.okData(userRoleService.selectObjs(ew));
	}
}
