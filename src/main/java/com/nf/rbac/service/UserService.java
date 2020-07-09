package com.nf.rbac.service;


import com.nf.rbac.dao.UserDao;

import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public boolean addUser(UserEntity user) {

        return userDao.addUser(user);
    }


    public UserEntity findUser(String id) {
        return userDao.findUser(id);
    }


    public List<UserEntity> getAllUser() {
        return userDao.getAll();
    }


    public RoleEntity getUserRole(String user_id) {
        return userDao.getRoles(user_id);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    public void updateUserRole(UserEntity user, String roleId) {

        userDao.deleteRolesByUserId(user.getId());
        userDao.insertUserRole(user.getId(), roleId);
    }

    public UserEntity findUser(String userName, String password) {
        return userDao.findUserByUsernameAndPassword(userName, password);
    }
}
