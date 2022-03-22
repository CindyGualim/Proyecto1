package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

/*Clase abstracta de lista */
public abstract class AbstractList<E> implements List<E> {

    /**
     * verifica si está vacia 
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
