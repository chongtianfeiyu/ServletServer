package com.hello915.javaweb.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello915.databasehelper.DatabaseHelper;
import com.hello915.javaweb.javabeans.User;
import com.hello915.javaweb.rongyun.RongyunAPI;
import com.hello915.javaweb.util.JSONHelper;

public class Controller {
	
    private RongyunAPI rongyun = new RongyunAPI();
	private DatabaseHelper dbHelper = DatabaseHelper.getInstance();
	
	public void Redict(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String flag = request.getParameter("flag");
		switch(flag){
		case "LOGIN":
			break;
		case "REGISTER":
			Register(request,response);
			break;
		default:
			break;
		}
	}

	private void Register(HttpServletRequest request, HttpServletResponse response) throws IOException{

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String portrait = request.getParameter("portrait");
		String token = rongyun.register(name, id, pwd, portrait);
		
		if(token.equals("default")){
			System.out.println("Return no token!");
			return;
		}
		
		String insertStr = String.format("INSERT INTO app_user(username,userid,"+
				"portrait,password,deviceid,token) VALUES('%s','%s','%s','%s','%s','%s');", 
					name,id,portrait,pwd,"硬件地址",token);
		PrintWriter out = response.getWriter();
		try {
			dbHelper.execute(insertStr); // 应该先检查主码是否唯一
			User user = new User(name,id,pwd,token,"deviceid",portrait);
			out.println(JSONHelper.toJson(user));
		} catch (SQLException e) {
			e.printStackTrace();
			out.println(e.getMessage());
		}
	}
	
}
