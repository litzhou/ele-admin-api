package com.vacomall.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.vacomall.common.bean.Rest;
import com.vacomall.common.util.HttpUtil;
import com.vacomall.common.util.JsonUtil;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
	
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if(this.isLoginRequest(request, response)) {  
            if(this.isLoginSubmission(request, response)) {  
                return this.executeLogin(request, response);  
            } else {  
                return true;  
            }  
        } else {
        	if(HttpUtil.isAjax(httpRequest)){
        		HttpUtil.ajaxStatus(httpResponse, 302, JsonUtil.toJson(Rest.failure("登录失效")));
            }else{  
                this.saveRequestAndRedirectToLogin(request, response);  
            }  
            return false;  
        }  
	}
	
}
