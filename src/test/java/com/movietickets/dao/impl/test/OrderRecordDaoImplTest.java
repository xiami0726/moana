package com.movietickets.dao.impl.test;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import com.movietickets.dao.impl.OrderRecordDaoImpl;
import com.movietickets.datanucleus.utils.DataNucleusUtils;
import com.movietickets.domain.OrderRecord;

public class OrderRecordDaoImplTest 
{
	@Test
	public void orderTest(){
		OrderRecordDaoImpl impl = new OrderRecordDaoImpl();
		OrderRecord orderRecord = new OrderRecord();
		orderRecord.setBuyTime(new Date());
		orderRecord.setMovieId(15);
		orderRecord.setUserId(1);
		orderRecord.setNum(3);
		orderRecord.setOrderId(1);
		impl.update(orderRecord);
//		System.out.println(orderRecord);
		
//		impl.deleteByUserIdAndMovieId(0, 15);
		
//		impl.update(orderRecord);
//		impl.insert(orderRecord);
//		impl.deleteByOrderId(2);
//		impl.deleteByUserId(0);
	}
	
	@Test
	public void deleteTset(){
		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
	        List<OrderRecord> result = null;
//	            Query q = pm.newQuery(OrderRecord.class, "userId == 0");
	        Query q = pm.newQuery("SELECT FROM " + OrderRecord.class.getName() + 
                    " WHERE userId==0 ORDER BY movieId");
	        result = (List<OrderRecord>) q.execute();
//			System.out.println("result  = " + result);

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
		return;
	}
}
