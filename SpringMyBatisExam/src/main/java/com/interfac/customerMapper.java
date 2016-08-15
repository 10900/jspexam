package com.interfac;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bean.customer;

public interface customerMapper {
	
	@Insert("insert into customer(store_id,first_name,last_name,email,address_id,create_date)"
			+ "values(1,#{first_name},#{last_name},#{email},#{address_id},#{create_date})")
	public int addCus(customer c);
	
	public int deleteCus(int id);
	
	public int updateCus(int id);
	
	@Select("select first_name,last_name,email,address_id,create_date "
			+ "from customer where first_name = #{first_name} and last_name = #{last_name}")
	public customer getCus(String first_name,String last_name);
	
	public List<customer>getAll();

}
