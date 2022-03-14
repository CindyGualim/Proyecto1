package com.lispinterpreter;

public interface List<E> {
    /**
     * Obtain the size of the list
     * @return
     */
    public int size();

    /**
     * Obtains a boolean indicating if the list is empty or not
     * @return
     */
    public boolean isEmpty();

    /**
     * Attempts to add an item at the beginning of the List
     * @param value
     */
    public void addFirst(E value);

    /**
     * Gets the first element of the list
     * @return
     */
    public E getFirst();

    /**
     * Gets the last element of the list
     * @return
     */
    public E getLast();

    /**
     * Removes the first element of the list
     * @return
     */
    public E removeFirst();

    /**
     * Removes the last element of the list
     * @return
     */
    public E remove();

    /**
     * Adds an item at the end of the list
     * @param value
     */
    public void add(E value);
}
