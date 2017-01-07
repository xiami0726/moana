package com.movietickets.dao.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.movietickets.dao.OrderRecordDao;
import com.movietickets.dao.impl.datanucleus.impl.DataNucleusSQLOperationImpl;
import com.movietickets.domain.OrderRecord;

public class OrderRecordDaoImpl implements OrderRecordDao {
	private DataNucleusSQLOperationImpl sqlImpl = new DataNucleusSQLOperationImpl();
	@Override
	public void insert(OrderRecord orderRecord) {
		sqlImpl.insert(orderRecord);
		return ;
	}

	@Override
	public boolean update(OrderRecord orderRecord) {
		boolean flag = false;
		Date date = new Date();
		SimpleDateFormat fomat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDate = fomat2.format(date);
		flag = sqlImpl.update(OrderRecord.class, "UPDATE order_record SET userId = " + 
						orderRecord.getUserId() + 
						", movieId = " + orderRecord.getMovieId()+
						", buyTime = '" + currentDate + "'" +
						", num = " + orderRecord.getNum() +
						" WHERE orderId = " + orderRecord.getOrderId() + "");
		return flag;
	}

	@Override
	public int deleteByOrderId(int orderId) {
		boolean flag = sqlImpl.deleteObjectByPrimaryKey(OrderRecord.class, orderId);
		
		if (flag == true){
			return orderId;
		} else {
			return -1;
		}
	}

	@Override
	public int deleteByUserId(int userId) {
		List<OrderRecord> result = sqlImpl.selectByQuery(OrderRecord.class, "SELECT FROM " + OrderRecord.class.getName() + " WHERE userId == " + userId);
		if (result == null)
			return -1;
		Iterator<OrderRecord> iter = result.iterator();
		int size = result.size();
		while (iter.hasNext()){
			sqlImpl.deleteObjectByPrimaryKey(OrderRecord.class, iter.next().getOrderId());
		}
		return size;
	}
	
	
	public int deleteByUserIdAndMovieId(int userId , int movieid) {
		List<OrderRecord> result = sqlImpl.selectByQuery(OrderRecord.class, "SELECT FROM " + OrderRecord.class.getName() + " WHERE userId == " + userId + " && movieId== "+ movieid);
//		System.out.println(" resultq = " + result);
		if (result == null)
			return -1;
		Iterator<OrderRecord> iter = result.iterator();
		int size = result.size();
		while (iter.hasNext()){
			sqlImpl.deleteObjectByPrimaryKey(OrderRecord.class, iter.next().getOrderId());
		}
		return size;
	}

	@Override
	public OrderRecord selectByOrderId(int orderId) {
		return sqlImpl.getObjectByPrimarykey(OrderRecord.class, orderId);
	}


}
