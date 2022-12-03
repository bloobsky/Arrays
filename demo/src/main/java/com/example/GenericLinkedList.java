package com.example;

import java.util.*;
public class GenericLinkedList<T> implements IList<T> {

    private Node head, tail;
    private int arraySize;


    @Override
    public void add(T elem) {
       Node newNode = new Node(elem);

       if (head == null) {
        head = newNode;
        tail = newNode;
        arraySize++;
       } 
       else addEnd(newNode);
        
    }

    @Override
    public void add(int index, T elem) throws IndexOutOfBoundsException {
        Node n = head;
        Node newNode = new Node(elem);
        boolean throwException = true;

        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
            return;
        }

        int i = 0;

        while(n != null) {
            if (i == index - 1) {
                newNode.nextNode = n.nextNode;
                n.nextNode = newNode;
                throwException = false;
            }
            n = n.nextNode;
            i++;
        }
        if (throwException) throw new IndexOutOfBoundsException("ERROR: Index of out range");

        arraySize++;
        
    }

    @Override
    public T set(int index, T elem) {
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
        return arraySize;
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            Node tempNode = head;
            head = head.nextNode;
            arraySize--;
        }

        Node <T> n = head;
        for (int i  = 0; i < index -1; i++) {
            if(n.nextNode == null) throw new IndexOutOfBoundsException("ERROR: Index out of range.");
            n = n.nextNode;
        }

        Node tempNode = n.nextNode;
        n.nextNode = n.nextNode.nextNode;
        if (n.nextNode == null) tail = n;
        arraySize--;
        
        return (T) tempNode;
    }

    @Override
    public boolean remove(T elem) {
       Node<T> n = head;
       if(n.get() == elem) {
        head = n.nextNode;
        arraySize--;
        return true;
       }

       while(n.nextNode != null) {
        if(n.nextNode.get() == elem) {
            n.nextNode = n.nextNode.nextNode;
            if (n.nextNode == null) tail = n;
            arraySize--;
            return true;
        }
        n = n.nextNode;
       }

       return false;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T elem) {
        Node<T> n = head;
        while(n != null) {
            if(n.get() == elem) return true;
            n = n.nextNode;
        }
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
