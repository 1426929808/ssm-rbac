package com.nf.rbac.controller.be;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginServlet  {
	@RequestMapping("/login")
	protected String service() {
        return "login";
	}
}
