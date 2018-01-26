package com.restful.api.web.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *
 * 
 *
 */
@TableName("tb_user")
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId(type = IdType.UUID)
	private String id;

	/** 用户名 */
	//@NotEmpty(message = "用户名不能为空")
	//@Length(min = 5, max = 20, message = "用户名长度为5-20之间")
	//@Pattern(regexp = "[a-zA-Z]{5,20}", message = "用户名不合法")
	private String userName;

	/** 密码 */
	//@NotBlank(message="密码不能为空")
	//@Length(min = 5, max = 20, message = "密码长度为5-20之间")
	private String password;

	/** 创建时间 */
	private Date createTime;

	/** 描述 */
	private String userDesc;

	/**状态:1-启用，0-禁用**/
	private Integer userStatus;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
}
