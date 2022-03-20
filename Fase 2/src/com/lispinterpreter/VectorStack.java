package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 //import
import java.util.Vector;

/**la clase vector  */
public class VectorStack<E> implements Stack<E> { //se implementa la interfaz del stack

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
