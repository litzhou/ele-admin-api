package com.vacomall.controller.sys;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

import com.baomidou.mybatisplus.entity.Column;
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
		for (SysMenu menu : pageData.getRecords()) {
			menu.setMenuName("┠ " + menu.getMenuName());
			for (int i = 1; i < menu.getDeep(); i++) {
				menu.setMenuName("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + menu.getMenuName());
			}
		}
		return Rest.okData(pageData);
	}

	/**
	 * 添加目录
	 */
	@RequiresPermissions("addMenu")
	@Log("创建目录菜单")
	@PostMapping("/add")
	public Rest add(SysMenu sysMenu, @RequestParam(value = "pids[]", required = false) String[] pids) {
		if (ArrayUtils.isEmpty(pids)) {
			sysMenu.setPid("0");
			sysMenu.setDeep(1);
		} else {
			String pid = pids[pids.length - 1];
			sysMenu.setPid(pid);
			SysMenu sMenu = sysMenuService.selectById(pid);
			sysMenu.setDeep(sMenu != null ? sMenu.getDeep()+1 : 0);
		}
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
	public Rest doEdit(SysMenu sysMenu, @RequestParam(value = "pids[]", required = false) String[] pids) {
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
	 * 获取所有的一级菜单和二级菜单,vue
	 * 
	 * @param pid
	 * @return
	 */
	@GetMapping("/tree")
	public Rest tree() {
		EntityWrapper<SysMenu> ew = new EntityWrapper<SysMenu>();
		ew.orderBy("sort");
		ew.eq("pid", "0");
		ew.setSqlSelect(Column.create().column("id"), Column.create().column("menuName"));
		List<Map<String, Object>> listMap = sysMenuService.selectMaps(ew);
		for (Map<String, Object> map : listMap) {
			EntityWrapper<SysMenu> wrapper = new EntityWrapper<SysMenu>();
			wrapper.orderBy("sort");
			wrapper.eq("pid", map.get("id"));
			wrapper.setSqlSelect(Column.create().column("id"), Column.create().column("menuName"));
			List<Map<String, Object>> listMapeExt = sysMenuService.selectMaps(wrapper);
			if (listMapeExt.size() > 0) {
				map.put("children", listMapeExt);
			}
		}
		return Rest.okData(listMap);
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
