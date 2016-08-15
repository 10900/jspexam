package com.hand;

import java.util.Scanner;

import com.bean.customer;
import com.bean.inputCustomer;
import com.interfac.customerMapper;

public class Main {

	public static void main(String[] args) {
		customerMapper map = new Utils().getMap();
		customer c = new inputCustomer().inputC();
		map.addCus(c);
		

	}

}
