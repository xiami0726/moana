package com.movietickets.domain;

import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.movietickets.dao.impl.MovieTicketDaoImpl;



public class Main {

	public static void main(String[] args) {
		
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		try{
//		tx.begin();
//		User u = new User();
//		u.setEmail("7236@qq.com");
//		u.setUserName("123");
//		u.setPassword("123456");
//		pm.makePersistent(u);
//		tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			} 
			
		}
		
		
		  pm = pmf.getPersistenceManager();
	        tx = pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            System.out.println("Retrieving Extent for Products");
	            Extent e = pm.getExtent(User.class, true);
	            Iterator iter = e.iterator();
	            while (iter.hasNext())
	            {
	                Object obj = iter.next();
	                User u = (User)obj;
	                
	                System.out.println(">  " + u.getEmail() + " "+ u.getPassword()+" " + u.getUserName());
	            }
	            tx.commit();
	        }
	        catch (Exception e)
	        {
	            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
				pmf.close();
	        }
	        System.out.println("");
		
		
//		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
//		
//		PersistenceManager pm = pmf.getPersistenceManager();
//		
//		Transaction tx = pm.currentTransaction();
//		try{
//		tx.begin();
//		User u = new User();
//		u.setUserName("ld723670997");
//		u.setPassword("123456");
//		u.setEmail("723670997@qq.com");
//		
//		pm.makePersistent(u);
//		tx.commit();
//		} catch(Exception e){
//			e.printStackTrace();
//			
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			} 
//			
//		}
//		
//		
//		  pm = pmf.getPersistenceManager();
//	        tx = pm.currentTransaction();
//	        try
//	        {
//	            tx.begin();
//	            System.out.println("Retrieving Extent for Products");
//	            Extent e = pm.getExtent(User.class, true);
//	            Iterator iter = e.iterator();
//	            while (iter.hasNext())
//	            {
//	                Object obj = iter.next();
//	                User u = (User)obj;
//	                
//	                System.out.println(">  " + u.getUserName() + " "+ u.getPassword()+" " + u.getEmail() +" "+u.getUserId());
//	            }
//	            tx.commit();
//	        }
//	        catch (Exception e)
//	        {
//	            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
//	        }
//	        finally
//	        {
//	            if (tx.isActive())
//	            {
//	                tx.rollback();
//	            }
//	            pm.close();
//				pmf.close();
//	        }
//	        System.out.println("");
	}

}
