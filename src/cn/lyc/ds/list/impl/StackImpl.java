package cn.lyc.ds.list.impl;

import java.util.Arrays;

import cn.lyc.ds.list.Stack;

public class StackImpl<T> implements Stack<T>{

	private int cap;//规模
	private int size;//实际大小
	private int initSize = 10;//初始大小
	private Object[] obj;
	
	public StackImpl() {
		// TODO Auto-generated constructor stub\

		obj = new Object[initSize];
		size = 0;
		cap = 10;
		
	}
	
	/**
	 * 长度是否应该增长
	 */
	private void grow(int curSize){
		
		if(curSize > cap){
			
			cap = cap * 2;
			Arrays.copyOf(obj, cap);
			
		}
		
	}
	
	@Override
	public T push(T e) {
		// TODO Auto-generated method stub
		
		grow(size + 1);
		
		obj[size] = e;
		
		size++;
		
		return e;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		
		T e = peek();
		
		size--;
		obj[size] = null;//移除栈顶元素
		
		return e;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		
		if(empty() != true){
			
			return (T) obj[size - 1];
			
		}
		
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	

}
