package com.dai.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dai.dao.ICaseRegisterDao;
import com.dai.db.DataBase;

public class CaseRegisterDao implements ICaseRegisterDao {

	public int CaseRegister(String[] strings, String cphz, String cphm,
			String username) {
		Date date = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat(
				"yyyy/MM/dd");// 输出的日期格式
		SimpleDateFormat timeFormate = new SimpleDateFormat("HH:mm:ss");// 输出的时间格式
		String date1 = dateFormate.format(date);
		String time = timeFormate.format(date);
		String sql = null;
		DataBase db = DataBase.getDataBase();
		String sql1 = "select cmvecid from bi_vehicle where braprefix=? and branum= ?";
		ResultSet resultSet = db.executeQueryRS(sql1,
				new String[] { cphz, cphm });
		String cmvecid=null;
		try {
			while (resultSet.next()) {
				cmvecid = resultSet.getString("cmvecid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "select d.unitid,c.pfcmz,b.depcode,d.teamid,d.man_id,d.man_name from t_pf_userdep a,t_pf_dep b,t_pf_user c,qc_man d where c.usercode = a.usercode and a.depid = b.depid and  c.usercode = d.usercode and c.usercode=?";
		resultSet = db.executeQueryRS(sql, new String[] { username });
		String unitid = null;
		String pfcmz=null;
		String depcode=null;
		String teamid=null;
		String man_id=null;
		String man_name=null;
		try {
			while (resultSet.next()) {
				unitid = resultSet.getString("unitid");
				pfcmz = resultSet.getString("pfcmz");
				depcode = resultSet.getString("depcode");
				teamid = resultSet.getString("teamid");
				man_id = resultSet.getString("man_id");
				man_name = resultSet.getString("man_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] strings2 = { strings[0], unitid, pfcmz ,depcode,strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],cmvecid,"",teamid,man_id,man_name,username,date1,time};

		sql = "insert into cp_casinfo(casflowtype,unitid,type_id,depcode,cheobject,pecdate,pectime,prcsite,psnphone,psnctctype,pssnctcno,cmvecid,detainno,teamid1,lawepid,lawepsn,status,creusrcode,credate,cretime)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,?,?)";
		int refluence = db.executeUpdate(sql, strings2);

		return refluence;

	}

}
