package com.nf.rbac.dao;

import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;

import java.util.List;

/**
 * @author cj
 * @date 2019/12/3
 */
public interface RoleDao {
    boolean addRole(RoleEntity role);

    RoleEntity findRole(String id);

    List<RoleEntity> getAll();

    List<MenuEntity> getMenusByRoleId(String roleId);

}
