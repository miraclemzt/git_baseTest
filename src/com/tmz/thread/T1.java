package com.tmz.thread;

public class T1 extends Thread{
	
	Resource r1,r2;
//	Resource r2;
	
	public T1 (Resource r1,Resource r2){
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			synchronized (r1) {
				System.err.println("t1��ȡr1");
				
				synchronized (r2) {
					System.err.println("t1��ȡr2");
				}
			}
		
			
		}
		
	}
}
