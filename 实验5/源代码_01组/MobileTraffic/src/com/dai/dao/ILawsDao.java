package com.dai.dao;


import java.sql.ResultSet;


public interface ILawsDao {
	public ResultSet searchLaws(String search, boolean k);

}
