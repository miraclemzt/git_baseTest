package com.tmz.thread;

public class T2 extends Thread{
	Resource r1,r2;
//	Resource r2;
	
	public T2 (Resource r1,Resource r2){
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			synchronized (r1) {
				System.err.println("t2获取r1");
				synchronized (r2) {
					System.err.println("t2获取r2");
				}
			}
			
			
		}
		
	}
	
	
}
