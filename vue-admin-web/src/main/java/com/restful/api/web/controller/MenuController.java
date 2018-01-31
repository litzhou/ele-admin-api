package com.restful.api.web.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.restful.api.core.Rest;
import com.restful.api.core.anno.Log;
import com.restful.api.web.common.controller.AdminController;
import com.restful.api.web.entity.Menu;
/**
 * 角色控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends AdminController{  
	
	/**
	 * 分页查询
	 * @param page
	 * @param size
	 * @param field
	 * @param search
	 * @return
	 */
	@GetMapping("/page")  
    public  Rest page(
    	@RequestParam (required = true,defaultValue="1") Integer page,
    	@RequestParam (defaultValue="10")Integer size,
    	String field,String search){
    	
    	EntityWrapper<Menu> ew = new EntityWrapper<Menu>();
    	ew.orderBy("code");
    	if(StringUtils.isNotBlank(field) && StringUtils.isNotBlank(search)) {
    		ew.like(field, search);
    	}
		Page<Menu> pageData = super.menuService.selectPage(new Page<Menu>(page, size),ew);
		for(Menu menu : pageData.getRecords()){
			menu.setMenuName("┠ "+menu.getMenuName());
			for(int i=1;i<menu.getDeep();i++){
				menu.setMenuName("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+menu.getMenuName());
			}
		}
		return Rest.okData(pageData);
    }
	
	/**
	 * 根据上级ID查询所有下级接单
	 * @param pid
	 * @return
	 */
	@GetMapping("/getByPid")
	public Rest getMenusByPid(String pid){
		if(StringUtils.isBlank(pid)){
			pid = "0";
		}
		EntityWrapper<Menu> ew = new EntityWrapper<Menu>();
		ew.eq("pid", pid);
		ew.orderBy("sort",true);
		List<Menu> list = super.menuService.selectList(ew);
		return Rest.okData(list);
	}
	
	/**
	 * 删除和批量删除
	 * @param ids
	 * @return
	 */
	@Log("删除菜单")
	@DeleteMapping("/delete")
	public Rest delete(@RequestParam(value="ids",required=false) String[] ids){
		if(ArrayUtils.isEmpty(ids)){
			throw new RuntimeException("客户端传入参数ids为空");
		}
		boolean bool = super.menuService.deleteBatchIds(Arrays.asList(ids));
		return bool ? Rest.ok() : Rest.failure("删除失败");
	}

}
