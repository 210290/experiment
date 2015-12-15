package com.dai.dao;


import java.sql.ResultSet;


public interface ICaseManageDao {
	public ResultSet caseList();
	public ResultSet xiangxi(String casid);


}
