package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

/**
 * Clase de interfaz stack
 * @param <E> 
 */
public interface Stack<E> {
    /** 
     * agregar item
     * @param item
     */
    public void add(E item);

    /**
     * eliminar el ultimo elemento
     * @return Item
     */
    public E remove();

    /**
     * get el ultimo elemento del stack
     * @return Item
     */
    public E peek();

    /**
     * Check if the Stack is empty.
     * @return Boolean 
     */
    public boolean empty();

    /**
     * obtener el tamaño del stack
     * @return int
     */
    public int size();
}

