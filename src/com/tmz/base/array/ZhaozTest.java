package com.tmz.base.array;

public class ZhaozTest {

	public static void main(String[] args) {
		int[] arr = new int[]{8,2,1,0,3};
		int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
		String tel = "";
		for (int i : index) {
			System.err.println(i+ "_"+arr[i]);
			tel+= arr[i];
		}
//		for (int i : arr) {
//			System.err.println(i);
//			tel+= arr[i];
//		}
		System.err.println(tel);
	}
	
}
