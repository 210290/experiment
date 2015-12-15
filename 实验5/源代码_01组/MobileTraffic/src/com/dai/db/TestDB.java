package com.dai.db;

public class TestDB {
	public static void main(String[] args) {
		DataBase db = DataBase.getDataBase();
		String sql="select * from t_pf_user";
    	System.out.println(db.excuteQuery(sql, null));
		System.out.println(db.executeQueryRS(sql, null));
		System.out.println(db.executeQuerySingle(sql, null));
		System.out.println(db.executeUpdate(sql, null));
		//System.out.println(db.connnection);
		
		
	}

}
