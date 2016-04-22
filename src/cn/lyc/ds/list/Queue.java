package cn.lyc.ds.list;

public interface Queue<T> {

	
	/**
	 * 入队
	 * @param e
	 * @return
	 */
	T enqueue(T e);
	
	/**
	 * 出队
	 * @return
	 */
	T dequeue();
	
	/**
	 * 返回队首元素
	 * @return
	 */
	T front();
	
}
