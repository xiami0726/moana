package com.movietickets.dao;

import com.movietickets.domain.OrderRecord;

public interface OrderRecordDao {
	void insert(OrderRecord orderRecord);
	
	boolean update(OrderRecord orderRecord);
	
	int deleteByOrderId(int orderId);
	
	int deleteByUserId(int userId);
	
	OrderRecord selectByOrderId(int orderId);
}
