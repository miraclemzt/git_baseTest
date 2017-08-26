package com.tmz.netty.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tmz.netty.server.ServerInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	public static String host = "127.0.0.1";
	public static int port = 5566;
		
	
	
	public static void main(String[] args) throws InterruptedException {
		
		EventLoopGroup loopGroup = new NioEventLoopGroup();
		
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(loopGroup)
		.channel(NioSocketChannel.class)
		.handler(new ClientInitializer());
		
		//连接服务端
		Channel  ch = bootstrap.connect(host,port).sync().channel();
		
		//控制台输入
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (;;) {
			
			try {
				String line = in.readLine();
				
				if (line  == null) {
					continue;
				}
				
				ch.writeAndFlush(line + "\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				loopGroup.shutdownGracefully();
			}
			
		}
		
	}
	
}
