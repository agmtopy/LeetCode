package com.agmtopt.leetcode.algorithmtrainingcamp.list;

public class DesignCircularDeque_641 {

    public static void main(String[] args) {
        DesignCircularDeque_641_MyCircularDeque deque = new DesignCircularDeque_641_MyCircularDeque(12);

        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertFront(4);


        deque.getFront();
        deque.deleteFront();

        deque.getRear();
        deque.deleteLast();
    }

}
class DesignCircularDeque_641_MyCircularDeque {
    private int[] elements;
    private int rear, front;
    private int capacity;

    public DesignCircularDeque_641_MyCircularDeque(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[capacity];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
