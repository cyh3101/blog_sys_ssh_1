package com.blog.sys.action;

import com.blog.sys.entity.User;
import com.blog.sys.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paddy on 2017/3/12.
 */
public class BlogAction extends ActionSupport implements SessionAware{
	private BlogService blogService;
	private Map<String, Object> session;
	private User user;
	
	public void setBlogService (BlogService blogService) {
		this.blogService = blogService;
	}
	
	public String tosave(){
		System.out.println ("Save User" );
		String result = blogService.save (user);
		if (result == "Success") {
			return SUCCESS;
		} else {
			HttpServletRequest request = ServletActionContext.getRequest ();
			request.getSession ().setAttribute ("errorMsgRegister", "用户已存在");
			return ERROR;
		}
	}
	
	
	public String userLogin(){
		HttpServletRequest request = ServletActionContext.getRequest ();
		String IdCodeNumber;
		String IdCodeInput;
		IdCodeInput = request.getParameter ("IdCode");
		IdCodeNumber = (String) session.get ("IdCodeNumber");
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

	
	@Override
	public void setSession (Map<String, Object> session) {
		this.session = session;
	}
	
}
