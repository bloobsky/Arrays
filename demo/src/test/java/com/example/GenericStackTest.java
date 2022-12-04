package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;    
    
public class GenericStackTest {


    GenericStack<String> gStack;

    @BeforeEach
    public void setup(){
        gStack = new GenericStack<>();

    }
        
    @Test
    //adding and removing
    public void push_and_pop() {
        gStack.push("1");
        gStack.push("2");

        assertEquals("2", gStack.pop());
        assertEquals("1", gStack.pop());
    }

    @Test
    // adding and get
    public void push_peek() {
        gStack.push("Check me this value");
        assertEquals("Check me this value", gStack.peek());
    }

    @Test
    //check if empty
    void empty_check() {
        assertEquals(true, gStack.empty());
    }

    @Test
    // add element and check if empty
    void add_and_check() {
        gStack.push("Empty Check");


    }

}
    