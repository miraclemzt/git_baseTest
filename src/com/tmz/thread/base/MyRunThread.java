package com.tmz.thread.base;

public class MyRunThread implements Runnable{

	private int i = 0 ;

	@Override
	public void run() {
		for(i = 0;i < 100;i++){
			System.err.println(Thread.currentThread().getName()+"-"+i);
		}
	}
	
}
