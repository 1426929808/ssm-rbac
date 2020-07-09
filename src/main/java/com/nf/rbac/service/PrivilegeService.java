package com.nf.rbac.service;


import com.nf.rbac.dao.MenuDao;
import com.nf.rbac.dao.PrivilegeDao;

import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrivilegeService {
    @Autowired
    private PrivilegeDao privilegeDao;


    @Transactional
    public void updateRolePrivilege(RoleEntity role, List<MenuEntity> privileges) {
        privilegeDao.deleteRolePrivilege(role.getId());
        privilegeDao.insertRolePrivilege(role.getId(), privileges);
    }

}
