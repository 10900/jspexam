package com.hand;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.interfac.customerMapper;

public class Utils {
	
	public customerMapper getMap(){
		String r = "ApplicationContext.xml";
		customerMapper map = null;
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(r);
			SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = fac.openSession(true);
			map = session.getMapper(customerMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

}
