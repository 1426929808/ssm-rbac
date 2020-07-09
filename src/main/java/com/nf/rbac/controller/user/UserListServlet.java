package com.nf.rbac.controller.user;

import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.entity.UserEntity;
import com.nf.rbac.service.RoleService;
import com.nf.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserListServlet  {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

	@RequestMapping("/admin/user/list")
	protected String service(Model model){

		List<UserEntity> allUser = userService.getAllUser();
		List<RoleEntity> roles = roleService.getAllRole();

        model.addAttribute("roles", roles);
        model.addAttribute("allUser", allUser);
		return "be/userList";
	}
}
