package com.tmz.hextest;

public class Weiyunsuan {

	
	/**
	 * 
	 * 现在的电脑都是32位的。32位主要是指CPU的运算模式。大家知道的，1个字节为8位，16位的运算时，
	 * 一次只能提取16位，即2个字节；32位的一次提取32位，即4个字节。现在流行的64位的是一样的道理。
	 */
	public static void main(String[] args) {
		
		System.err.println(int2byte(10)[0]);
		System.err.println(int2byte(10)[1]);
		System.err.println(int2byte(10)[2]);
		System.err.println(int2byte(10)[3]);
		System.err.println(Integer.MAX_VALUE);
		System.err.println(Byte.MAX_VALUE);
	}
	
	public static byte[] int2byte(int res) {  
		byte[] targets = new byte[4];  
		  
		targets[0] = (byte) (res & 0xff);// 最低位   
		targets[1] = (byte) ((res >> 8) & 0xff);// 次低位   
		targets[2] = (byte) ((res >> 16) & 0xff);// 次高位   
		targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。   
		return targets;   
		}   
}
