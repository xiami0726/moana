package com.movietickets.dao.impl.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.movietickets.dao.impl.MovieTicketDaoImpl;
import com.movietickets.domain.MovieTicket;


public class MovieTicketDaoImplTest {
	
	@Test
	public void updateTest(){
		MovieTicketDaoImpl impl = new MovieTicketDaoImpl();
		
		MovieTicket ticket =  new MovieTicket();
		
		
		ticket.setMovieName("hehe");
		ticket.setMovieticketNum(200);
		Date date1 = new Date();
		Date date2 = new Date();
		long time = date1.getTime();
		time -= 2 * 30 * 30 *1000;
		date1.setTime(time);
		time += 4 * 30 * 30 *1000;
		date2.setTime(time);
		ticket.setStartTime(date1);
		ticket.setEndTime(date2);
		ticket.setMovieId(9);
		impl.update(ticket);
		System.out.println(ticket);
		
//		int num = impl.getMovieTicketNumberByMovieID(11);
//		
//		System.out.println("num = " + num);
//		
//		boolean b = impl.deleteMovieTicketByMovieId(10);
//		System.out.println(b);
		
//		ticket.setMovieName("lidong");
//		ticket.setMovieticketNum(300);
//		Date date1 = new Date();
//		Date date2 = new Date();
//		long time = date1.getTime();
//		time += 2 * 30 * 30 *1000;
//		date1.setTime(time);
//		time += 2 * 30 * 30 *1000;
//		date2.setTime(time);
//		ticket.setStartTime(date1);
//		ticket.setEndTime(date2);
//		ticket.setMovieId(9);
//		
//		Date date3 = new Date();
//		time -= 1 * 30 * 30 *1000;
//		date3.setTime(time);
//		System.out.println(date3.before(date1));
//		System.out.println(date3.before(date2));
//		
//		System.out.println(date3.after(date1));
//		System.out.println(date3.after(date2));
		
//		System.out.println("kaishi update");
//		impl.update(ticket);
//		System.out.println("jieshu update");
//		List<MovieTicket> result = impl.getAllMovieTicketInfo();
//		System.out.println("result66 = " + result);
//		
//		ticket.setMovieId(7);
//		boolean flag = impl.update(ticket);
//		impl.getAllMovieTicketInfo();
//		impl.update(ticket);
//		impl.getAllMovieTicketInfo();
//		impl.update(ticket);
//		impl.getAllMovieTicketInfo();
//		impl.update(ticket);
//		impl.getAllMovieTicketInfo();
//		impl.getAllMovieTicketInfo();
//		impl.getAllMovieTicketInfo();
//		System.out.println("movieticket flag = " + flag);
//		
	}
	
	
	
}
