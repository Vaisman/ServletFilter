package main.java.statistics;

import java.util.LinkedList;

public final class QueueList<T> extends LinkedList<T> {
    private final int maxSize;

    public QueueList(final int maxQueueSize) {
        maxSize = maxQueueSize;
    }

    @Override
    public boolean add(final T e) {
        super.addFirst(e);
        if (size() > maxSize) {
            removeLast();
        }
        return true;
    }
}
