package com.dai.daoimpl;

import java.sql.ResultSet;

import com.dai.dao.IAssistanceDao;
import com.dai.db.DataBase;

public class AssistanceDao implements IAssistanceDao{
	//倒序列出有效协查通报
	public ResultSet assistanceList() {
		String sql = "select * from t_cle_concertaviso a,t_cle_concertreason b where a.xcyy=b.xcyy_id and a.sfla=1 order by a.sxrq desc";
		DataBase db = DataBase.getDataBase();
		ResultSet rs = db.executeQueryRS(sql, null);
		return rs;
	}
	//关键字匹配查询
	public ResultSet assistanceSearchs(String cpzh,String cphm,String cpys,String cllx,String clpp) {
		String sql = "select * from t_cle_concertaviso a,t_cle_concertreason b where a.xcyy=b.xcyy_id and a.sfla=1 and a.cphz like ?  and a.cphm like ? and a.cpys like ? and a.cllx like ? and a.cltz like ? order by a.sxrq desc";
		cpzh="%"+cpzh+"%";
		cphm="%"+cphm+"%";
		cpys="%"+cpys+"%";
		cllx="%"+cllx+"%";
		clpp="%"+clpp+"%";
		DataBase db =DataBase.getDataBase();
		ResultSet rs = db.executeQueryRS(sql, new String[]{cpzh,cphm,cpys,cllx,clpp});
		return rs;
	}

}
