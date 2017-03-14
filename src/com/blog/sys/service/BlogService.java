package com.blog.sys.service;

import com.blog.sys.dao.BlogDao;
import com.blog.sys.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by paddy on 2017/3/12.
 */
@Transactional
public class BlogService {
	
	private BlogDao blogDao;
	
	public void setBlogDao (BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	

	//检测用户是否存在
	public String checkUserExist(String userName){
		switch (blogDao.checkUserExist (userName)) {
			case "Exist":
				return "Exist";
			case "None":
				return "None";
			default:
				return "Error";
		}
	}
	
	public String save(User user){
		switch (checkUserExist (user.getUserName ( ))) {
			case "Exist":
				return "Exist";
			case "None":
				blogDao.save (user);
				return "Success";
			default:
				return "Error";
		}
	}
	
	//返回Correct为密码正确
	//返回Error为密码错误
	//返回None为没有该用户
	public String checkPassword (String userName, String password) {
		User user = new User ( );
		user.setPassword (password);
		user.setUserName (userName);
		switch (blogDao.checkPassword (user)) {
			case "Correct":
				return "Correct";
			case "Error":
				return "Error";
			case "None":
				return "None";
			default:return "None";
		}
	}
	
	
}
