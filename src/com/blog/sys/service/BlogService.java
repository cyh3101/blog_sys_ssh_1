package com.blog.sys.service;

import com.blog.sys.dao.BlogDao;
import com.blog.sys.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paddy on 2017/3/12.
 */
@Transactional
public class BlogService {
	
	private BlogDao blogDao;
	
	public void setBlogDao (BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
	public void query(){
		blogDao.queryUsers ();
	}
	
	public void findAllUser(){
		List<User> users = blogDao.findAllUser ();
		if (users != null) {
			for (User user : users) {
				System.out.println (user.toString () );
			}
		}
	}
	
	public boolean checkUserExit(User user){
		Map<String, Object> map = new HashMap<String, Object> ();
		map.put ("userName",user.getUserName ());
		List<User> users = blogDao.checkUserExist (map);
		if (user == null) {
			return false;
		} else {
			if (user.getPassword ().equals (users.get (0).getPassword ()))
				return true;
			else
				return false;
		}
	}
	
	public void save(User user){
		blogDao.save (user);
	}
}
