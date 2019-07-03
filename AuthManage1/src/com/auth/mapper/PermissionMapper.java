package com.auth.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.auth.entity.Permission;
public interface PermissionMapper {
	void addPermission(Permission permission);
	void deletePermission(Long permissionId);
	Permission findById(Long permId);
	List<Permission> findNavisByRoleId(Long roleId);
	List<Permission> findPermissionsByRoleId(Long roleId);
	List<Permission> findAllPermissions();
	void updatePermission(Permission permission);
	
	void deleteRolePermission(Long permissionId);
}
