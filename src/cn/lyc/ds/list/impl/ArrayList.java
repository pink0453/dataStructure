package cn.lyc.ds.list.impl;

import java.util.Arrays;

import cn.lyc.ds.list.List;

public class ArrayList<T> implements List<T>{

	private int cap;//规模
	private int size;//实际大小
	private int initSize = 10;//数组初始大小
	private Object[] element;//存储元素数组
	
	public ArrayList() {
		// TODO Auto-generated constructor stub
		
		element = new Object[initSize];
		cap = initSize;
		size = 0;
		
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	/**
	 * 数组动态扩容
	 * @param curSize 当前数组容量
	 */
	private void grow(int curSize){
		
		if(curSize > cap){
			
			cap = cap * 2;//规模*2递增
			
			//将原有数组复制进去
			element = Arrays.copyOf(element, cap);
			
		}
		
	}
	
	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		
		grow(size + 1);//先判断是否应该扩容
		element[size] = e;
		size++;
		
		return true;
	}

	/**
	 * 检查下标值是否合法
	 * @param i
	 */
	private boolean rangeCheck(int i){
		
		if(i < 0 && i >= size){
			
			return false;
			
		}
		
		return true;
		
	}
	
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		
		if(rangeCheck(i) == false){
			
			return null;
			
		}
		
		return (T) element[i];
	}

	@Override
	public boolean put(T e, int i) {
		// TODO Auto-generated method stub
		
		if(rangeCheck(i) == true){
			
			element[i] = e;
			
		}else{
			
			return false;
			
		}
		
		return true;
	}

	@Override
	public T insert(T e, int i) {
		// TODO Auto-generated method stub
		
		if(rangeCheck(i) == true){
			
			grow(size + 1);
			for(int j = size; j > i; j--){
				
				element[j] = element[j - 1];//从最后一位顺序后移一位，为了不覆盖数据。
				
			}
			
			element[i] = e;
			size++;
			return e;
			
		}
		
		return null;
	}

	@Override
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		
		if(rangeCheck(i) == true){
			
			element[i] = null;
			
			for(int j = i; j < size; j++){
				
				element[j] = element[j+1];
				
			}
			
			size--;
			return true;
			
		}
		
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < size; i++){
			
			if(element[i].equals(o)){
				
				return true;
				
			}
			
		}
		
		return false;
	}

	/**
	 * 返回元素第一次出现的下标
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		
		if(o == null){
			
			for(int i = 0; i < size; i++){
				
				if(element[i] == null){
					
					return i;
					
				}
				
			}
			
		}else{
			
			for(int i = 0; i < size; i++){
				
				if(element[i].equals(o)){
					
					return i;
					
				}
				
			}
			
		}
		
		return -1;
		
	}
	
	/**
	 * 返回一个区间内的元素出现的第一个下标
	 * @param o
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int find(Object o, int lo, int hi){
		
		while((lo < hi--) && (!element[hi].equals(o))); 
		
		return hi;
		
	}
	
	@Override
	public void uniquify() {
		// TODO Auto-generated method stub
		
		int i = 1;
		while(i < size){
			
			if(find(element[i], 0, i) < 0){//让当前元素与它前缀比较
				
				i++;
				
			}else{
				
				remove(i);
				
			}
			
		}
		
	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub
		
	}

}
