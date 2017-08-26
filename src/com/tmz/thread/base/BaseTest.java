package com.tmz.thread.base;

public class BaseTest {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.err.println(Thread.currentThread().getName()+"-"+i);
			if(i==30){
				Thread thread1 = new MyThread();
				Thread thread2 = new MyThread();
				thread1.start();
				thread2.start();
//				MyRunThread myRunThread = new MyRunThread();
//				Thread thread1 = new Thread(myRunThread);
//				Thread thread2 = new Thread(myRunThread);
//				thread1.start();
//				thread2.start();
				
			}
			
		}
	}
	
}
