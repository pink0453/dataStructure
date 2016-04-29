package test;

import cn.lyc.ds.list.impl.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		for(int i = 0; i < 10; i++){
			
			linkedList.addFirst(i);
			
		}
		
		linkedList.insert(111, 2);
		
		System.out.println(linkedList);
		
	}
	
}
