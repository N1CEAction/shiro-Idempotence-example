package com.n1ce.shiro.handlers;

import com.n1ce.shiro.common.handler.BaseHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shiro/test")
public class FormHandler extends BaseHandler{
	
	@RequestMapping("/form")
	public String testForm(HttpServletRequest request, HttpServletResponse response){

		if(isUuidValidate(request)){
			System.out.println("注册成功！");
			resetUuid();
		}else{
			System.out.println("无效或重复提交！");
		}

		return "redirect:/list.jsp";
	}


}
