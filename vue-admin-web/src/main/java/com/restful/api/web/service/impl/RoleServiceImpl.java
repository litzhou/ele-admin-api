package com.restful.api.web.service.impl;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.restful.api.web.entity.Role;
import com.restful.api.web.entity.RoleMenu;
import com.restful.api.web.mapper.RoleMapper;
import com.restful.api.web.mapper.RoleMenuMapper;
import com.restful.api.web.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2018-01-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired private RoleMenuMapper roleMenuMapper;
	
	@Override
	public void updateAuth(String roleId, String[] menuIds) {
		// TODO Auto-generated method stub
		
		List<RoleMenu> list = roleMenuMapper.selectList(new EntityWrapper<RoleMenu>().eq("roleId", roleId));
		if(list!=null && list.size()>0){
			for(RoleMenu rm : list){
				roleMenuMapper.deleteById(rm.getId());
			}
		}
		if(!ArrayUtils.isEmpty(menuIds)){
			for(String menuId : menuIds){
				RoleMenu rm = new RoleMenu();
				rm.setMenuId(menuId);
				rm.setRoleId(roleId);
				roleMenuMapper.insert(rm);
			}
		}
		
	}
	
}
