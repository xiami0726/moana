package com.movietickets.service;


import java.util.Date;
import java.util.List;

import com.movietickets.domain.MovieTicket;

public interface MovieTicketService {
	List<MovieTicket> getAllMovieTicktInfo();
	
	int getMovieTicketNum(int movieId);
	
	boolean buyMovieTicket(int movieId, Date buyTime);
	
	MovieTicket getMovieTicketInfoByMovieId(int movieId);
}
