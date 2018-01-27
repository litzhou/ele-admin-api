package com.restful.api.core.controller;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.restful.api.core.Rest;

/**
 * Rest 风格之外的公共扩展接口
 * Created by Gaojun.Zhou 2017年6月8日
 */
public abstract class AppController<T extends Serializable,S extends IService<T>> extends CrudController<T,S>{

	/**
	 * 分页查询对象
	 * @param page
	 * @param size
	 * @return
	 */
    @GetMapping("/page")  
    public  Rest page(
    	@RequestParam (required = true,defaultValue="1") Integer page,
    	@RequestParam (defaultValue="10")Integer size,
    	String field,String search){
    	
    	EntityWrapper<T> ew = new EntityWrapper<T>();
    	if(StringUtils.isNotBlank(field) && StringUtils.isNotBlank(search)) {
    		ew.like(field, search);
    	}
		Page<T> pageData = getS().selectPage(new Page<T>(page, size),ew);
		return Rest.okData(pageData);
    }
	
}
