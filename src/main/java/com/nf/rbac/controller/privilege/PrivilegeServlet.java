package com.nf.rbac.controller.privilege;




import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.service.RoleService;
import com.nf.rbac.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class PrivilegeServlet  {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

	@RequestMapping("/privileges/query")
    @ResponseBody
	protected List<MenuEntity> service(String id) throws ServletException, IOException {

		RoleEntity roles = userService.getUserRole(id);
		List<MenuEntity> list = roleService.getRolePrivilege(roles.getId());
		
		return list;
	}

	@RequestMapping("/unauthorized")
    public String unAuthorized(){
        return "unauthorized";
    }
}
