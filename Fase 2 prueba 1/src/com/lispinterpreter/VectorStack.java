package com.lispinterpreter;

import java.util.Vector;

public class VectorStack<E> implements Stack<E> {

    Vector<E> data;

    VectorStack() {
        data = new Vector<E>();
    }

    @Override
    public void add(E item) {
        data.add(item);
    }

    @Override
    public E remove() {
        if(empty()) return null;
        return data.remove(size() - 1);
    }

    @Override
    public E peek() {
        return data.get(size() - 1);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }

}
