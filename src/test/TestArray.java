package test;

import cn.lyc.ds.list.impl.Array;

public class TestArray {

	public static void main(String[] args) {
		
		long[] test = {24,1,9,10};
		//,10,15,30,23,26,3,4,5,25,2
		
//		int a = Array.binarySearch(test, 15);
//		int b = Array.interpolationSearch(test, 30);
//		int c = Array.fibonacciSearch(test, 30);
		
		Array.MergerSort(test, 0, test.length-1);
		
		for(int i = 0; i < test.length; i++){
			
			System.out.println(test[i]);
			
		}
		
	}
	
}
