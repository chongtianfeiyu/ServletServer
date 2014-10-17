package com.hello915.javaweb.javabeans;

public class UserToken {
	//{"code":200,"userId":"18280098503","token":"eMjiZe5WjlOt3pqxU5YIrPeRPXh+XPrHap2+1iyzkjJpRDSFL+7nLU3Kn8YMcZ2lenNINf0fH2bNTNAo+4W9F55EsqyOwYa4"}
	private int code;
	private String userId;
	private String token;
	
	public void setCode(int code){
		this.code = code;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	
	public String getToken(){
		return this.token;
	}
	
}
