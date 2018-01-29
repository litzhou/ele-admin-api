package com.restful.api.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.restful.api.core.Rest;
import com.restful.api.core.controller.AppController;
import com.restful.api.web.entity.Menu;
import com.restful.api.web.service.IMenuService;
/**
 * 角色控制器
 * Created by Gaojun.Zhou 2017年6月8日
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends AppController<Menu,IMenuService>{  
	
	@GetMapping("/getByPid")
	public Rest getMenusByPid(String pid){
		if(StringUtils.isBlank(pid)){
			pid = "0";
		}
		EntityWrapper<Menu> ew = new EntityWrapper<Menu>();
		ew.eq("pid", pid);
		ew.orderBy("sort",true);
		List<Menu> list = super.getS().selectList(ew);
		return Rest.okData(list);
	}

}
