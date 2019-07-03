/**
 * @filename UserInfoMapper.java
 * @author lg
 * @date 2018年1月11日 下午4:44:39
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.mapper;

import java.util.HashMap;
import java.util.List;

import com.auth.entity.AuthInfo;
import com.auth.entity.UserInfo;

/**
 * 持久化层用户接口
 * @author lg
 * @date  2018-01-11
 */
public interface UserInfoMapper {
	/**
	 * 用户登录接口	
	 * @param user 用户对象
	 * @return 用户对象
	 * @author lg
	 * @date  2018-01-11
	 */
	public UserInfo login(UserInfo user);
	
	/**
	 * 查询用户拥有的权限
	 * @comment 
	 * @param map
	 * @return
	 * @version 1.0
	 */
	public  List<AuthInfo> getUserAuth(HashMap map);
	/**
	 * @comment 用户列表查询
	 * @param map
	 * @return
	 * @version 1.0
	 */
	public  List<UserInfo> findAll(HashMap map);
	/**
	 * @comment  分页查询用户总条数
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public int getUserCount(UserInfo user);
	
}
