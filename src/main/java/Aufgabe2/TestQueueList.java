package Aufgabe2;

import Aufgabe3.QueueList2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import static org.junit.Assert.assertEquals;

public class TestQueueList {

    QueueList2 list = new QueueList2();

    /*
    @Test
    public void testToString() {
        QueueList list = new QueueList();
        assertEquals("", list.toString(), "check empty queuelist");
        list.pushFront(1);
        assertEquals("[1]", list.toString(), "check with one element");
        list.pushFront(2);
        assertEquals("[2, 1]", list.toString(), "check with two elements");
        list.popLast();
        assertEquals("[2]", list.toString(), "check popLast");
    }

     */

    @Test
    public void popFront() {
        list.pushFront(1);
        list.pushFront(2);
        list.pushLast(3);
        assertEquals(2, list.popFront());
        assertEquals(1, list.popFront());
        assertEquals(3, list.popFront());
        assertEquals(-1, list.popFront());
    }

    @Test
    public void popLast() {
        list.pushLast(1);
        list.pushLast(2);
        list.pushLast(3);
        assertEquals(3, list.popLast());
        assertEquals(2, list.popLast());
        assertEquals(1, list.popLast());
        assertEquals(-1, list.popLast());
    }

    @Test
    public void pushFront() {
        assertEquals(1, list.pushFront(1));
        assertEquals(2, list.pushFront(2));
        assertEquals(1, list.pushFront(1));
    }

    @Test
    public void pushLast() {
        assertEquals(1, list.pushLast(1));
        assertEquals(2, list.pushLast(2));
        assertEquals(1, list.pushLast(1));
    }

    @Test
    public void getI() {
        list.pushFront(1);  //0
        list.pushLast(2);   //1
        list.pushFront(3);  //0
        list.pushLast(4);   //1
        list.pushFront(5);  //0
        list.pushLast(6);   //1
        list.pushFront(7);  //0
        list.pushLast(8);   //1

        // 75312468


        assertEquals(7, list.get(1));
        assertEquals(5, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(1, list.get(4));
        assertEquals(2, list.get(5));
        assertEquals(4, list.get(6));
        assertEquals(6, list.get(7));
        assertEquals(8, list.get(8));
    }


}
