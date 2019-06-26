package com.demo.blog;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;


public class BlogInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
		HttpSession session = inv.getController().getSession();
		if(session == null) {
			inv.getController().redirect("/user");
		}
		else {
			Boolean validate = (Boolean) session.getAttribute("validated");
			if(validate == null || !validate) {
				inv.getController().redirect("/user");
			}
		}
		
		
	}
}
