package com.movietickets.dao;

import java.util.List;

import com.movietickets.domain.MovieTicket;

public interface MovieTicketDao {
	void insert(MovieTicket ticket);
	
	boolean update(MovieTicket ticket);
	
	boolean deleteMovieTicketByMovieId(int movieId);
	
	int getMovieTicketNumberByMovieID(int movieId);
	
	MovieTicket getMovieTicketByMovieID(int movieId);
	
	List<MovieTicket> getAllMovieTicketInfo();
}
