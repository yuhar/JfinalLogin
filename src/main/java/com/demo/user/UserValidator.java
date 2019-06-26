package com.demo.user;

import com.demo.common.model.Account;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class UserValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRegex("name", "\\b(1[3,5,7,8,9]\\d{9})\\b", "nameMsg", "电话号码格式错误");
		validateRegex("password", "^[a-zA-Z]\\w{5,8}$",  "passwordMsg", "密码不合规");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(Account.class);
		c.render("login.jsp");
		
	}

}
