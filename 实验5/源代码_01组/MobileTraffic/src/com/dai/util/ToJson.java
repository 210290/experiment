package com.dai.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ToJson {
	static public JSONArray resultJSON(ResultSet rs){
		JSONArray json = new JSONArray();
		if (rs != null) {
			try {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int columnCount = resultSetMetaData.getColumnCount();
				while (rs.next()) {
					JSONObject jsonObject = new JSONObject();
					for (int i = 1; i <= columnCount; i++) {
						jsonObject.put(resultSetMetaData.getColumnName(i),
								rs.getObject(i));
					}
					json.add(jsonObject);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return json;
	}

}
