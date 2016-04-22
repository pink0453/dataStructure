package cn.lyc.ds.list.impl;

import cn.lyc.ds.list.Stack;

/**
 * 栈的应用
 * @author asdc
 *
 */
public class StackApplication {

	
	/**
	 * 进制转换 将10进制的数转换为任意进制的数
	 * @param num
	 * @param base
	 * @return
	 */
	public int convert(int num, int base){
		
		String[] bit = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		
		Stack<String> temp = new StackImpl<>();
		while(num != 0){
			
			temp.push(bit[num % base]);
			num = num / base;
			
		}
		
		String newNumStr = "";
		while(!temp.empty()){
			
			newNumStr = newNumStr + temp.pop();
			
		}
		
		return Integer.parseInt(newNumStr);
		
	}
	
	
}
