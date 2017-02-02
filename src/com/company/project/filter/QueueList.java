package com.company.project.filter;

import java.util.LinkedList;

public class QueueList<T> extends LinkedList<T> {
    private final int maxSize;

    public QueueList(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T e) {
        super.addFirst(e);
        if (size() > maxSize) {
            removeLast();
        }
        return true;
    }
}
