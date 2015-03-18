package com.demo.restaurant.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.restaurant.dao.RestaurantDAO;
import com.demo.restaurant.model.BevOrder;
import com.demo.restaurant.model.Beverage;
import com.demo.restaurant.model.HotDrinks;
import com.demo.restaurant.model.MainCourse;
import com.demo.restaurant.model.Order;
import com.demo.restaurant.model.Snacks;

public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDAO dao;
	public RestaurantDAO getDao() {
		return dao;
	}
	public void setDao(RestaurantDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<Beverage> listBeverageList() {
		// TODO Auto-generated method stub
		List<Beverage> list= new ArrayList<Beverage>();
		try {
			list= dao.fetchBeverage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * Return Main course List
	 */
	@Override
	public List<MainCourse> listMainCourse() {
		List<MainCourse> mainList= new ArrayList<MainCourse>();
		try{
			mainList=dao.listMainCourse();
			System.out.println("list size in service:::"+mainList);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainList;
	}
	/**
	 * Return Hot Drinks List
	 */
	@Override
	public List<HotDrinks> listHotDrinks() {
		List<HotDrinks> drinkList= new ArrayList<HotDrinks>();
		
		try{
			drinkList=dao.listHotDrinks();
			System.out.println("list size in service:::"+drinkList);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drinkList;
	}
	/**
	 * Return snacks list
	 */
	@Override
	public List<BevOrder> listBevOrder() {
		List<BevOrder> bevOrderList= new ArrayList<BevOrder>();
		
		try{
			bevOrderList=dao.listBevOrder();
			System.out.println("list size in service:::"+bevOrderList);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bevOrderList;
	}
	@Override
	public List<Snacks> listSnacks() {
		List<Snacks> snacksList= new ArrayList<Snacks>();
		
		try{
			snacksList=dao.listSnacks();
			System.out.println("list size in service:::"+snacksList);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return snacksList;
	}
	
	@Override
	public void placeBevOrder(Beverage bev){
		try{
		//	bev.setItem_name(bev.getItem_name());
			dao.placeBevOrder(bev);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
