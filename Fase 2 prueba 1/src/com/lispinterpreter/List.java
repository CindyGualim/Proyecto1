package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 /*interface */
public interface List<E> {
    /**
     * tamaño
     * @return
     */
    public int size();

    /**
     * verificar si está vacio 
     * @return
     */
    public boolean isEmpty();

    /**
     * agregar al pricnipio
     * @param value
     */
    public void addFirst(E value);

    /**
     * el primer elemento de la lista
     * @return
     */
    public E getFirst();

    /**
     * utlimo elemento de la lista
     * @return
     */
    public E getLast();

    /**
     * quitar el primer elemento de la lista
     * @return
     */
    public E removeFirst();

    /**
     * quita elementos de la lista
     * @return
     */
    public E remove();

    /**
     * agregar elementos 
     * @param value
     */
    public void add(E value);
}
