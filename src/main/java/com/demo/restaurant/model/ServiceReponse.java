package com.demo.restaurant.model;

import java.util.HashMap;
import java.util.List;

//import org.json.JSONObject;

public class ServiceReponse {
	private ResponseStatus status;
//	private JSONObject data;
	private List<HashMap> datas;
	
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
//	public JSONObject getData() {
//		return data;
//	}
//	public void setData(JSONObject data) {
//		this.data = data;
//	}
	public List<HashMap> getDatas() {
		return datas;
	}
	public void setDatas(List<HashMap> datas) {
		this.datas = datas;
	}
	

}
