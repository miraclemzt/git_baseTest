package com.tmz;

import java.util.HashMap;
import java.util.Map;

public class Ms {

	/**
	 * 
	 * ��1��2��2��3��4��5���������֣���javaдһ��main��������ӡ�����в�ͬ�����У��磺512234��412345�ȣ�Ҫ��
	 * "4 "�����ڵ���λ�� "3 "�� "5 "��������.
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
