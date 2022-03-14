package com.lispinterpreter;

public abstract class AbstractList<E> implements List<E> {

    /**
     * Defines if the list is empty
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
