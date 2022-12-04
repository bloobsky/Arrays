package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GenericLinkedListTest {
    
    //setup config
    GenericArrayList<String> gList;

    @BeforeEach
    void setup() {
        gList = new GenericArrayList<>();
    }

    
    @Test
    void add_3Elements_ReturnSize() {
        // checking 3 elements and if they return size of array
        gList.add("First Elem");
        assertEquals(1, gList.size());

        gList.add("Second Elem");
        assertEquals(2, gList.size());

        gList.add("Third Elem");
        assertEquals(3, gList.size());
    }

    @Test 
    // checking if data is moving with array
    void add_3Elements_CorrectIndex() {
        gList.add(0, "First Elem");
        gList.add(0, "Second Elem");
        gList.add(2, "Third Elem");

        assertEquals("Second Elem", gList.get(0));
        assertEquals("First Elem", gList.get(1));
        assertEquals("Third Elem", gList.get(2));

    }

    @Test
    // checking throw exception
    void throw_exception() {
        assertThrows ( IndexOutOfBoundsException.class, () -> {gList.add(100, "Hundred");});
    }

    @Test
    //adding 4 values and checking  if set correctly
    void set_5Val_CheckSet() {
        gList.add("V");
        gList.add("Va");
        gList.add("Val");
        gList.add("Valu");
        gList.add("Value");

        gList.set(0, "V");
        gList.set(0, "Va");
        gList.set(0, "Val");
        gList.set(0, "Valu");
        gList.set(0, "Value");
    }

    @Test
    // set with throw exception 
    void set_throw_exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> { gList.set(5, "5th");});
    }



    @Test
    //adding and checking if the same value returned
    void get_AddAndGet_CheckReturn() {
    
        gList.add("This is what I am looking for");
        assertEquals("This is what I am looking for", gList.get(0));
    }

    @Test
    // get value outside of index range
    void get_throw_exception () {
        gList.add("ERROR");
        assertThrows(IndexOutOfBoundsException.class, () -> { gList.get(5);});
    }

    @Test
    // checking if correct entry in correct place
    void contains_3Elements_CheckPresence() {
        gList.add("A");
        gList.add("B");
        gList.add("C");

        assertEquals(true, gList.contains("A"));
        assertEquals(true, gList.contains("B"));
        assertEquals(true, gList.contains("C"));
    }

    @Test
    //add 1 element but check for second one
    void contains_add1Elem_Check2nd() {
        gList.add("1st Element");

        assertEquals(false, gList.contains("2nd Element"));
    }

    @Test
    // remove 1 entry from 2 added and check if removed correctly
    void remove_2added_1removed () {
        gList.add("Keep");
        gList.add("Remove");

       // assertEquals(2, gList.size());
        assertEquals("Keep", gList.get(0));
        assertEquals(true, gList.remove("Remove"));

    }

    @Test
    //check if array is empty
    void checkIfEmpty() {
        assertEquals(true, gList.isEmpty());
    }

    @Test
    //iterator test
    void iterator_add_checkReturn () {
        gList.add("Check");
        gList.add("Return");

        int j = 0;
        for (String elem : gList) {
            assertEquals(gList.get(j), elem);
            j++;
        }
    }
}
