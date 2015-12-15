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

import com.dai.dao.ICaseRegisterDao;
import com.dai.daoimpl.CaseRegisterDao;
import com.dai.factory.DaoFactory;

public class CaseRegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CaseRegisterServlet() {
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
		// 获取参数
		String ajlczl = request.getParameter("ajlczl");
		// String zfdw = request.getParameter("zfdw");
		// String zfml = request.getParameter("zfml");
		// String jgdm = request.getParameter("jgdm");
		String wzztlb = request.getParameter("wzztlb");
		// String ahz = request.getParameter("ahz");
		// String ahhm = request.getParameter("ahhm");
		String wzrq = request.getParameter("wzrq");
		String wzsj = request.getParameter("wzsj");
		String wzdd = request.getParameter("wzdd");
		String dsrlxdh = request.getParameter("dsrlxdh");
		String dsrzjlx = request.getParameter("dsrzjlx");
		String dsrzjhm = request.getParameter("dsrzjhm");
		String cphz = request.getParameter("cphz");
		String cphm = request.getParameter("cphm");
		// String clid = request.getParameter("clid");
		// String zkdh = request.getParameter("zkdh");
		// String zfdid = request.getParameter("zfdid");
		// String zfryid = request.getParameter("zfryid");
		// String zfry = request.getParameter("zfry");
		// String zfzh = request.getParameter("zfzh");
		// String ajzt = request.getParameter("ajzt");
		// String cjzbh = request.getParameter("cjzbh");
		// String cjrq = request.getParameter("cjrq");
		// String cjsj = request.getParameter("cjsj");

		// String[] insertInfo = { ajlczl,zfdw, zfml, jgdm, wzztlb, ahz, ahhm,
		// wzrq, wzsj,
		// wzdd, dsrlxdh, dsrzjlx, dsrzjhm, clid, zkdh, zfdid, zfryid,
		// zfry, zfzh, ajzt, cjzbh, cjrq, cjsj };
		String[] insertInfo = { ajlczl, wzztlb, wzrq, wzsj, wzdd, dsrlxdh,
				dsrzjlx, dsrzjhm };

		ICaseRegisterDao dao = DaoFactory.createCaseRegisterDao();
		int refluence = dao.CaseRegister(insertInfo, cphz, cphm, request
				.getSession().getAttribute("username").toString());

		// 应答
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(refluence);
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
