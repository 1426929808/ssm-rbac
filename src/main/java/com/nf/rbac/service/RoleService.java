package com.nf.rbac.service;


import com.nf.rbac.dao.RoleDao;

import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
	@Autowired
    private RoleDao roleDao ;


    public boolean addRole(RoleEntity role) {

    	return roleDao.addRole(role);
    }

    public RoleEntity findRole(String id) {
        return roleDao.findRole(id);
    }


    public List<RoleEntity> getAllRole() {
        return roleDao.getAll();
    }


    public List<MenuEntity> getRolePrivilege(String role_id) {
        return roleDao.getMenusByRoleId(role_id);
	}


  /*  public void updateRolePrivilege(RoleEntity role, List<PrivilegeEntity> privileges) {
        roleDao.updateRolePrivilege(role, privileges);
    }*/
}