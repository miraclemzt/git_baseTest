package com.tmz.thread;

public class Deadlock {
	
	public static void main(String[] args) {
		
		Resource resource = new Resource();
		Resource resource2 = new Resource();
		T1 t1 = new T1(resource, resource2);
		T2 t2 = new T2(resource, resource2);
		
		t1.start();
		t2.start();
		
	}
	
}
