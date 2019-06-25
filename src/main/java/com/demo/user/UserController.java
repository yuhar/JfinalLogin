package com.demo.user;

import com.demo.blog.BlogService;
import com.demo.common.model.Account;
import com.demo.common.model.Blog;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

public class UserController extends Controller{
	@Inject
	UserService service;
	@Inject
	BlogService blogService;
	public void index() {
		//setAttr("userlist", service.paginate(getParaToInt(0, 1), 10));
		render("login.jsp");
	}
	
	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(UserValidator.class)
	public void save() {
		getBean(Account.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(UserValidator.class)
	public void update() {
		getBean(Blog.class).update();
		redirect("/user");
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/user");
	}
	
	public void login1() {
		String name = getPara("name");//获取表单数据，这里的参数就是页面表单中的name属性值
		String password = getPara("password");
		Account item =service.findByName(name);//根据用户名查询数据库中的用户
		if(item != null) {
			if(password.equals(item.getStr("password"))) {//判断数据库中的密码与用户输入的密码是否一致

				setAttr("blogPage", blogService.paginate(getParaToInt(0, 1), 10));//设置session，保存登录用户的昵称
				render("/blog/blog.html");
			}
			else {
				render("login.jsp");
			}
		}
		else {
			render("login.jsp");
		}

	}
	
//	@Before(UserValidator.class)
	public void signup() {
		getBean(Account.class).save();
		Account account=getBean(Account.class);
		account.save();
		redirect("/user");
	}
}
