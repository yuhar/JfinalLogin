package com.demo.user;

import com.demo.common.model.Account;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class UserValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequiredString("account.name", "nameMsg", "请输入手机号!");
		validateRequiredString("account.password", "passwordMsg", "请输入6-10位字符!");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(Account.class);
		
	}

}
