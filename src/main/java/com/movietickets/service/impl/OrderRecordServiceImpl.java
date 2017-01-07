package com.movietickets.service.impl;

import java.util.Date;

import com.movietickets.dao.OrderRecordDao;
import com.movietickets.dao.impl.OrderRecordDaoImpl;
import com.movietickets.domain.OrderRecord;
import com.movietickets.service.OrderRecordService;

public class OrderRecordServiceImpl implements OrderRecordService {

	@Override
	public void GenerateOrder(int userId, int movieId, int num) {
		OrderRecord orderRecord = new OrderRecord();
		orderRecord.setBuyTime(new Date());
		orderRecord.setUserId(userId);
		orderRecord.setMovieId(movieId);
		orderRecord.setNum(num);
		
		OrderRecordDao orderImpl = new OrderRecordDaoImpl();
		orderImpl.insert(orderRecord);
	}

}
