package com.hello915.javaweb.javabeans;

public class User {
	private String username;
	private String userid;
	private String password;
	private String token;
	private String deviceid;
	private String portrait;
	
	public User(String name,String id,String pwd,String token,String dev,String port){
		this.userid = id;
		this.username = name;
		this.password = pwd;
		this.deviceid = dev;
		this.token = token;
		this.portrait = port;
	}
	public void setUserName(String userName){
		this.username = userName;
	}
	
	public String getUserName(){
		return this.username;
	}
	
	public void setUserId(String userId){
		this.userid = userId;
	}
	
	public String getUserId(){
		return this.userid;
	}
	
	public void setPassword(String pwd){
		this.password = pwd;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setDeviceId(String deviceId){
		this.deviceid = deviceId;
	}
	
	public String getDeviceId(){
		return this.deviceid;
	}
	
	public void setPortrait(String portrait){
		this.portrait = portrait;
	}
	
	public String getPortrait(){
		return this.portrait;
	}
	
	public void setToken(String token){
		this.token = token;
	}
	
	public String getToken(){
		return this.token;
	}
	
}
