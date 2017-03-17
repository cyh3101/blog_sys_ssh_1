package com.blog.sys.dao;

import com.blog.sys.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by paddy on 2017/3/12.
 */
//导入了模版
//继承了HibernateDaoSupport后能直接使用工程模式，省去麻烦
public class BlogDao extends HibernateDaoSupport {
	
	
//	分页查询
	public List<User> findByPage(int begin, int pageSize){
		DetachedCriteria criteria = DetachedCriteria.forClass (User.class);
		List<User> users = this.getHibernateTemplate ().findByCriteria (criteria, begin, pageSize);
		return users;
	}
	
	//确定用户存在()
	//返回Exist为存在该用户
	//返回None为不存在该用户
	public String checkUserExist(String userName){
		StringBuilder hql = new StringBuilder ( );
		hql.append ("from User ");
		hql.append ("where userName='" + userName + "' ");
		try {
			List<User> users = this.getHibernateTemplate ( ).find (hql.toString ( ));
			if (users!=null||users.get (0)!=null) {
				System.out.println (users.get (0).getUserName () + " " + users.get (0).getPassword () );
				System.out.println ("用户已存在" );
				return "Exist";
			}
			else
				return "None";
		} catch (Exception e) {
			return "None";
		}
	}
	
	//保存用户
	public void save(User user){
		System.out.println ("用户保存成功" );
		//调用模版来保存对象的数据库
		this.getHibernateTemplate ().save (user);
	}
	
	//确认密码
	//返回Correct为密码正确
	//返回Error为密码错误
	//返回None为没有该用户
	public String checkPassword(User user){
		StringBuilder hql = new StringBuilder ( );
		System.out.println (user.getPassword () );
		hql.append ("from User ");
		hql.append ("where userName='" + user.getUserName ( ) + "' ");
		try {
			List<User> users = this.getHibernateTemplate ().find (hql.toString ());
			if (users.get (0).getPassword ( ).equals (user.getPassword ( ))) {
				return "Correct";//
			} else {
				System.out.println (users.get (0).getPassword () );
				return "Error";
			}
		}catch (Exception e){
			return "None";
		}
	}
	
	
}
