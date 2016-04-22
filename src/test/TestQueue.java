package test;

import cn.lyc.ds.list.impl.QueueImpl;

public class TestQueue {

	public static void main(String[] args) {
		
		QueueImpl<Integer> queue = new QueueImpl<Integer>();
		
		for(int i = 0; i < 100; i++){
			
			queue.enqueue(i);
			
		}
		
		while(!queue.isEmpty()){
			
			System.out.println(queue.dequeue());
			
		}
		
	}
	
}
