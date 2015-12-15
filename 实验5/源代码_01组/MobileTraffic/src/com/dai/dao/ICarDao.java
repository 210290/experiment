package com.dai.dao;


import java.sql.ResultSet;


public interface ICarDao {
	public ResultSet searchCarInfo(String search,String location, boolean k);

}
