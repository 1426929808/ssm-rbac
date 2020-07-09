package com.nf.rbac.controller.user;


import com.nf.rbac.entity.UserEntity;
import com.nf.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInserServlet  {
    @Autowired
    private UserService userService;

	@RequestMapping("/admin/user/inser")
	protected void service(String userName,String password,String roleId) {

		UserEntity user = new UserEntity();
		user.setUsername(userName);
		user.setPassword(password);;


		userService.addUser(user);
		UserEntity u = userService.findUser(userName,password);
		userService.updateUserRole(u, roleId);
		
	}
	
}
