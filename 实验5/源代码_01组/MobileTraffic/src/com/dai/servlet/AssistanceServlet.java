package com.dai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;



import com.dai.dao.IAssistanceDao;
import com.dai.factory.DaoFactory;
import com.dai.util.ToJson;

public class AssistanceServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AssistanceServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IAssistanceDao dao = DaoFactory.createAssistanceDao();
		ResultSet rs=null;
		JSONArray json = new JSONArray();
		//获取参数
		String show = request.getParameter("show");
		int k=Integer.parseInt(show);
		switch (k) {
		case 0:
			rs = dao.assistanceList();			
			break;
		case 1:
			String cphz = request.getParameter("cphz");
			String cphm = request.getParameter("cphm");
			String cpys = request.getParameter("cpys");
			String cllx = request.getParameter("cllx");
			String clpp = request.getParameter("clpp");
			rs = dao.assistanceSearchs(cphz,cphm,cpys,cllx,clpp);			
			break;
		default:
			break;
		}
			
		json = ToJson.resultJSON(rs);		
		//System.out.println(rs);		
		//应答
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//System.out.println(json.toString());
		out.print(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
