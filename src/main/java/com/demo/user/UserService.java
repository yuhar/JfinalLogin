package com.demo.user;

import com.demo.common.model.Account;
import com.jfinal.plugin.activerecord.Page;

public class UserService {
private Account dao = new Account().dao();
	
	public Page<Account> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from account order by id asc");
	}
	
	public Account findById(int id) {
		return dao.findById(id);
	}
	
	public Account findByName(String name) {
		return dao.findFirst("select * from account where name=?",name);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
