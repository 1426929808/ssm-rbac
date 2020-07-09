package com.nf.rbac.controller.role;



import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class RoleListServlet  {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/admin/role/list")
	protected String service(Model model) {

		List<RoleEntity> role = roleService.getAllRole();

		model.addAttribute("role", role);
		return "be/roleList";
	}

}
