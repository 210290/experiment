package com.dai.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dai.dao.IUserDao;
import com.dai.db.DataBase;
import com.dai.entity.UserInfo;

public class UserDao implements IUserDao{
	public boolean check(UserInfo user){
		String sql="select count(*) from t_pf_user a where a.usercode =? and a.passwrd =?";
		DataBase db = DataBase.getDataBase();
		ResultSet rs = db.executeQueryRS(sql, new String[]{user.getUsername(),user.getPassword()});
		try {
			if(rs!=null && rs.next()){
				int count=rs.getInt(1);
				rs.close();
				db.closeAll();
				return count>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
