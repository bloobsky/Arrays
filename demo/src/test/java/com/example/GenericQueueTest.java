package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;    

public class GenericQueueTest {

    private GenericQueue<String> gQueue;

    @BeforeEach
    public void setup(){
        gQueue = new GenericQueue<>();

    }
        
    @Test
    // enqueue and dequeue test
    public void enqueue_dequeue() {
        gQueue.enqueue("String");
        gQueue.enqueue("Strings");

        assertEquals("String", gQueue.dequeue());
        assertEquals("Strings", gQueue.dequeue());
        
    }

    @Test
    // checking if array is empty
    public void isEmpty() {
        assertEquals(true, gQueue.empty());
    }

    @Test
    //add element and check if array NOT empty
    public void add_CheckEmpty() {
        gQueue.enqueue("Element");
        assertEquals(false, gQueue.empty());
    }
}
    