package com.restful.api.web.service.impl;

import com.restful.api.web.entity.UserRole;
import com.restful.api.web.mapper.UserRoleMapper;
import com.restful.api.web.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2018-01-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
}
