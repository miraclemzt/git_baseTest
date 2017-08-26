package com.tmz.thread.base;

public class ThreadStopTest {

	
	public static void main(String[] args) {
		MypThread myThread = new MypThread();
		Thread thread = new Thread(myThread);
		for (int i = 0; i < 10; i++) {
			System.err.println(Thread.currentThread().getName()+"-"+i);
			if(i==3){
				thread.start();
			}
			if(i==4){
				System.err.println("12");
				myThread.threadStop();
			}
		}
	}
	
}

class MypThread implements Runnable{

	private boolean stop = false;
	
	@Override
	public void run() {
		
		for (; !stop; ) {
//			System.err.println(stop);
			System.err.println(Thread.currentThread().getName());
		}
		
	}
	
	public void threadStop(){
		System.err.println("123");
		this.stop = true;
	}
	
}