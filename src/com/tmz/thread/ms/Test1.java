package com.tmz.thread.ms;

public class Test1 {

	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
//				print();
				System.err.println("hehe");
			}
		};
		t.run();
//		t.start();http://www.cnblogs.com/lanxuezaipiao/p/3371224.html
		
		System.err.println("haha");
	}
	
//	static void print(){
//		System.err.println("hehe");
//	}
}
