package com.example;

import java.util.*;

public class GenericArrayList<T> implements IList<T>{
    
    private T[] buffer;

    public GenericArrayList() {
        int list_size = 0;
        buffer = (T[]) new Object[list_size]; // initialing new object with the size

    }

    @Override
    public void add(T elem) {
        T[] temporary = (T[]) new Object[buffer.length+1]; // increasing value
        int i = 0;

        for (i = 0; i<buffer.length; i++) {
            temporary[i] = buffer[i];
        }
        temporary[i] = elem;
        buffer = temporary;

    }
    
    @Override
    public void add(int index, T elem) throws IndexOutOfBoundsException{
        if (index > buffer.length) throw new IndexOutOfBoundsException("ERROR: Index of range.");

        T[] temporary = (T[]) new Object[buffer.length+1];
        int indexTemp = 0;
        for(int i = 0; i <= buffer.length; i++) {
            if (i == index) {
                temporary[indexTemp] = elem;
                indexTemp++;
            }

            if(i == buffer.length) break;
                temporary[indexTemp] = buffer[i];
                indexTemp++;
                         
        }
        buffer = temporary;
        
    }

    @Override
    // set obj in array
    public T set(int index, T elem) {
        T previous = buffer[index];
        buffer[index] = elem;
        return previous;
    }
    
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index > buffer.length) throw new IndexOutOfBoundsException("ERROR: Index of range.");
        return buffer[index];
    }

    @Override
    // get size of array function
    public int size() {
        return buffer.length;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index > buffer.length) throw new IndexOutOfBoundsException("ERROR: Index of range.");

        T[] temporary = (T[]) new Object[buffer.length -1];
        T entry = buffer[index];
        int indexTemp = 0;

        for (int i = 0; i < buffer.length; i++) {
            if (i == index) i++;
            if (i == buffer.length) break;

            temporary[indexTemp] = buffer[i];
            indexTemp++;
        }
        buffer = temporary;
        return entry;

    }

    @Override
    public boolean remove(T elem) {
        T[] temporary = (T[]) new Object[buffer.length - 1];
        int indexTemp = 0;
        boolean value = false;

        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i] == elem) {
                value = true;
                i++;
            }
            if (i == buffer.length || indexTemp == temporary.length) break;

            temporary[indexTemp] = buffer[i];
            indexTemp++;

            if(value) buffer = temporary;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return buffer.length == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = buffer.length -1; i >=0; i--) {
            if (buffer[i] == element) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIterator();
    }

    class GenericArrayListIterator implements Iterator<T> {

        private int val = 0;

        @Override
        public boolean hasNext() {
            return val < buffer.length;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return buffer[val++];
        }
    }

}
