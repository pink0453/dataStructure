package cn.lyc.ds.list.impl;

import java.util.NoSuchElementException;

import cn.lyc.ds.list.List;
import cn.lyc.ds.list.Queue;
import cn.lyc.ds.list.Stack;

/**
 * 双向链表实现
 * @author asdc
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T>,Stack<T>,Queue<T> {

	Node<T> first;
	Node<T> last;
	
	int size = 0;
	
	/**
	 * 将元素作为首节点  从头插入
	 * @param e
	 */
	private void linkFirst(T e){
		
		Node<T> temp = first;
		
		Node<T> newNode = new Node<T>(null, e, first);
		first = newNode;
		
		if(temp == null){
			
			last = first;
			
		}else{
			
			temp.prev = first;
			
		}
		
		size++;
		
	}
	
	/**
	 * 将元素作为尾节点 从尾插入
	 * @param e
	 */
	private void linkLast(T e){
		
		Node<T> temp = last;
		
		Node<T> newNode = new Node<T>(last,e,null);
		last = newNode;
		
		//如果last为空说明当前列表中并无元素
		if(temp == null){
			
			//当前节点即为首节点也为尾节点
			first = last;
			
		}else{
			
			//有元素
			//将上一个存入本身下一个引用中
			temp.next = last;
			
		}
		
		size++;
		
	}
	
	/**
	 * 删除链表第一个元素
	 * @return
	 */
	private T unLinkFirst(Node<T> first){
		
		T item = first.item;
		Node<T> next = first.next;

		first.item = null;
		first.next = null;
		
		first = next;
		
		if(next == null){
			
			last = next;
			
		}else{
			
			next.prev = null;
			
		}
		
		size--;
		
		return item;
		
	}
	
	/**
	 * 删除列表最后一个元素
	 * @param last
	 * @return
	 */
	private T unLinkLast(Node<T> last){
		
		T item = last.item;
		Node<T> prev = last.prev;
		
		last.item = null;
		last.prev = null;
		
		last = prev;
		
		if(prev == null){
			
			first = null;
			
		}else{
			
			prev.next = null;
			
		}
		
		size--;
		
		return item;
		
	}
	
	/**
	 * 在传入元素前插入元素
	 * @param index
	 * @param node
	 */
	void linkBefore(T e, Node<T> succ){
		
		
		Node<T> tmpPrev = succ.prev;
		
		//判断是否为头元素
		if(tmpPrev == null){
			
			linkFirst(e);
			
		}else{
			
			Node<T> newNode = new Node<T>(tmpPrev, e, succ);
			
			//重新指向
			tmpPrev.next = newNode;
			tmpPrev = succ;
			
			size++;
			
		}
		
	}
	
	/**
	 * 将节点与链表分离  删除当前节点
	 * @param node
	 */
	T unLink(Node<T> node){
		
		Node<T> tmpPrev = node.prev;
		Node<T> tmpNext = node.next;
		T tmpT = node.item;
		
		//判断当前节点是否为首尾节点
		if(tmpPrev == null){
			
			first = tmpNext;
			
		}else if(tmpNext == null){
			
			last = tmpPrev;
			
		}else{
			
			tmpPrev.next = tmpNext;
			node.next = null;
			
			tmpNext.prev = tmpPrev;
			node.prev = null;
			
		}
		
		tmpT = null;
		size--;
		
		return tmpT;
		
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

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		
		linkLast(e);
		
		return true;
	}
	
	public void addFirst(T e){
		
		linkFirst(e);
		
	}
	
	public void addLast(T e){
		
		linkLast(e);
		
	}
	
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		
		if(checkIndex(i)){
			
			return node(i).item;
			
		}else{
			
			return null;
			
		}
		
	}
	
	/**
	 * 根据下标返回节点
	 * @param index
	 * @return
	 */
	public Node<T> node(int index){
		
		if(index < (size/2)){
			
			Node<T> e = first;
			for(int j = 0; j < index; j++){
				
				e = e.next;
				
			}
			
			return e;
			
		}else{
			
			Node<T> e = last;
			
			for(int j = size - 1; j > index; j--){
				
				e = e.prev;
				
			}
			
			return e;
			
		}
		
	}
	
	/**
	 * 检查下标是否合法
	 * @param index
	 * @return
	 */
	private boolean checkIndex(int index){
		
		if(index >= 0 && index < size){
			
			return true;
			
		}
		
		return false;
		
	}

	@Override
	public boolean put(T e, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T insert(T e, int i) {
		// TODO Auto-generated method stub
		
		if(checkIndex(i)){
			
			Node<T> node = node(i);
			linkBefore(e, node);
			
		}
		
		
		return e;
	}

	@Override
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		
		if(checkIndex(i)){
			
			unLink(node(i));
			
		}else{
			
			return false;
			
		}
		
		
		return true;
	}
	
	/**
	 * 移除第一个元素
	 * @return
	 */
	public T removeFirst(){
		
		Node<T> f = first;
		
		if(f == null){
			
			throw new NoSuchElementException();
			
		}
		
		return unLinkFirst(f);
		
	}
	
	/**
	 * 移除最后一位元素
	 * @return
	 */
	public T removeLast(){
		
		Node<T> l = last;
		
		if(l == null){
			
			throw new NoSuchElementException();
			
		}
		
		return unLinkLast(l);
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void uniquify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub
		
	}
	
	private static class Node<T> {
		
		T item;
		Node<T> prev;//前驱
		Node<T> next;//后继
		
		public Node(Node<T> prev, T item, Node<T> next) {

			this.item = item;
			this.prev = prev;
			this.next = next;
		}
		
	}

	//------------------------------------以下为链队--------------------------------------------
	
	@Override
	public T enqueue(T e) {
		// TODO Auto-generated method stub
		
		add(e);
		
		return e;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		
		return removeLast();
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		return get(size - 1);
	}

	//------------------------------------以下为链栈--------------------------------------------
	
	@Override
	public T push(T e) {
		// TODO Auto-generated method stub
		
		addFirst(e);
		
		return null;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		
		removeFirst();
		
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return get(0);
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	} 

}
