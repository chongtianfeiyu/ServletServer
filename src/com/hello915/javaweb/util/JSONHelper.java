package com.hello915.javaweb.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hello915.javaweb.javabeans.UserToken;

public class JSONHelper {
	
	private static Gson gson = new Gson();
	
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}
	
	public static Object fromJson(String jsonStr,Class<?> yourClass){
		return gson.fromJson(jsonStr,yourClass);
	}
	
	// 将对象集合转换为json字符串
	public static String toJsons(List<?> list){
		return gson.toJson(list);	
	}
	
	// 将json字符串转换为对象集合
	public static List<?> fromJson(String jsonString){
		return gson.fromJson(jsonString, new TypeToken<List<?>>(){}.getType());
	}
	
	public static void main(String[] args){
		UserToken ut= new UserToken();
		ut.setCode(200);
		ut.setToken("aldjfaldjfladofquweorquweorqwueioruqwoeruqwoieuro");
		ut.setUserId("18280098505");
		String js = JSONHelper.toJson(ut);
		System.out.println(js);
		UserToken utt = (UserToken) JSONHelper.fromJson(js, UserToken.class);
		System.out.println(utt.getCode());
	}
	
	
	
}
