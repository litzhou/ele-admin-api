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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vacomall.common.anno.Log;
import com.vacomall.common.bean.Rest;
import com.vacomall.common.controller.SuperController;
import com.vacomall.entity.SysMenu;
import com.vacomall.service.ISysMenuService;

/**
 * 角色控制器
 * 
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:23:41
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController extends SuperController {

	/**
	 * 菜单服务
	 */
	@Autowired
	private ISysMenuService sysMenuService;

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param size
	 * @param field
	 * @param search
	 * @return
	 */
	@RequiresPermissions("listMenu")
	@GetMapping("/list")
	public Rest list(@RequestParam(required = true, defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size, String field, String search) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("code");
		if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(search)) {
			ew.like(field, search);
		}
		Page<SysMenu> pageData = sysMenuService.selectPage(new Page<SysMenu>(page, size), ew);
		return Rest.okData(pageData);
	}

	/**
	 * 添加目录
	 */
	@RequiresPermissions("addMenu")
	@Log("创建菜单")
	@PostMapping("/add")
	public Rest add(SysMenu sysMenu) {
		sysMenuService.insert(sysMenu);
		return Rest.ok();
	}
	/**
	 * 执行编辑菜单
	 */
	@RequiresPermissions("editMenu")
	@Log("编辑菜单")
	@PutMapping("/edit")
	@ResponseBody
	public Rest edit(SysMenu sysMenu, @RequestParam(value = "pids[]", required = false) String[] pids) {
		sysMenuService.updateById(sysMenu);
		return Rest.ok();
	}

	/**
	 * 执行编辑菜单
	 */
	@RequiresPermissions("deleteMenu")
	@Log("删除菜单")
	@DeleteMapping("/delete")
	public Rest delete(@RequestParam(value = "ids", required = false) String[] ids) {
		if (ArrayUtils.isEmpty(ids)) {
			throw new RuntimeException("客户端传入参数ids为空");
		}
		boolean bool = sysMenuService.deleteBatchIds(Arrays.asList(ids));
		return bool ? Rest.ok() : Rest.failure("删除失败");
	}

	/**
	 * 根据上级ID查询所有下级接单
	 * 
	 * @param pid
	 * @return
	 */
	@GetMapping("/getMenusByPid")
	public Rest getMenusByPid(String pid) {
		if (StringUtils.isBlank(pid)) {
			pid = "0";
		}
		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.eq("pid", pid);
		ew.orderBy("sort", true);
		List<SysMenu> list = sysMenuService.selectList(ew);
		return Rest.okData(list);
	}
}
