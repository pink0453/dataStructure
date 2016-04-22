package cn.lyc.ds.list;
/**
 * 栈
 * @author asdc
 *
 */
public interface Stack<T> {

	/**
	 * 入栈
	 * @param e
	 * @return
	 */
	T push(T e);
	
	/**
	 * 出栈
	 * @return
	 */
	T pop();
	
	/**
	 * 返回栈顶部对象
	 * @return
	 */
	T peek();
	
	/**
	 * 判断当前栈是否为空
	 * @return
	 */
	boolean empty();
	
	/**
	 * 返回当前栈的大小
	 * @return
	 */
	int size();
	
}
