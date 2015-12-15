package com.dai.factory;

import com.dai.dao.IAssistanceDao;
import com.dai.dao.ICarDao;
import com.dai.dao.ICaseManageDao;
import com.dai.dao.ICaseRegisterDao;
import com.dai.dao.ILawsDao;
import com.dai.dao.IUserDao;

public class DaoFactory {
	public static IUserDao createUserDao() {
		String daoString = "com.dai.daoimpl.UserDao";
		try {
			IUserDao dao = (IUserDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static ILawsDao createLawsDao() {
		String daoString = "com.dai.daoimpl.LawsDao";
		try {
			ILawsDao dao = (ILawsDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ICarDao createCarDao() {
		String daoString = "com.dai.daoimpl.CarDao";
		
		try {
			ICarDao dao = (ICarDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static IAssistanceDao createAssistanceDao() {
		String daoString = "com.dai.daoimpl.AssistanceDao";
		try {
			IAssistanceDao dao = (IAssistanceDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ICaseManageDao createCaseManageDao() {
		String daoString = "com.dai.daoimpl.CaseManagementDao";
		try {
			ICaseManageDao dao = (ICaseManageDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ICaseRegisterDao createCaseRegisterDao() {
		String daoString = "com.dai.daoimpl.CaseRegisterDao";
		try {
			ICaseRegisterDao dao = (ICaseRegisterDao)Class.forName(daoString).newInstance();
			return dao;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
