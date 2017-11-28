package com.n1ce.shiro.handlers;

import com.n1ce.shiro.services.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {
	
	@Autowired
	private ShiroService shiroService;
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation(HttpSession session){
		session.setAttribute("key", "value12345");
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}


	@RequestMapping("/testShiroAnnotation")
	public String testIdempotence(HttpSession session){
		session.setAttribute("key", "value12345");
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		Subject currentUser = SecurityUtils.getSubject();

		// rememberme后在有效期内无需认证  rememberMeManager.cookie.maxAge
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
            	System.out.println("1. " + token.hashCode());
				// 执行登录
                currentUser.login(token);
            }
			// ... catch more exceptions here (maybe custom ones specific to your application?
			// 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败:  " + ae.getMessage());
            }
        }
		
		return "redirect:/list.jsp";
	}
	
}
