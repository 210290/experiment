package com.dai.dao;


import java.sql.ResultSet;


public interface IAssistanceDao {
	public ResultSet assistanceList();
	public ResultSet assistanceSearchs(String cpzh,String cphm,String cpys,String cllx,String clpp);

}
