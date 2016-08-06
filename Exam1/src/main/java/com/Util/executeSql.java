package com.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.film;


public class executeSql {
	
	public boolean check(String name){
		connection con = new connection();
		boolean rs= false;
		String sql = "select * from customer where first_name ='"+name+"' ";
		try {
			
			Statement sta = con.getConnection().createStatement();
			rs = sta.execute(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
		
	}
	
	public film[] getFilmMess(){
		String sql = "select * from film";
		film f = new film();
		connection con  = new connection();
		try {
			Statement sta = con.getConnection().createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while(rs.next()) {
				f.setFilm_id(rs.getInt("film_id"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				f.setLanguage_id(rs.getInt("language_id"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
