package com.blog.sys.action;

import com.blog.sys.entity.User;
import com.blog.sys.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paddy on 2017/3/12.
 */
public class BlogAction extends ActionSupport implements ModelDriven<User>, SessionAware{
	private BlogService blogService;
	private Map<String, Object> session;
	private User user;
	
	public void setBlogService (BlogService blogService) {
		this.blogService = blogService;
	}
	
	public String tosave(){
		User user = new User ();
		user.setUserName ("paddy");
		user.setPassword ("abc123");
		System.out.println ("Save User" );
		blogService.save (user);
		return NONE;
	}
	
	public void query(){
//		System.out.println ("Query" );
		blogService.findAllUser ();
	}
	
	public boolean checkUserExist(User user){
		
		return blogService.checkUserExit (user);
	}
	
	public String userLogin(){
		HttpServletRequest request = ServletActionContext.getRequest ();
		String IdCodeNumber;
		String IdCodeInput;
		IdCodeInput = request.getParameter ("IdCode");
		if (session != null) {
			System.out.println ("session not null!");
			IdCodeNumber = (String) session.get ("IdCodeNumber");
			System.out.println (IdCodeNumber);
			if (! IdCodeInput.equals (IdCodeNumber)) {
				request.setAttribute ("error_message","验证码错误");
				return ERROR;
			} else {
				if (checkUserExist (user) == false) {
					request.setAttribute ("error_message","密码错误");
					return ERROR;
				} else {
					request.setAttribute ("userName", user.getUserName ());
					return SUCCESS;
				}
			}
			
		} else {
			System.out.println ("session is null!" );
		}
		request.setAttribute ("error_message", "请填入密码和验证码");
		return ERROR;
		
		
	}
	
	
	public User getUser () {
		return user;
	}
	
	public void setUser (User user) {
		this.user = user;
	}
	
	@Override
	public User getModel () {
		if (user == null) {
			user = new User ( );
		}
		return user;
	}
	
	@Override
	public void setSession (Map<String, Object> session) {
		this.session = session;
	}
}
