package com.example;
public class GenericQueue<T> implements IQueue<T> {

    private IList<T> queueList = new GenericArrayList<>();
    @Override
    public void enqueue(T elem) {
        queueList.add(elem);
    }

    @Override
    public T dequeue() {
        return queueList.remove(0);
    }

    @Override
    public T first() {
       return queueList.get(0);
    }

    @Override
    public boolean empty() {
        return queueList.size() == 0;
    }
    
}
