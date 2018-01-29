package com.restful.api.web.service.impl;

import com.restful.api.web.entity.Menu;
import com.restful.api.web.mapper.MenuMapper;
import com.restful.api.web.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2018-01-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	
}
