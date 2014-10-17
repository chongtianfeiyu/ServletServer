package com.hello915.javaweb.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello915.javaweb.model.Controller;
import com.hello915.javaweb.rongyun.RongyunAPI;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/MyUniqueServlet")
public class MyUniqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RongyunAPI rongyun = new RongyunAPI();
    private Controller control = new Controller();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyUniqueServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String portrait = request.getParameter("portrait");
		String returnStr = null;
		System.out.println(name);
		switch(flag){
		case "LOGIN":
			break;
		case "REGISTER":
			returnStr = rongyun.register(name, id, pwd, portrait);
			break;
		default:
			break;
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		out.println("<root><books><book><bookname>book1" + flag + "/" + 
		name + "/" + id +"/" + pwd + "/" + portrait + "/" + returnStr +
		"</bookname></book></books></root>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		control.Redict(request, response);
	}

}
