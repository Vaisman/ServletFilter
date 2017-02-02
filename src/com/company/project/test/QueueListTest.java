package com.company.project.test;

import com.company.project.filter.QueueList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueListTest {

    @Test
    public void testFifoQueue() {
        QueueList<Integer> list = new QueueList<>(3);
        assertEquals("[]", list.toString());

        list.add(1);
        assertEquals("[1]", list.toString());

        list.add(2);
        assertEquals("[2, 1]", list.toString());

        list.add(3);
        assertEquals("[3, 2, 1]", list.toString());

        list.add(4);
        assertEquals("[4, 3, 2]", list.toString());

        list.add(1);
        assertEquals("[1, 4, 3]", list.toString());
    }
}
