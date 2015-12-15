package com.dai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dai.dao.ICarDao;
import com.dai.dao.IUserDao;
import com.dai.daoimpl.CarDao;
import com.dai.factory.DaoFactory;
import com.dai.util.ToJson;

public class CarServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CarServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 读取参数
		String search = request.getParameter("search");//搜索内容
		//System.out.println(search);
		String location = request.getParameter("carLocation");//车牌号字
		//System.out.println(location);
		String carsearch = request.getParameter("carsearch");//查询方式
		//System.out.println(carsearch);
		
		boolean k = false;// 判断查询方式
		if (carsearch.equals("number")) {
			k = true;// 按车牌号查询
		} else {
			k = false;// 按车辆特征查询
			location=null;
		}
		// 访问数据库
		ICarDao dao = DaoFactory.createCarDao();
		JSONArray json = new JSONArray();
		ResultSet rs = dao.searchCarInfo(search, location, k);
		//System.out.println(rs);
		json = ToJson.resultJSON(rs);
		//System.out.println(json);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
