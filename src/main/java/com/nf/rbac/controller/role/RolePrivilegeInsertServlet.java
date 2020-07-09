package com.nf.rbac.controller.role;



import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.service.MenuService;
import com.nf.rbac.service.PrivilegeService;
import com.nf.rbac.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RolePrivilegeInsertServlet  {

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

	@RequestMapping("/admin/role-privilege/inser")
    @ResponseBody
	protected Object service(String[] privilege_id,String role_id) {

		RoleEntity role = roleService.findRole(role_id);

		List<MenuEntity> list = new ArrayList<MenuEntity>();
		for(String pid:privilege_id) {
			MenuEntity privilege = menuService.findMenuById(pid);
			list.add(privilege);
		}

        privilegeService.updateRolePrivilege(role,list);
		return true;
		
	}
}
