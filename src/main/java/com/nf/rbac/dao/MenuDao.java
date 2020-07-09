package com.nf.rbac.dao;

import com.nf.rbac.entity.MenuEntity;

import java.util.List;

/**
 * @author cj
 * @date 2019/12/4
 */
public interface MenuDao {

    MenuEntity findMenuById(String id);

    List<MenuEntity> getAllMenus();
}
