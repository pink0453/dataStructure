package cn.lyc.ds.list.impl;

import cn.lyc.ds.list.Queue;

public class QueueImpl<T> extends ArrayList<T> implements Queue<T>{

	@Override
	public T enqueue(T e) {
		// TODO Auto-generated method stub
		add(e);
		return e;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T e = get(size()-1);
		remove(size()-1);
		return e;
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		return get(size()-1);
	}


}
