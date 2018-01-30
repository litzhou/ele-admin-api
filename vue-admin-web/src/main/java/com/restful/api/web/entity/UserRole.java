package com.restful.api.web.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author GaoJun.Zhou
 * @since 2018-01-29
 */
@TableName("tb_user_role")
public class UserRole extends Model<UserRole> {

	@TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type = IdType.UUID)
	private String Id;
    /**
     * 用户主键
     */
	private String userId;
    /**
     * 角色主键
     */
	private String roleId;


	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
