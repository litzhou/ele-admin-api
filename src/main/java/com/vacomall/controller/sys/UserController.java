package com.vacomall.controller.sys;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vacomall.common.anno.Log;
import com.vacomall.common.bean.Rest;
import com.vacomall.common.controller.SuperController;
import com.vacomall.entity.SysUser;
import com.vacomall.entity.SysUserRole;
import com.vacomall.service.ISysUserRoleService;
import com.vacomall.service.ISysUserService;

/**
 * 用户控制器
 * 
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:22:41
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends SuperController {

	@Autowired private ISysUserService sysUserService;
	@Autowired private ISysUserRoleService sysUserRoleService;

	/**
	 * 分页查询用户
	 */
	@RequiresPermissions("listUser")
	@GetMapping("/list")
	public Rest list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "15") Integer size,
			String field,String search) {
		EntityWrapper<SysUser> ew = new EntityWrapper<>();
		if (StringUtils.isNotBlank(search)) {
			ew.like(field, search);
		}
		Page<SysUser> pageData = sysUserService.selectPage(getPage(page,size), ew);
		return Rest.okData(pageData);
	}

	/**
	 * 执行新增
	 */
	@Log("创建用户")
	@RequiresPermissions("addUser")
	@PostMapping("/add")
	public Rest add(SysUser user, @RequestParam(value = "roleIds[]", required = false) String[] roleIds) {
		sysUserService.insertUser(user, roleIds);
		return Rest.ok();
	}
	/**
	 * 执行编辑
	 */
	@Log("编辑用户")
	@RequiresPermissions("editUser")
	@PutMapping("/edit")
	public Rest edit(SysUser sysUser, @RequestParam(value = "roleIds[]", required = false) String[] roleIds) {
		sysUserService.updateUser(sysUser, roleIds);
		return Rest.ok();
	}
	/**
	 * 删除用户
	 */
	@Log("删除用户")
	@RequiresPermissions("deleteUser")
	@DeleteMapping("/delete")
	public Rest delete(@RequestParam(value="ids",required=false)String[] ids) {
		if(ArrayUtils.isEmpty(ids)){
			throw new RuntimeException("客户端传入参数ids为空");
		}
		boolean bool = sysUserService.deleteBatchIds(Arrays.asList(ids));
		return bool ? Rest.ok() : Rest.failure("删除失败");
	}

	/**
	 * 验证用户名是否已存在
	 */
	@GetMapping("/checkName")
	public Rest checkName(String userName) {
		List<SysUser> list = sysUserService.selectList(new EntityWrapper<SysUser>().eq("userName", userName));
		if (list.size() > 0) {
			return Rest.failure("用户名"+userName+"已存在");
		}
		return Rest.ok();
	}
	
	/**
	 * 获取当前用户的角色ID
	 * @param userId
	 * @return
	 */
	@GetMapping("/getRoleIds")
	public Rest getRoleIds(String userId) {
		List<Object> list = sysUserRoleService.selectObjs(new EntityWrapper<SysUserRole>().setSqlSelect("roleId").eq("userId", userId));
		return Rest.okData(list);
	}
	
	/**
	 * 获取最新的N条用户
	 * @param num
	 * @return
	 */
	@GetMapping("/getNewUserByNum")
	public Rest getNewUserByNum(Integer num) {
		EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
		wrapper.orderBy("createTime",false);
		wrapper.last("limit " + num);
		List<SysUser> list = sysUserService.selectList(wrapper);
		return Rest.okData(list);
	}
}
