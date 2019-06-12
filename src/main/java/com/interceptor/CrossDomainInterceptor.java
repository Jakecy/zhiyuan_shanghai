package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/***
 * 跨域拦截器
 * @author Administrator
 *
 */
public class CrossDomainInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("跨域请求到来  preHandle execute");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
			response.setHeader("Access-Control-Max-Age","1728000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers"); 
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}else{
			response.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
			response.setHeader("Access-Control-Max-Age","1728000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers"); 
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			response.addHeader("Access-Control-Allow-Origin", "");
			response.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
			response.setHeader("Access-Control-Max-Age","1728000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers"); 
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}else{
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
			response.setHeader("Access-Control-Max-Age","1728000");
			response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers"); 
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}
		System.out.println("afterCompletion execute "+response.getHeader("Access-Control-Allow-Origin"));
	}

}
