package com.tmz;

import java.util.HashMap;
import java.util.Map;

public class Ms {

	/**
	 * 
	 * 用1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列，如：512234、412345等，要求：
	 * "4 "不能在第三位， "3 "与 "5 "不能相连.
	 */

	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("0", "a");
		map.put("2", "s");
		
		map.put("5", "d");
		map.put("4", "f");
		
		System.err.println(map.keySet());
		System.err.println(map.entrySet());
	}
	
	
}
