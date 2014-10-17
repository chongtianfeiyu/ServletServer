package com.hello915.javaweb.rongyun;

import java.sql.SQLException;

import com.hello915.databasehelper.DatabaseHelper;
import com.hello915.javaweb.javabeans.UserToken;
import com.hello915.javaweb.util.JSONHelper;

public class RongyunAPI {

	private String appKey = "8luwapkvuxazl";
	private String appSecret = "hgKLk3Refgt59P";
	private DatabaseHelper dbHelper;
	
	public String register(String name,String id,String pwd,String portrait){
		// 先访问融云服务器，获取Token，然后插入到数据库中,最后将Token和用户名及密码返回（用户ID应该有服务器分配）
		String token = "default";
		try {
			String userToken = RongAuthClient.auth(appKey,appSecret,id,name,portrait);
			UserToken uToken = (UserToken) JSONHelper.fromJson(userToken, UserToken.class);
			token = uToken.getToken();
		} catch (RongAuthException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return token;
	}
	
	public String login(String userName,String pwd){
		return null;
	}
}
