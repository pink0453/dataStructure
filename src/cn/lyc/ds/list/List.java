package cn.lyc.ds.list;

public interface List<T> {

	/**
	 * 返回当前元素个数
	 * @return
	 */
	int size();
	
	/**
	 * 判断当前是否无元素
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 添加元素
	 * @param e
	 * @return
	 */
	boolean add(T e);
	
	/**
	 * 获取下表为i的元素
	 * @param i
	 */
	T get(int i);
	
	/**
	 * 将元素e替换下标为i的元素
	 * @param e
	 * @param i
	 */
	boolean put(T e, int i);
	
	/**
	 * 将元素e插入到i的位置其他元素后移
	 * @param e
	 * @param i
	 */
	T insert(T e, int i);
	
	/**
	 * 删除下标为i的元素
	 * @param i
	 */
	boolean remove(int i);
	
	/**
	 * 查找元素
	 * @param e
	 * @return
	 */
	boolean contains(Object o);
	
	/**
	 * 删除重复元素   唯一化
	 */
	void uniquify();
	
	/**
	 * 遍历所有元素
	 */
	void traverse();
}
