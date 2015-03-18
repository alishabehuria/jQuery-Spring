package com.demo.restaurant.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.restaurant.model.BevOrder;
import com.demo.restaurant.model.Beverage;
import com.demo.restaurant.model.HotDrinks;
import com.demo.restaurant.model.MainCourse;
import com.demo.restaurant.model.Order;
import com.demo.restaurant.model.Snacks;

public interface RestaurantDAO {

	List<Beverage> fetchBeverage() throws SQLException;
	List<MainCourse> listMainCourse() throws SQLException;
	List<HotDrinks> listHotDrinks() throws SQLException;
	List<Snacks> listSnacks() throws SQLException;
	void placeBevOrder(Beverage bev) throws SQLException;
	List<BevOrder> listBevOrder() throws SQLException;
}
