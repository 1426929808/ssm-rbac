package com.nf.rbac.dao;

import com.nf.rbac.entity.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @date 2019/12/3
 */
public interface PrivilegeDao {

    void deleteRolePrivilege(String roleId);

    void insertRolePrivilege(@Param("roleId") String roleId, @Param("privileges") List<MenuEntity> privileges);
}
