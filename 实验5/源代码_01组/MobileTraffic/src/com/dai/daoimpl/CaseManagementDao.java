package com.dai.daoimpl;

import java.sql.ResultSet;

import com.dai.dao.ICaseManageDao;
import com.dai.db.DataBase;

public class CaseManagementDao implements ICaseManageDao{
	ResultSet rs = null;
	String sql = null;
	DataBase db = DataBase.getDataBase();
	
	public ResultSet caseList() {		
		sql = "select * from cp_casinfo where status='0'order by credate desc";	
		rs = db.executeQueryRS(sql, null);
		return rs;
	}
	public ResultSet xiangxi(String casid) {
		sql="select * from cp_casinfo where status='0'and casid=? order by credate desc";
		rs = db.executeQueryRS(sql, new String[]{casid});
		return rs;
	}

}
