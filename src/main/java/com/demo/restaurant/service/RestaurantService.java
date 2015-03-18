package com.demo.restaurant.service;

import java.util.List;

import com.demo.restaurant.model.BevOrder;
import com.demo.restaurant.model.Beverage;
import com.demo.restaurant.model.HotDrinks;
import com.demo.restaurant.model.MainCourse;
import com.demo.restaurant.model.Order;
import com.demo.restaurant.model.Snacks;

public interface RestaurantService {

	List<Beverage> listBeverageList();
	List<MainCourse> listMainCourse();
	List<HotDrinks> listHotDrinks();
	List<Snacks> listSnacks();
	public void placeBevOrder(Beverage bev);
	List<BevOrder> listBevOrder();
	
}
