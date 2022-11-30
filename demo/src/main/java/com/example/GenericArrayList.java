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
        IndexCheck(index);
        T[] temporary = (T[]) new Object[buffer.length+1];

        for(int i = temporary.length-1; i>=0; i--) {
            if (i == index) {
                temporary[i] = elem;
                i--;
                if(i<0) break; // skipping
            }
            temporary[i] = buffer[i-1];
        }
        buffer = temporary;
    }

    @Override
    // set obj in array
    public T setObj(int index, T elem) {
        T previous = buffer[index];
        buffer[index] = elem;
        return previous;
    }
    
    @Override
    // get obj from array
    public getObj(int index) throws IndexOutOfBoundsException {
        IndexCheck(index);
        return buffer[index];
    }

    @Override
    // get size of array function
    public int getSize() {
        return buffer.length;
    }

}
