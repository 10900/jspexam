package com.hand;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.customer;
import com.interfac.customerMapper;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please input first_name:");
		System.out.println("Please input last_name:");
		System.out.println("Please input email:");
		System.out.println("Please input address_id:");
		Scanner in = new Scanner(System.in);
		String fname = in.nextLine();
		String lname = in.nextLine();
		String email = in.nextLine();
		int addressid = in.nextInt();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");  
		String cDate = df.format(new Date());
		Date date = null ;
		try {
				date = (Date) df.parse(cDate);
			} catch (ParseException e) {
				System.out.println(11111);
				e.printStackTrace();
			}
		customer c = new customer(1,fname,lname,email,addressid,date);
		//c.toString();
		String r = "ApplicationContext.xml";
		Reader reader;
		SqlSessionFactory fac;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(r);
			fac = new SqlSessionFactoryBuilder().build(reader);
			session = fac.openSession(false);
			customerMapper map = session.getMapper(customerMapper.class);
			map.addCus(c);
			c.toString();
			//System.out.println(map.getCus(601));
			//session.commit();
		} catch (IOException e) {
			System.out.println("-----------------------");
			session.rollback();
			System.out.println("=======================");

			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

}
