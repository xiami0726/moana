package com.movietickets.dao.impl.datanucleus.impl;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;


import com.movietickets.datanucleus.utils.DataNucleusUtils;
import com.movietickets.domain.MovieTicket;

public class DataNucleusSQLOperationImpl {
	public <T> void insert(T obj)
	{
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
		
			tx.begin();
			pm.makePersistent(obj);
			tx.commit();
		}
		catch (Exception e)
		{
		    System.out.println(" insert data : " + e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
		return;
	}
	
	public <T> T getObjectByPrimarykey(Class<T> var, Object primaryKey)
	{
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		T result = null;
		try{
			result = pm.getObjectById(var, primaryKey);
		}
		catch (Exception e)
		{
		    System.out.println("getObjectByPrimarykey1 : " + e.getMessage());
		}
		finally
		{
		    pm.close();
		}
		return result;
	}
	
	public <T> List<T> selectBySQLQuery(Class<T> var, String querySql)
	{
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<T> result = null;
		try{
			Query query = pm.newQuery("javax.jdo.query.SQL", querySql);
			query.setResultClass(var);
			result = (List<T>)query.execute();
			
//			System.out.println("selectByQuerystring = " + result);
		}
		catch (Exception e)
		{
		    System.out.println(" selectBySQLQuery : " + var.getName() +" "+ e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
		return result;
	}
	
	
	public <T> List<T> selectByQuery(Class<T> var, String querySql)
	{
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<T> result = null;
		try{
			Query query = pm.newQuery(var, querySql);
			result = (List<T>)query.execute();
//			System.out.println("selectByQueryvarstring = " + result);
		}
		catch (Exception e)
		{
		    System.out.println(" selectByQuery : " + e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
//		System.out.println("selectByQuery = " + result);
		return result;
	}
	
	
	
	public <T> boolean deleteObjectByPrimaryKey(Class<T> var, Object primaryKey)
	{
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean flag = false;
		try{
		
			tx.begin();
			T result = pm.getObjectById(var, primaryKey);
			if (result == null)
				return flag;
			pm.deletePersistent(result);
			tx.commit();
			flag = true;
		}
		catch (Exception e)
		{
		    System.out.println("deleteObjectByPrimaryKey : " + var.getName() +" " + e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
		return flag;
	}
	
	
	public <T> boolean update(Class<T> var , String querySql){
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean flag = false;
		try{
			tx.begin();
//			Query query = pm.newQuery(var, querySql);
//			query.execute();
			Query query = pm.newQuery("javax.jdo.query.SQL", querySql);
			query.setResultClass(var);
			query.execute();	
			tx.commit();
			flag = true;
		}
		catch (Exception e)
		{
		    System.out.println(" update data : "+ var.getName() + " " + e.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }
		    pm.close();
		}
		return flag;
	}
}
