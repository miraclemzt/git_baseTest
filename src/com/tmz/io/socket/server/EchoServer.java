package com.tmz.io.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	private int port = 8000;
	
	private ServerSocket serverSocket;
	
	
	public EchoServer () throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	public String echo(String msg) {
	
		return "echo" + msg;

	}
	
	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		
		return new PrintWriter(outputStream, true);
	}
	
	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream inputStream = socket.getInputStream();
		
		return new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public void service() {
		Socket socket = null;
		
		while (true) {
			
			try {
				
				socket = serverSocket.accept();
				System.err.println("New connection accepted"
											+ socket.getInetAddress() + ":"+socket.getPort());
				BufferedReader bReader = getReader(socket);
				PrintWriter printWriter = getWriter(socket);
					
				String msg = null;
				while ((msg = bReader.readLine()) != null) {
					System.err.println(msg);
					printWriter.println(echo(msg));
					
					if (msg.equals("bye")) {
						
						break;
					}
					
				}
				
			} catch (IOException e) {
				
			}
		}
		
	}
	
}
