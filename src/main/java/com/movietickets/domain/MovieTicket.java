package com.movietickets.domain;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(table="movie_ticket")
public class MovieTicket{
	
	@Persistent(primaryKey = "true",valueStrategy = IdGeneratorStrategy.INCREMENT)
	@Column(name="movieId")
	private int movieId;
	
	@Column(name = "movieName")
	private String movieName;
	
	@Column(name = "movieticketNum")
	private int movieticketNum;
	
	@Column(name = "startTime")
	private Date startTime;
	
	@Column(name = "endTime")
	private Date endTime;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getMovieticketNum() {
		return movieticketNum;
	}
	public void setMovieticketNum(int movieticketNum) {
		this.movieticketNum = movieticketNum;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "MovieTicket [movieId=" + movieId + ", movieName=" + movieName + ", movieticketNum=" + movieticketNum
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
