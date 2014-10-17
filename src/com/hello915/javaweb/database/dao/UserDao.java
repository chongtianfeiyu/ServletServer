package com.hello915.javaweb.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hello915.databasehelper.DatabaseHelper;
import com.hello915.javaweb.javabeans.User;

public class UserDao {
	
	DatabaseHelper dbHelper = DatabaseHelper.getInstance();
	
	public User select(String id){
		User user = null;
		String sql = String.format("SELECT * FROM app_user WHERE userid='%s';",id);
		try {
			ResultSet r = dbHelper.getResultSet(sql);
			if(r.next()){
				user = new User(r.getString("username"),r.getString("userid"),
						r.getString("password"),r.getString("token"),r.getString("deviceid"),r.getString("portrait"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Boolean insert(User user){
		Boolean isDone = false;
		String insertStr = String.format("INSERT INTO app_user(username,userid,"+
				"portrait,password,deviceid,token,cookie) VALUES('%s',%s,'%s','%s','%s','%s')", 
				user.getUserName(),user.getUserId(),user.getPortrait(),
				user.getPassword(),user.getDeviceId(),user.getToken());
		try {
			dbHelper.execute(insertStr);
			isDone = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDone;
	}
}
