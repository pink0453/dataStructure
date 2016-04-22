package test;

import cn.lyc.ds.list.impl.StackImpl;

public class TestStack {

	public static void main(String[] args) {
		
		StackImpl<Integer> s = new StackImpl<>();
		
		System.out.println(s.empty());
		
		//顺序入栈
		for(int i = 0; i < 10; i++){
			
			s.push(i);
			
		}
		
		System.out.println("peek is " + s.peek());
		
		System.out.println("pop is begin......");
		//顺序出栈
		while(!s.empty()){
			
			System.out.println(s.pop());
			
		}
		System.out.println("pop is end......");
		
		System.out.println(s.empty());
		
	}
	
}
