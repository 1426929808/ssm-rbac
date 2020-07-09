package com.nf.rbac.dao;

import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @date 2019/12/3
 */
public interface UserDao {
    boolean addUser(UserEntity user);

    UserEntity findUser(String id);

    List<UserEntity> getAll();

    RoleEntity getRoles(String userId);

    void updateRole(UserEntity user, String roleId);

    UserEntity findUserByUsernameAndPassword(@Param("username") String userName, @Param("password") String password);

    void deleteRolesByUserId(String userId);

    void insertUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
