package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 /*Clase de lista  */
public class SimpleLinkedList<E> extends AbstractList<E> {
    protected int contador;
    protected Nodo<E> head;
    protected Nodo<E> nodo;

    public SimpleLinkedList() {

    }

    /**
     * override de la clase abstractlist tamaño y regresa el conteo 
     */
    @Override
    public int size() {
        return contador;   
    }

    @Override
    public void addFirst(E value) {
        head = new Nodo<E>(value, head);
        contador ++;
    }

    @Override
    public E getFirst() {
        return head.value();
    }

    @Override
    public E getLast() {
        nodo = head;
        if (isEmpty()) return  null;    
        while (nodo.next() != null) {
            nodo = nodo.next();
        }
        return nodo.value();    
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) 
            return null;   
        nodo = head;   
        head = nodo.next(); 
        contador--;
        return nodo.value();
    }

    @Override
    public E remove() {
        Nodo<E> j = head;
        Nodo<E> anterior = null;
        if (isEmpty()) return null; 
        while(j.next() != null) {
            anterior = j;
            j = j.next();
        }
        
        if (anterior == null) {
            head = null;
        } else {
            anterior.setNext(null); 
        }
        contador --;
        return j.value();
    }

    @Override
    public void add(E value) {
        nodo = new Nodo<E>(value); 
        if (!isEmpty()) {
            Nodo<E> finger = head;
            while (finger.next() != null) {
                finger = finger.next();
            }
            
            finger.setNext(nodo);
        } else {
            
            head = nodo;
        }
        
        contador ++;
    }
}
