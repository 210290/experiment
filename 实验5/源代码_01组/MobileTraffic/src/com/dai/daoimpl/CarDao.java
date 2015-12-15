package com.dai.daoimpl;

import java.sql.ResultSet;

import com.dai.dao.ICarDao;
import com.dai.db.DataBase;

public class CarDao implements ICarDao{
	//������Ϣ��ѯ
	public ResultSet searchCarInfo(String search,String location, boolean k) {
		String sql = null;
		DataBase db = DataBase.getDataBase();
		ResultSet rs = null;
		search = "%"+search+"%";
		location = "%"+location+"%";
		//�����ƺŲ�ѯ
		if (k) {
			sql = "select * from bi_vehicle where braprefix like ? and branum like ? ";
			rs= db.executeQueryRS(sql, new String[] { location,search });
		} else {//������������ѯ
			sql = "select * from bi_vehicle where bracolor like ? or vectype like ?";
			rs= db.executeQueryRS(sql, new String[] { search,search });
		}		 
		return rs;
	}

}
