package com.demo.restaurant.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.restaurant.model.BevOrder;
import com.demo.restaurant.model.Beverage;
import com.demo.restaurant.model.HotDrinks;
import com.demo.restaurant.model.MainCourse;
import com.demo.restaurant.model.Order;
import com.demo.restaurant.model.ServiceReponse;
import com.demo.restaurant.model.Snacks;
import com.demo.restaurant.service.RestaurantService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller("restaurant")
@RequestMapping(value="/restaurantCtrlr")
public class RestaurantController {
	
	@Resource(name="service")
	private RestaurantService service;
	
	/**
	 * Return list of Beverage Items
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/beverage")
	@ResponseBody
	public void fetchBeverage(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("m here");
		List<Beverage> bevItems = null;
	//	ServiceReponse response = new ServiceReponse();
		try{
			bevItems=service.listBeverageList();
			System.out.println("size:::"+bevItems.size());
			Gson gson = new Gson();
			  JsonElement element = gson.toJsonTree(bevItems, new TypeToken<List<Beverage>>() {}.getType());
			  JsonArray jsonArray = element.getAsJsonArray();
			  resp.setContentType("application/json");
			  resp.getWriter().print(jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	//	return bevItems;
	}
	
	/**
	 * Return list of MainCourse Items
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/maincourse")
	public void fetchMainCourse(HttpServletRequest req, HttpServletResponse resp){
		List<MainCourse> mainCourseItems = null;
		try{
			mainCourseItems=service.listMainCourse();
			System.out.println("main course list:::"+mainCourseItems.size());
			Gson gson = new Gson();
			  JsonElement element = gson.toJsonTree(mainCourseItems, new TypeToken<List<MainCourse>>() {}.getType());
			  JsonArray jsonArray = element.getAsJsonArray();
			  resp.setContentType("application/json");
			  resp.getWriter().print(jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	//	return mainCourseItems;
	}
	
	/**
	 * Return list of Snacks Items
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/snacks")
	public List<Snacks> fetchSnacks(HttpServletRequest req, HttpServletResponse resp){
		List<Snacks> snacksItems = null;
		try{
			snacksItems=service.listSnacks();
			Gson gson = new Gson();
			  JsonElement element = gson.toJsonTree(snacksItems, new TypeToken<List<Snacks>>() {}.getType());
			  JsonArray jsonArray = element.getAsJsonArray();
			  resp.setContentType("application/json");
			  resp.getWriter().print(jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return snacksItems;
	}
	
	/**
	 * Return list of Snacks Items
	 * @param req
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/hotdrinks")
	public void fetchHotDrinks(HttpServletRequest req, HttpServletResponse resp){
		List<HotDrinks> hotDrinks = null;
		try{
			hotDrinks=service.listHotDrinks();
			System.out.println("size of hot drinks::"+hotDrinks.size());
			Gson gson = new Gson();
			  JsonElement element = gson.toJsonTree(hotDrinks, new TypeToken<List<HotDrinks>>() {}.getType());
			  JsonArray jsonArray = element.getAsJsonArray();
			  resp.setContentType("application/json");
			  resp.getWriter().print(jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	//	return hotDrinks;
	}

	@RequestMapping(method = RequestMethod.POST, value="/bevOrder")
	public void placeBevOrder(HttpServletRequest req, HttpServletResponse resp,Beverage bev){
		System.out.println(" in inside place order method");
	//	bev.setId(id);
		System.out.println("Printing ID::"+req.getParameter("beverages"));
		bev.setItem_name(req.getParameter("beverages"));
	//	System.out.println("Printing ITEM_NAME:::"+req.getParameter("item_name"));
		service.placeBevOrder(bev);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/bevorderstatus")
	public void bevOrderStatus(HttpServletRequest req, HttpServletResponse resp){
		List<BevOrder> bevOrderList = null;
		try{
			bevOrderList=service.listBevOrder();
			System.out.println("size of hot drinks::"+bevOrderList.size());
			Gson gson = new Gson();
			  JsonElement element = gson.toJsonTree(bevOrderList, new TypeToken<List<BevOrder>>() {}.getType());
			  JsonArray jsonArray = element.getAsJsonArray();
			  resp.setContentType("application/json");
			  resp.getWriter().print(jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public RestaurantService getService() {
		return service;
	}

	public void setService(RestaurantService service) {
		this.service = service;
	}
	
}

