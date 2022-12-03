package com.example;
public class GenericStack<T> implements IStack<T> {

    private IList<T> stackList = new GenericArrayList<>();

    @Override
    public void push(T elem) {
        stackList.add(elem);

    }

    @Override
    public T pop() {
        int lastPos = (stackList.size() - 1);
        return stackList.remove(lastPos);
    }

    @Override
    public T peek() {
        return stackList.get(0);
    }

    @Override
    public boolean empty() {
        return stackList.size() == 0;
    }
    
}
