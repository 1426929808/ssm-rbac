package com.nf.rbac.interceptor;

import com.nf.rbac.entity.MenuEntity;
import com.nf.rbac.entity.RoleEntity;
import com.nf.rbac.entity.UserEntity;
import com.nf.rbac.service.RoleService;
import com.nf.rbac.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author cj
 * @date 2019/12/3
 */
@Component
public class PrivilegeInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService ;

    @Autowired
    private RoleService roleService ;
    private String loginUrl = "/login";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();


        UserEntity user = (UserEntity) session.getAttribute("user");
        if(user==null) {
            response.sendRedirect(loginUrl);
            return false;
        }


        RoleEntity role = userService.getUserRole(user.getId());
        List<MenuEntity> privileges = roleService.getRolePrivilege(role.getId());


        String requestUri = getRequestUrl(request);
        List<String> list = getprivilege(privileges);

        if(isAllowd(list, requestUri)) {
            return true;
        }else {
            response.sendRedirect("/unauthorized");
            return false;
        }
    }





    public boolean isAllowd(List<String> list,String requestUri) {
        boolean isAllowd = false;
        for(String allowList:list) {
            if(allowList.equals(requestUri)) {
                isAllowd=true;
                break;
            }
        }
        return isAllowd;
    }




    public List<String> getprivilege(List<MenuEntity> privileges){
        Set<String> set = new TreeSet<String>();
        for(MenuEntity privilege:privileges) {
            String[] uris = privilege.getUri().trim().split(",");
            if(uris!=null) {
                for(String uri:uris) {
                    set.add(uri);
                }
            }
        }
        return new ArrayList<>(set);
    }


    public String getRequestUrl(HttpServletRequest request) {
        String context = request.getContextPath();
        String requestUri =  request.getRequestURI();
        String result = requestUri.substring(context.length());
        return result;
    }
}
