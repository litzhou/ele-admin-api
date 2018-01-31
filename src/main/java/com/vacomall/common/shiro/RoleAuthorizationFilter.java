package com.vacomall.common.shiro;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.vacomall.common.bean.Rest;
import com.vacomall.common.util.HttpUtil;
import com.vacomall.common.util.JsonUtil;

/**
 * 重写权限验证
 * @author jameszhou
 *
 */
public class RoleAuthorizationFilter extends AuthorizationFilter{
	
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
	  
	        Subject subject = getSubject(request, response);  
	        if (subject.getPrincipal() == null) {  
	            if (HttpUtil.isAjax(httpRequest)) {  
	                HttpUtil.ajaxStatus(httpResponse,302,JsonUtil.toJson(Rest.failure("登录失效")));  
	            } else {  
	                saveRequestAndRedirectToLogin(request, response);  
	            }  
	        } else {  
	            if (HttpUtil.isAjax(httpRequest)) {  
	            	 HttpUtil.ajaxStatus(httpResponse,302,JsonUtil.toJson(Rest.failure("没有权限"))); 
	            } else {  
	                String unauthorizedUrl = getUnauthorizedUrl();  
	                if (StringUtils.hasText(unauthorizedUrl)) {  
	                    WebUtils.issueRedirect(request, response, unauthorizedUrl);  
	                } else {  
	                    WebUtils.toHttp(response).sendError(401);  
	                }  
	            }  
	        }  
	        return false;  
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// TODO Auto-generated method stub
		Subject subject = getSubject(request, response);  
        String[] rolesArray = (String[]) mappedValue;  
  
        if (rolesArray == null || rolesArray.length == 0) {  
            // no roles specified, so nothing to check - allow access.  
            return true;  
        }  
        Set<String> roles = CollectionUtils.asSet(rolesArray);  
        for (String role : roles) {  
            if (subject.hasRole(role)) {  
                return true;  
            }  
        }  
        return false;  
	}

}
