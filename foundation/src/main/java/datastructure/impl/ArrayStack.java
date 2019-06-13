package datastructure.impl;

import datastructure.service.Stack;

/**
 * @Author:Kevin
 * @Description: array implements stack
 * @Date: 2019/5/5 14:58
 */
public class ArrayStack implements Stack {
    private int size;
    private int top;
    private int[] data;

    public ArrayStack(int size) {
        data = new int[size];
        top = -1;
        this.size = size;
    }

    public void push(int item) {
        data[top + 1] = item;
        top++;
    }

    public int pop() {
        int res = data[top];
        top--;
        return res;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            return data[top];
        }
    }
}
