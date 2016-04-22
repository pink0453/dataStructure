package test;

import cn.lyc.ds.list.impl.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		num.add(2);
		num.add(2);
		num.add(3);
		num.add(3);
		
		num.put(77, 2);
		num.insert(88, 3);
		
		num.add(888);
		num.add(888);
		num.add(888);
		num.add(888);
		num.add(888);
		num.add(888);
		num.add(888);
		
		num.remove(0);
		
		System.out.println(num.contains(23231));
		System.out.println(num.indexOf(888));
		System.out.println(num.find(88, 4, 10));
		System.out.println(num.size());
		
		num.uniquify();
		
		System.out.println(num);
		
	}
	
}
