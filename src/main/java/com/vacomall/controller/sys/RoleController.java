package com.vacomall.controller.sys;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.vacomall.common.anno.Log;
import com.vacomall.common.bean.Rest;
import com.vacomall.common.controller.SuperController;
import com.vacomall.entity.SysRole;
import com.vacomall.entity.SysRoleMenu;
import com.vacomall.entity.vo.TreeMenuAllowAccess;
import com.vacomall.service.ISysMenuService;
import com.vacomall.service.ISysRoleMenuService;
import com.vacomall.service.ISysRoleService;
/**
 * 角色控制器
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:23:41
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends SuperController{  

	/**
	 * 角色服务
	 */
	@Autowired private ISysRoleService sysRoleService;
	/**
	 * 菜单服务
	 */
	@Autowired private ISysMenuService sysMenuService;
	/**
	 * 角色权限服务
	 */
	@Autowired private ISysRoleMenuService sysRoleMenuService;
	
	/**
	 * 分页查询角色
	 */
	@RequiresPermissions("listRole")
    @GetMapping("/list")  
    public  Rest list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "15") Integer size,
			String field,String search){
		EntityWrapper<SysRole> ew = new EntityWrapper<SysRole>();
		ew.orderBy("createTime");
		if(StringUtils.isNotBlank(search)){
			ew.like(field,search);
		}
		Page<SysRole> pageData = sysRoleService.selectPage(getPage(page,size), ew);
		return Rest.okData(pageData);
    } 
    
    /**
     * 执行新增角色
     */
	@RequiresPermissions("addRole")
    @Log("创建角色")
    @PostMapping("/add")  
    public  Rest add(SysRole role){
    	role.setCreateTime(new Date());
    	sysRoleService.insert(role);
		return Rest.ok();
    }  
    
    /**
     * 批量删除角色
     */
	@RequiresPermissions("deleteRole")
    @Log("删除角色")
    @DeleteMapping("/delete")  
	public Rest delete(@RequestParam(value="ids",required=false)String[] ids) {
		if(ArrayUtils.isEmpty(ids)){
			throw new RuntimeException("客户端传入参数ids为空");
		}
		boolean bool = sysRoleService.deleteBatchIds(Arrays.asList(ids));
		return bool ? Rest.ok() : Rest.failure("删除失败");
	}
    
    /**
     * 执行编辑角色
     */
	@RequiresPermissions("editRole")
    @Log("编辑角色")
    @PutMapping("/edit")  
    public  Rest edit(SysRole sysRole){
    	sysRoleService.updateById(sysRole);
    	return Rest.ok();
    } 
    
    /**
     * 权限
     */
	@RequiresPermissions("authRole")
    @RequestMapping("/auth/{id}")  
    public  String auth(@PathVariable String id,Model model){
    	
    	SysRole sysRole = sysRoleService.selectById(id);
    	if(sysRole == null){
    		throw new RuntimeException("该角色不存在");
    	}
    	
    	List<SysRoleMenu> sysRoleMenus = sysRoleMenuService.selectList(new EntityWrapper<SysRoleMenu>().eq("roleId", id));
    	List<String> menuIds = Lists.transform(sysRoleMenus,input -> input.getMenuId());
    	
    	List<TreeMenuAllowAccess> treeMenuAllowAccesses = sysMenuService.selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds, "0");

    	model.addAttribute("sysRole", sysRole);
    	model.addAttribute("treeMenuAllowAccesses", treeMenuAllowAccesses);
    	
    	return "system/role/auth";
    } 
    
    /**
     * 权限
     */
	@RequiresPermissions("authRole")
    @Log("角色分配权限")
    @RequestMapping("/doAuth")  
    public  Rest doAuth(String roleId,@RequestParam(value="menuIds[]",required=false) String[] menuIds){
    	sysRoleMenuService.addAuth(roleId,menuIds);
    	return Rest.ok("OK,授权成功,1分钟后生效  ~");
    } 
	
	/**
	 * 获取所有角色
	 * @return
	 */
	@GetMapping("/getRoleAll")
	public Rest getRoleAll() {
		return Rest.okData(sysRoleService.selectList(null));
	}
	
	/**
	 * 根据获取角色
	 * @return
	 */
	@GetMapping("/getById")
	public Rest getById(String roleId) {
		return Rest.okData(sysRoleService.selectById(roleId));
	}
	
	/**
	 * 获取角色ID获取拥有的权限ID(菜单ID)集合
	 * @param roleId
	 * @return
	 */
	@GetMapping("/getMenuIdsByRoleId")
	public Rest getMenuIdsByRoleId(String roleId){
		EntityWrapper<SysRoleMenu> ew = new EntityWrapper<SysRoleMenu>();
		ew.setSqlSelect("menuId").eq("roleId", roleId);
		return Rest.okData(sysRoleMenuService.selectObjs(ew));
	}
}
