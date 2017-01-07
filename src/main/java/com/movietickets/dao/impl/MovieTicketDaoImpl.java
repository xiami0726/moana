package com.movietickets.dao.impl;

import java.util.Date;
import java.util.List;


import com.movietickets.dao.MovieTicketDao;
import com.movietickets.dao.impl.datanucleus.impl.DataNucleusSQLOperationImpl;
import com.movietickets.domain.MovieTicket;

public class MovieTicketDaoImpl implements MovieTicketDao {
	private DataNucleusSQLOperationImpl sqlImpl = new DataNucleusSQLOperationImpl();
	@Override
	public void insert(MovieTicket ticket) {
		sqlImpl.insert(ticket);
		return ;
	}

	@Override
	public boolean update(MovieTicket ticket) {

		boolean flag = false;
		Date currentDate = new Date();
		if (getMovieTicketNumberByMovieID(ticket.getMovieId()) > 0  
				&& currentDate.after(ticket.getStartTime()) && currentDate.before(ticket.getEndTime())){
			flag = sqlImpl.update(MovieTicket.class, "UPDATE movie_ticket SET movieticketNum = movieticketNum - 1"
						+ " WHERE movieId = " + ticket.getMovieId() + "");
			System.out.println("flag = " + flag);
		}
		return flag;
	}

	@Override
	public boolean deleteMovieTicketByMovieId(int movieId) {
		Boolean flag = sqlImpl.deleteObjectByPrimaryKey(MovieTicket.class, movieId);
		return flag;
	}

	@Override
	public int getMovieTicketNumberByMovieID(int movieId) {
		List<MovieTicket> result = sqlImpl.selectBySQLQuery(MovieTicket.class, "SELECT movieId,movieName,movieticketNum,startTime,endTime FROM  movie_ticket WHERE movieId = " + movieId);
		if (result != null && result.size() > 0){
			return result.get(0).getMovieticketNum();
		} else {
			return 0;
		}
	}

	@Override
	public MovieTicket getMovieTicketByMovieID(int movieId) {
		return sqlImpl.getObjectByPrimarykey(MovieTicket.class, movieId);
	}
	
	private int a = 1;
	@Override
	public List<MovieTicket> getAllMovieTicketInfo() {
//		return  sqlImpl.selectByQuery("SELECT FROM " + MovieTicket.class.getName());
		List<MovieTicket> result = sqlImpl.selectBySQLQuery(MovieTicket.class, "SELECT movieId,movieName,movieticketNum,startTime,endTime FROM  movie_ticket");
		return result;
		
//		PersistenceManager pm = DataNucleusUtils.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//		List<MovieTicket> result = null;
//		try{
//			
////			tx.begin();
////			Query query = pm.newQuery("SELECT FROM " + MovieTicket.class.getName());
////			Query query = pm.newQuery(MovieTicket.class, "");
//			Query query = pm.newQuery("javax.jdo.query.SQL", "SELECT movieId,movieName,movieticketNum,startTime,endTime FROM  movie_ticket");
//			query.setResultClass(MovieTicket.class);	//添加这行代码，可以直接从数据库更新实际数据
//			result = (List<MovieTicket>)query.execute();		
//			++a;
//			System.out.println("selectByQuerystring2 = " + a + result);
////			tx.commit();
//		}
//		catch (Exception e)
//		{
//		    System.out.println(" selectByQuery : " + e.getMessage());
//		}
//		finally
//		{
//		    if (tx.isActive())
//		    {
//		        tx.rollback();
//		    }
//		    pm.close();
//		}
//		return result;
	}

}
