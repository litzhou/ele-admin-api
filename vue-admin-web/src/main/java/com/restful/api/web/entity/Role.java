package com.restful.api.web.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2018-01-26
 */
@TableName("tb_role")
public class Role extends Model<Role> {

	@TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type = IdType.UUID)
	private String id;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 角色描述
     */
	private String roleDesc;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
