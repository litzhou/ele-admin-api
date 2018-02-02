package com.vacomall.controller.sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
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
		for (SysMenu menu : pageData.getRecords()) {
			menu.setMenuName("┠ " + menu.getMenuName());
			for (int i = 1; i < menu.getDeep(); i++) {
				menu.setMenuName("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + menu.getMenuName());
			}
		}
		return Rest.okData(pageData);
	}

	/**
	 * 增加菜单
	 */
	@RequiresPermissions("addMenu")
	@RequestMapping("/add")
	public String add(Model model) {

		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("code", true);
		ew.eq("pid", "0");
		List<SysMenu> list = sysMenuService.selectList(ew);
		model.addAttribute("list", list);
		return "system/menu/add";

	}

	/**
	 * 添加目录
	 */
	@RequiresPermissions("addMenu")
	@Log("创建目录菜单")
	@RequestMapping("/doAddDir")
	@ResponseBody
	public Rest doAddDir(SysMenu sysMenu, Model model) {

		sysMenu.setPid("0");
		sysMenu.setDeep(1);
		sysMenuService.insert(sysMenu);
		return Rest.ok();
	}

	/**
	 * 添加菜单
	 */
	@RequiresPermissions("addMenu")
	@Log("创建菜单")
	@RequestMapping("/doAddMenu")
	@ResponseBody
	public Rest doAddMenu(SysMenu sysMenu, Model model) {
		sysMenu.setDeep(2);
		sysMenuService.insert(sysMenu);
		return Rest.ok();
	}

	/**
	 * 编辑菜单
	 */
	@RequiresPermissions("editMenu")
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		SysMenu sysMenu = sysMenuService.selectById(id);
		model.addAttribute("sysMenu", sysMenu);

		if (sysMenu.getDeep() == 1) {
			return "/system/menu/edit";
		} else if (sysMenu.getDeep() == 2) {
			EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
			ew.orderBy("code", true);
			ew.eq("pid", "0");
			List<SysMenu> list = sysMenuService.selectList(ew);
			model.addAttribute("list", list);
			return "/system/menu/editMenu";
		} else {
			EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
			ew.orderBy("code", true);
			ew.eq("pid", "0");
			List<SysMenu> list = sysMenuService.selectList(ew);
			model.addAttribute("list", list);
			model.addAttribute("pSysMenu", sysMenuService.selectById(sysMenu.getPid()));
			return "/system/menu/editAction";
		}
	}

	/**
	 * 执行编辑菜单
	 */
	@RequiresPermissions("editMenu")
	@Log("编辑菜单")
	@RequestMapping("/doEdit")
	@ResponseBody
	public Rest doEdit(SysMenu sysMenu, Model model) {
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
	 * 根据父节点获取子菜单
	 */
	@RequestMapping("/json")
	@ResponseBody
	public Rest json(String pid) {
		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("sort");
		ew.addFilter("pid = {0} ", pid);
		List<SysMenu> list = sysMenuService.selectList(ew);

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for (SysMenu m : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", m.getId());
			map.put("text", StringUtils.join(m.getCode(), "-", m.getMenuName()));
			listMap.add(map);
		}
		return Rest.okData(listMap);
	}

	/**
	 * 验证菜单资源名称是否存在
	 */
	@RequestMapping("/checkMenuResource")
	@ResponseBody
	public Rest checkMenuResource(String resource) {

		List<SysMenu> list = sysMenuService
				.selectList(new EntityWrapper<SysMenu>().addFilter("resource = {0}", resource));
		if (list.size() > 0) {
			return Rest.failure("资源已存在,请换一个尝试.");
		}
		return Rest.ok();
	}

	@RequiresPermissions("addMenu")
	@Log("新增功能菜单")
	@RequestMapping("/doAddAction")
	public String doAddAction(SysMenu sysMenu, Model model) {
		sysMenu.setDeep(3);
		sysMenuService.insert(sysMenu);
		return redirectTo("/system/menu/list/1.html");
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
