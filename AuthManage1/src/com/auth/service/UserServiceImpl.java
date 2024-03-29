package com.auth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.entity.Navigation;
import com.auth.entity.Role;
import com.auth.entity.User;
import com.auth.entity.UserRole;
import com.auth.mapper.PermissionMapper;
import com.auth.mapper.RoleMapper;
import com.auth.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;


	@Override
	public void addUser(User user, Long... roleIds) {
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				userMapper.addUserRole(new UserRole(user.getUserId(),roleId));
			}
		}
	}

	@Override
	public void deleteUser(Long userId) {
		userMapper.deleteUserRole(userId);
		userMapper.deleteUser(userId);
	}

	@Override
	public void deleteMoreUsers(Long... userIds) {
		if(userIds!=null&&userIds.length>0){
			for(Long userId:userIds){
				deleteUser(userId);
			}
		}
	}

	@Override
	public User getUserByUserName(String userName) {
		return userMapper.findUserByUserName(userName);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public void updateUserRoles(Long userId, Long... roleIds) {
		userMapper.deleteUserRole(userId);
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				userMapper.addUserRole(new UserRole(userId,roleId));
			}
		}
	}

	@Override
	public Set<String> findRolesByUserName(String userName) {
		return new HashSet<String>(userMapper.findRolesByUserName(userName));
	}

	@Override
	public Set<String> findPermissionsByUserName(String userName) {
		return new HashSet<String>(userMapper.findPermissionsByUserName(userName));
	}

	@Override
	public List<Navigation> getNavigationBar(String userName) {
		List<Navigation> navigationBar=new ArrayList<Navigation>();
		Navigation navigation;
		List<Role> roles=roleMapper.findRolesByUserName(userName);
		for(Role role:roles){
			navigation=new Navigation();
			navigation.setNavigationName(role.getRoleDesc());
			navigation.setChildNavigations(
					permissionMapper.findNavisByRoleId(role.getRoleId()));
			navigationBar.add(navigation);
		}
		return navigationBar;
	}

	@Override
	public User getUserInfo(User user) {

		return null;
	}

}
