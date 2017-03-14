package com.blog.sys.dao;

import com.blog.sys.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by paddy on 2017/3/12.
 */
//导入了模版
//继承了HibernateDaoSupport后能直接使用工程模式，省去麻烦
public class BlogDao extends HibernateDaoSupport {
	
	public List<User> queryUsers(){
		List users = new ArrayList ( );
		
		StringBuilder hql = new StringBuilder ( );
		hql.append ("from User");
		users = this.getHibernateTemplate ().find (hql.toString ());
		if (users!=null) {
			System.out.println ("Dao query work!");
			System.out.println (users.get (0).toString () );
		}
		else
			System.out.println ("Dao didn't work!" );
		return users;
	}
	
	public List<User> findAllUser(){
		List<User> users;
		
		StringBuilder hql = new StringBuilder ();
		hql.append ("from User");
		users = this.getHibernateTemplate ().find (hql.toString ());
		return users;
	}
	
//	分页查询
	public List<User> findByPage(int begin, int pageSize){
		DetachedCriteria criteria = DetachedCriteria.forClass (User.class);
		List<User> users = this.getHibernateTemplate ().findByCriteria (criteria, begin, pageSize);
		return users;
	}
	
	//确定用户存在()登录用,返回用户的所有数据，有点危险
	public List<User> checkUserExist(Map<String,Object> map){
		StringBuilder hql = new StringBuilder ();
		try {
			hql.append ("from User where ");
			if (map.get ("userName") != null) {
				hql.append ("userName='" + map.get ("userName") + "'");
				List<User> users = this.getHibernateTemplate ( ).find (hql.toString ( ));
				return users;
			}
		} catch (Exception e) {
			System.out.println ("用户名错误" );
		}
		
//		hql.append (" password=" + map.get ("password"));
		return null;
	}
	
	//保存用户
	public void save(User user){
		System.out.println ("BlogDao work! " );
		//调用模版来保存对象的数据库
		this.getHibernateTemplate ().save (user);
	}
}
