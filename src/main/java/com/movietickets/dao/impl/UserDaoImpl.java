package com.movietickets.dao.impl;


import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.movietickets.dao.impl.datanucleus.impl.DataNucleusSQLOperationImpl;
import com.movietickets.domain.User;
public class UserDaoImpl  {
	
	private DataNucleusSQLOperationImpl sqlImpl = new DataNucleusSQLOperationImpl();
	

	public static void insert(String userName, String password, String email) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
//		PersistenceManager pm = DatanucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			
			tx.begin();
//			Query q = pm.newQuery("javax.jdo.query.SQL", "INSERT INTO user VALUES(" + 0 +"," + "'" + userName +"'" +"," + "'" + password +"'" +",'" + email +"')");
//			q.execute();
			User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setUserName(userName);  
            pm.makePersistent(user);
			tx.commit();
		}
		catch (Exception e)
		{
		    System.out.println(" insert data userId userName  email: " + e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
		return ;
	}
	
	
	public  void  insert(User user) {
		sqlImpl.insert(user);
		return ;
	}


	public boolean update(User user) {
		boolean flag = false;
		flag = sqlImpl.update(User.class, "UPDATE user SET email = '" + 
						user.getEmail()+ "'"+
						", password = '" + user.getPassword() + "'" +
						", userName = '" + user.getUserName() + "'" +
						" WHERE userId = " + user.getUserId() + "");
		return flag;
	}


	public User deleteUserByUserName(String userName) {
		User user = selectByUserName(userName);
		if (user == null)
			return user;
		sqlImpl.deleteObjectByPrimaryKey(User.class, user.getUserId());
		return user;
	}


	public User deleteUserByEmail(String email) {
//		User user = selectByEmail(email);
//		if (user == null)
//			return user;
//		sqlImpl.deleteObjectByPrimaryKey(User.class, user.getUserId());
//		return user;
		return null;
	}


	public User selectByUserId(int id) {
		return sqlImpl.getObjectByPrimarykey(User.class, id);
//		return null;
	}


	public User selectByUserName(String userName) {
//		List<User> result = sqlImpl.selectByQuery(User.class, "SELECT FROM " + User.class.getName()
//				+ " WHERE userName == '" + userName + "'");
		List<User> result = sqlImpl.selectByQuery(User.class, "userName == '" + userName + "'");
		if (result == null || result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

	public User selectByEmail(String email) {
//		List<User> result = sqlImpl.selectByQuery(User.class, "SELECT FROM " + User.class.getName()
//				+ " WHERE email == '" + email + "'");
		List<User> result = sqlImpl.selectByQuery(User.class, "email == '" + email + "'");
		if (result == null || result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

}
