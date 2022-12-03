package com.example;

import java.util.*;
public class GenericLinkedList<T> implements IList<T> {

    private Node head, tail;
    private int arraySize;


    @Override
    public void add(T elem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(T elem) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public void addFirst(T val) {
        Node newNode = new Node(val);
        newNode.nextNode = head;
        head = newNode;
        arraySize++;
    }

    public void addLast(T val) {
        Node newNode = new Node(val);
        addEnd(newNode);
    }

    public void addEnd(Node n) {
        tail.nextNode = n;
        tail = n;
        arraySize++;
    }
    class Node<T> {
        T val;
        Node nextNode = null;

        public T get(){
            return val;
        }
        Node (T val) {
            this.val = val;
        }
    }
    
}
