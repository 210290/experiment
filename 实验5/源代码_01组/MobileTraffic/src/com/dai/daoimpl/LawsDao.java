package com.dai.daoimpl;

import java.sql.ResultSet;

import com.dai.dao.ILawsDao;
import com.dai.db.DataBase;

public class LawsDao implements ILawsDao{
	//政策法规查询
	public ResultSet searchLaws(String search, boolean k) {
		String sql = null;
		ResultSet rs=null;
		DataBase db = DataBase.getDataBase();
		search = "%"+search+"%";
		
		if (k) {//按颁发部门关键字查询
			sql = "select A.law_name,B.level1,B.level2,B.level3,B.content from cb_law A,cb_lawitem B where A.law_id=B.law_id and A.depart like ? ";
			rs= db.executeQueryRS(sql, new String[] { search });
		} else {//按内容或法规名称关键字查询
			sql = "select A.law_name,B.level1,B.level2,B.level3,B.content from cb_law A,cb_lawitem B where A.law_id=B.law_id and B.content like ? or A.law_name like ?";			
			rs= db.executeQueryRS(sql, new String[] { search,search });
		}	
		return rs;
	}
}
