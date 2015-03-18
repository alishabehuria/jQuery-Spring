package com.demo.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.restaurant.model.BevOrder;
import com.demo.restaurant.model.Beverage;
import com.demo.restaurant.model.HotDrinks;
import com.demo.restaurant.model.MainCourse;
import com.demo.restaurant.model.Order;
import com.demo.restaurant.model.Snacks;

public class RestaurantDAOImpl implements RestaurantDAO{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/USER_DETAILS";
//  Database credentials
   static final String USER = "root";
   static final String PASS = "";

   @Override
   public List<Beverage> fetchBeverage() throws SQLException{
	   ArrayList<Beverage> bevList = new ArrayList<Beverage>();
		Connection conn=null;
		Statement stmt=null;
		Beverage bev=null;
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connecting to the DB");
			stmt=conn.createStatement();
			String sql="select * from BEVERAGE1";
			ResultSet beverageList = stmt.executeQuery(sql);
			while(beverageList.next()){
				bev = new Beverage();
				bev.setId(beverageList.getInt("ID"));
				bev.setItem_name(beverageList.getString("ITEM_NAME"));
				bev.setPrice(beverageList.getString("PRICE"));
				bev.setTax(beverageList.getString("TAX"));
				bev.setTotal(beverageList.getString("TOTAL"));
				bevList.add(bev);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(SQLException sqe){
				sqe.printStackTrace();
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(SQLException sqlex1){
				sqlex1.printStackTrace();
			}
		}
		return bevList;
   }





@Override
public List<MainCourse> listMainCourse() throws SQLException{
	   ArrayList<MainCourse> mainCourseList = new ArrayList<MainCourse>();
		Connection conn=null;
		Statement stmt=null;
		MainCourse main=null;
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connecting to the DB");
			stmt=conn.createStatement();
			String sql="select * from maincourse1";
			ResultSet mainList = stmt.executeQuery(sql);
			while(mainList.next()){
				main = new MainCourse();
				main.setId(mainList.getInt("ID"));
				main.setItem_name(mainList.getString("ITEM_NAME"));
				main.setPrice(mainList.getString("PRICE"));
				main.setTax(mainList.getString("TAX"));
				main.setTotal(mainList.getString("TOTAL"));
				mainCourseList.add(main);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(SQLException sqe){
				sqe.printStackTrace();
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(SQLException sqlex1){
				sqlex1.printStackTrace();
			}
		}
		return mainCourseList;
}


@Override
public List<HotDrinks> listHotDrinks() {
	 ArrayList<HotDrinks> hotDrinksList = new ArrayList<HotDrinks>();
		Connection conn=null;
		Statement stmt=null;
		HotDrinks hotDrinks=null;
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connecting to the DB");
			stmt=conn.createStatement();
			String sql="select * from hotdrinks";
			ResultSet mainList = stmt.executeQuery(sql);
			while(mainList.next()){
				hotDrinks = new HotDrinks();
				hotDrinks.setId(mainList.getInt("ID"));
				hotDrinks.setItem_name(mainList.getString("ITEM_NAME"));
				hotDrinks.setPrice(mainList.getString("PRICE"));
				hotDrinks.setTax(mainList.getString("TAX"));
				hotDrinks.setTotal(mainList.getString("TOTAL"));
				hotDrinksList.add(hotDrinks);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(SQLException sqe){
				sqe.printStackTrace();
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(SQLException sqlex1){
				sqlex1.printStackTrace();
			}
		}
		return hotDrinksList;
}

@Override
public List<BevOrder> listBevOrder() {
	 ArrayList<BevOrder> bevOrderList = new ArrayList<BevOrder>();
		Connection conn=null;
		Statement stmt=null;
		BevOrder bevOrder=null;
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connecting to the DB");
			stmt=conn.createStatement();
			String sql="select * from bev_order";
			ResultSet mainList = stmt.executeQuery(sql);
			while(mainList.next()){
				bevOrder = new BevOrder();
				bevOrder.setOrderId(mainList.getInt("order_id"));
				bevOrder.setBevId(mainList.getInt("bev_id"));
				bevOrder.setItem_name(mainList.getString("item_name"));
				bevOrder.setStatus(mainList.getString("status"));
				bevOrderList.add(bevOrder);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
			}catch(SQLException sqe){
				sqe.printStackTrace();
			}
			try{
				if(conn !=null){
					conn.close();
				}
			}catch(SQLException sqlex1){
				sqlex1.printStackTrace();
			}
		}
		return bevOrderList;
}


@Override
public List<Snacks> listSnacks() {
	ArrayList<Snacks> snacksList = new ArrayList<Snacks>();
	Connection conn=null;
	Statement stmt=null;
	Snacks snacks=null;
	try{
	
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connecting to the DB");
		stmt=conn.createStatement();
		String sql="select * from snacks";
		ResultSet mainList = stmt.executeQuery(sql);
		while(mainList.next()){
			snacks = new Snacks();
			snacks.setId(mainList.getInt("ID"));
			snacks.setItem_name(mainList.getString("ITEM_NAME"));
			snacks.setPrice(mainList.getString("PRICE"));
			snacks.setTax(mainList.getString("TAX"));
			snacks.setTotal(mainList.getString("TOTAL"));
			snacksList.add(snacks);
		}
		
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(stmt!=null){
				stmt.close();
			}
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		try{
			if(conn !=null){
				conn.close();
			}
		}catch(SQLException sqlex1){
			sqlex1.printStackTrace();
		}
	}
	return snacksList;
}

@Override
public void placeBevOrder(Beverage bev) throws SQLException {
	Connection conn=null;
	int i=0;
//	Statement stmt=null;
//	Beverage beverage=null;
	PreparedStatement pstmt=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connecting to the DB");
		String sql;
		sql="insert into bev_order(bev_id,item_name,status) values(?,?,?)";
		pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//ResultSet tableKeys = pstmt.getGeneratedKeys();
		        //tableKeys.next();
		//pstmt.setInt(1, autoGeneratedID);
		pstmt.setInt(1, bev.getId());
		pstmt.setString(2, bev.getItem_name());
		pstmt.setString(3, "Y");
		i=pstmt.executeUpdate();
		//ResultSet tableKeys = pstmt.getGeneratedKeys();
		ResultSet resultSet= pstmt.getGeneratedKeys();
		int autoGeneratedID = 0;
		while (resultSet.next()){
		autoGeneratedID=resultSet.getInt("GENERATED_KEY");
		}
		System.out.println("Inserted Record"+autoGeneratedID);
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(pstmt!=null){
				pstmt.close();
			}
		}catch(SQLException sqe){
			sqe.printStackTrace();
		}
		try{
			if(conn !=null){
				conn.close();
			}
		}catch(SQLException sqlex1){
			sqlex1.printStackTrace();
		}
	}
	
	}
}
