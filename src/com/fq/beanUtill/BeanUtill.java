package com.fq.beanUtill;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtill{
	
	public static void main(String[] args) throws Exception {
		new BeanUtill().as();
	}
	
	void as() throws Exception{
		
		Admin admin = new Admin();		
		//BeanUtils.setProperty(admin, "userName", "冯庆");
		BeanUtils.copyProperty(admin, "userName", "冯庆");
		
		Admin newAdmin = new Admin();
		
		BeanUtils.copyProperties(newAdmin, admin);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userNAme", "冯庆");
		map.put("age", 26);
		BeanUtils.copyProperties(newAdmin, map); 
		
		System.out.println(newAdmin.getUserName());
		System.out.println(newAdmin.getAge());
		
		
	}
}
