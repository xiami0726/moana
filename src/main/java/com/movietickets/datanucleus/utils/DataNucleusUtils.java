package com.movietickets.datanucleus.utils;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class DataNucleusUtils {
	
	private  static final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");

	public static PersistenceManagerFactory get(){
	    return pmf;
	}
	
	public static PersistenceManager getPersistenceManager(){
		return pmf.getPersistenceManager();
	}
//	private  static PersistenceManagerFactory pmf;
//	private  static PersistenceManager pm;
//	
//	static {
//		pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
//		
//
//		
//		pm = pmf.getPersistenceManager();
////		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
////			
////			@Override
////			public void run() {
////				// TODO Auto-generated method stub
////				System.out.println("释放pmf资源");
////				pmf.close();
////				
////			}
////		}));
//	}
//	
//	public static PersistenceManager getPersistenceManager(){
//		return pm;
//	}
//	
}
