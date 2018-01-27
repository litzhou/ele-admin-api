package com.restful.api.web.service.impl;

import com.restful.api.web.entity.Role;
import com.restful.api.web.mapper.RoleMapper;
import com.restful.api.web.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
	
}
