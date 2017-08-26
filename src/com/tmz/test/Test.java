package com.tmz.test;


public class Test {

	public static void main(String[] args) {
		
		String deviceKey = "QXDS00003";
		char[] no = new char[4];
		no[0] = deviceKey.charAt(0);
		no[1] = deviceKey.charAt(1);
		no[2] = deviceKey.charAt(2);
		no[3] = deviceKey.charAt(3);
		String number = deviceKey.substring(4);
		Integer noo = Integer.valueOf(number);
		System.err.println("number:" + number);
		byte[] cmd = new byte[6];
		cmd[0] = (byte) no[0];
		cmd[1] = (byte) no[1];
		cmd[2] = (byte) no[2];
		cmd[3] = (byte) no[3];

		cmd[4] = NumberUtils.int2Byte(noo)[2];
		cmd[5] = NumberUtils.int2Byte(noo)[3];
		System.err.println(cmd);
	}
	
}
