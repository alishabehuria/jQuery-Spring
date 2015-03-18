package com.demo.restaurant.model;


public enum ResponseStatus {
	SUCCESS("Success"), FAIL("failure");
	private String name;
	
	private ResponseStatus(String name){
		this.name=name;
	}
	public String toString(){
		return name;
	}
	
	public static ResponseStatus convertHttStatus(int httpCode){
		if(httpCode == 200){
			return SUCCESS;
		}
		else{
			return FAIL;
		}
	}
	
	public static ResponseStatus get(String name){
		for(ResponseStatus status: ResponseStatus.values()){
			if(status.toString().equals(name)){
				return status;
			}
		}
		return null;
	}

}
