package com.tmz.io.socket;

import java.net.*;
import java.io.*;

public class PortScanner {
	
//	public static void main(String args[]) {
//		String host = "localhost";
//		if (args.length > 0)
//			host = args[0];
//		new PortScanner().scan(host);
//	}

	public void scan(String host) {
		Socket socket = null;
		for (int port = 1; port < 1024; port++) {
			try {
				socket = new Socket(host, port);
				System.out.println("There is a server on port " + port);
			} catch (IOException e) {
				System.out.println("Can't connect to port " + port);
			} finally {
				try {
					if (socket != null)
						socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static boolean isPortUsing(String host,int port) throws UnknownHostException {
		
		boolean flag = false;
		
		InetAddress inetAddress = InetAddress.getByName(host);
		
		try {
			Socket socket = new Socket(inetAddress, port);
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static void main(String[] args) throws UnknownHostException {
		String host = "localhost";
		isPortUsing(host, 10022);
	}
	
	
}

