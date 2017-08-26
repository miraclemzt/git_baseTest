package com.tmz.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

	private static final int portNumber = 5566;
	
	public static void main(String[] args) throws InterruptedException {
		
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
					
		ServerBootstrap b = new ServerBootstrap();
		
		b.group(bossGroup,workerGroup);
		
		b.channel(NioServerSocketChannel.class);
		
		b.childHandler(new ServerInitializer());
		
			ChannelFuture f = b.bind(portNumber).sync();
			
			f.channel().closeFuture().sync();
			

			} finally {
					bossGroup.shutdownGracefully();
					workerGroup.shutdownGracefully();
			}
			
	}
	
}
