package com.nf.rbac.controller.be;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeServlet  {
	@RequestMapping("/home")
	protected String service() {
        return "home";
	}
}
