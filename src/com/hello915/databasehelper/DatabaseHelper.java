package com.hello915.databasehelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Siwutian
 * 2014.06.25
 */
public class DatabaseHelper {
    // MySQL:"jdbc:mysql://localhost/cdut";
	private String conString;
	private String user;
	private String pwd;
	private static DatabaseHelper dbHelper;
	private static Connection connection;
	
	public static DatabaseHelper getInstance(String conString,String user,String pwd){
		if(dbHelper == null){
			dbHelper = new DatabaseHelper(conString,user,pwd);
		}
		return dbHelper;
	}
	
	public static DatabaseHelper getInstance(){
		if(dbHelper == null){
			dbHelper = new DatabaseHelper("jdbc:postgresql://localhost:5432/changhong_db","postgres","8625809");
		}
		return dbHelper;
	}
	
	private DatabaseHelper(String conString,String user,String pwd){
		this.conString = conString;
		this.user = user;
		this.pwd = pwd;
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(conString,user, pwd);
	}
	
	public ResultSet getResultSet(String sqlString) throws SQLException{
		connection = getConnection();
		Statement sm = connection.createStatement();
		ResultSet rs = sm.executeQuery(sqlString);
		connection.close();
		return rs;
	}
	
	public Boolean execute(String sqlString) throws SQLException{
		connection = getConnection();
		Statement sm = connection.createStatement();
		Boolean isDone = sm.execute(sqlString);
		sm.close();
		connection.close();
		return isDone;
	}
	
	/**
	 * 测试代码
	 * @param args
	 */
	public static void main(String[] args) {
//		String insertStr = String.format("INSERT INTO app_user(app_username,app_userid,"+
//		"user_portrait,password,user_deviceid,token,cookie) VALUES('%s',%s,'%s','%s','%s','%s','%s')", 
//		"张伟","1005","portrait","123456","deviceId","token","cookie");
//		String insertStr2 = String.format("INSERT INTO relationship(user1,user2,oid) VALUES(%s,%s,'%s')", 1001,1005,10);
//		String insertStr = String.format("INSERT INTO app_user(username,userid,"+
//				"portrait,password,deviceid,token,cookie) VALUES('%s',%s,'%s','%s','%s','%s','%s')", 
//				"张兴龙","19201","http://xxx","123456","deviceId","token","cookie");
		String deleteStr = "DELETE FROM app_user WHERE userid < 999999;";
		try {

			DatabaseHelper pg = DatabaseHelper.getInstance();
			pg.execute(deleteStr);
			ResultSet rs = pg.getResultSet("select * from app_user;");
			System.out.print("PostgreSQL:\n");
			while(rs.next()){
				System.out.println("userName:"+rs.getString("userName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
