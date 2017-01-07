package com.movietickets.domain;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(table="order_record")
public class OrderRecord{
	@Persistent(primaryKey = "true",valueStrategy = IdGeneratorStrategy.INCREMENT)
	@Column(name="orderId")
	private int orderId;
	@Column(name="userId")
	private int userId;
	@Column(name="movieId")
	private int movieId;
	@Column(name="buyTime")
	private Date buyTime;
	@Column(name="num")
	private int num;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "OrderRecord [orderId=" + orderId + ", userId=" + userId + ", movieId=" + movieId + ", buyTime="
				+ buyTime + ", num=" + num + "]";
	}
	
	
	
}
