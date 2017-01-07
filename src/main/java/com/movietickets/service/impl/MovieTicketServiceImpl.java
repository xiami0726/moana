package com.movietickets.service.impl;


import java.util.Date;
import java.util.List;

import com.movietickets.dao.impl.MovieTicketDaoImpl;
import com.movietickets.domain.MovieTicket;
import com.movietickets.service.MovieTicketService;

public class MovieTicketServiceImpl implements MovieTicketService{
	private MovieTicketDaoImpl movieDaoImpl = new MovieTicketDaoImpl();
	@Override
	public List<MovieTicket> getAllMovieTicktInfo() {
		List<MovieTicket> result = movieDaoImpl.getAllMovieTicketInfo();
		return result;
	}

	@Override
	public int getMovieTicketNum(int movieId) {
		return movieDaoImpl.getMovieTicketNumberByMovieID(movieId);
	}

	@Override
	public boolean buyMovieTicket(int movieId, Date buyTime) {
//		MovieTicketDaoImpl movieDaoImpl = new MovieTicketDaoImpl();
		
		MovieTicket ticket = movieDaoImpl.getMovieTicketByMovieID(movieId);
		return movieDaoImpl.update(ticket);
	}

	@Override
	public MovieTicket getMovieTicketInfoByMovieId(int movieId) {
//		MovieTicketDaoImpl movieDaoImpl = new MovieTicketDaoImpl();	
		return movieDaoImpl.getMovieTicketByMovieID(movieId);
	}
}
