package com.nf.rbac.controller.privilege;

import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.service.MenuService;
import com.nf.rbac.service.PrivilegeService;
import com.nf.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrivilegeListServlet  {

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

	@RequestMapping("/admin/privilege/list")
    @ResponseBody
	protected List<Map<String,Object>> service(String roleId)  {

		List<Map<String,Object>> jsonArray = new ArrayList<Map<String,Object>>();

		List<MenuEntity> list = menuService.getAllMenus();

		List<MenuEntity> rolePrivilege = roleService.getRolePrivilege(roleId);
		
		
		for(MenuEntity p:list) {
			Map<String, Object> jsonObject = new HashMap<String, Object>();
			jsonObject.put("id", p.getId());
			jsonObject.put("pId", p.getPid());
			jsonObject.put("name", p.getName());
			jsonObject.put("open","true");
			for(MenuEntity r:rolePrivilege) {
				if(p.getId().equals(r.getId())) {
					jsonObject.put("checked","true");
				}
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
}