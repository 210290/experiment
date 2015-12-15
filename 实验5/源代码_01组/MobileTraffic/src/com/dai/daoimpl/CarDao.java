package com.dai.daoimpl;

import java.sql.ResultSet;

import com.dai.dao.ICarDao;
import com.dai.db.DataBase;

public class CarDao implements ICarDao{
	//车辆信息查询
	public ResultSet searchCarInfo(String search,String location, boolean k) {
		String sql = null;
		DataBase db = DataBase.getDataBase();
		ResultSet rs = null;
		search = "%"+search+"%";
		location = "%"+location+"%";
		//按车牌号查询
		if (k) {
			sql = "select * from bi_vehicle where braprefix like ? and branum like ? ";
			rs= db.executeQueryRS(sql, new String[] { location,search });
		} else {//按车辆特征查询
			sql = "select * from bi_vehicle where bracolor like ? or vectype like ?";
			rs= db.executeQueryRS(sql, new String[] { search,search });
		}		 
		return rs;
	}

}
