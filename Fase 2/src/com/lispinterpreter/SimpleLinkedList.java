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
    protected int count;
    protected Nodo<E> head;
    public SimpleLinkedList() {

    }

    /**
     * override de la clase abstractlist tamaño y regresa el conteo 
     */
    @Override
    public int size() {
        return count;   
    }

    @Override
    public void addFirst(E value) {
        head = new Nodo<E>(value, head);
        count ++;
    }

    @Override
    public E getFirst() {
        return head.value();
    }

    @Override
    public E getLast() {
        Nodo<E> tempNode = head;
        if (isEmpty()) return  null;    // The list should not be empty
        // Look for the last element
        while (tempNode.next() != null) {
            tempNode = tempNode.next();
        }
        return tempNode.value();    // Return the last value
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;   // The list should not be empty
        Nodo<E> tempNode = head;    // Get the Node that is currently the head
        head = tempNode.next(); // Head is going to be the next node
        count--;
        return tempNode.value();
    }

    @Override
    public E remove() {
        // Declare variables to save the references
        Nodo<E> finger = head;
        Nodo<E> previous = null;
        if (isEmpty()) return null; // The list should not be empty
        while(finger.next() != null) {
            previous = finger;
            finger = finger.next();
        }
        // If the previous is null, the list is going to be empty
        if (previous == null) {
            head = null;
        } else {
            previous.setNext(null); // Drop the reference to the last Node
        }
        count --;
        return finger.value();
    }

    @Override
    public void add(E value) {
        Nodo<E> tempNode = new Nodo<E>(value); // Create the new node
        if (!isEmpty()) {
            Nodo<E> finger = head;
            // Find the last element
            while (finger.next() != null) {
                finger = finger.next();
            }
            // Add that element to the list
            finger.setNext(tempNode);
        } else {
            // Adding a first element to the list
            head = tempNode;
        }
        // Increment the count
        count ++;
    }
}
