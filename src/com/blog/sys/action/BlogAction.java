package com.blog.sys.action;

import com.blog.sys.entity.User;
import com.blog.sys.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paddy on 2017/3/12.
 */
public class BlogAction extends ActionSupport implements SessionAware,RequestAware{
	private BlogService blogService;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private User user;
	
	public void setBlogService (BlogService blogService) {
		this.blogService = blogService;
	}
	
	public String tosave(){
		HttpServletRequest request = ServletActionContext.getRequest ();
		System.out.println ("userName: " + user.getUserName () + " " + "password: " + user.getPassword () );
		System.out.println ("Save User" );
		String result = blogService.save (user);
		if (result == "Success") {
			return SUCCESS;
		} else {
			request.getSession ().setAttribute ("errorMsgRegister", "用户已存在");
			return ERROR;
		}
	}
	
	
	public String userLogin(){
		HttpServletRequest request = ServletActionContext.getRequest ();
		String IdCodeNumber;
		String IdCodeInput;
		System.out.println ("userName: " + user.getUserName () + " " + "password: " + user.getPassword () );
		IdCodeInput = request.getParameter ("IdCode");
		IdCodeNumber = (String) session.get ("IdCodeNumber");
		session.clear ();
		System.out.println (IdCodeNumber);
		if (! IdCodeInput.equals (IdCodeNumber)) {
			System.out.println ("验证码错误");
			request.getSession ( ).setAttribute ("errorMsg", "验证码错误");
			return ERROR;
		}
		switch (blogService.checkPassword (user.getUserName ( ), user.getPassword ( ))) {
			case "Correct":
				return SUCCESS;
			case "Error":
				request.getSession ().setAttribute ("errorMsg", "密码错误");
				return ERROR;
			case "None":
				request.getSession ().setAttribute ("errorMsg", "没有该用户");
				return ERROR;
			default:return ERROR;
		}
		
	}
	
	
	public void setUser (User user) {
		this.user = user;
	}
	
	
	public User getUser () {
		return user;
	}
	
	@Override
	public void setSession (Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public void setRequest (Map<String, Object> request) {
		this.request = request;
	}
}
