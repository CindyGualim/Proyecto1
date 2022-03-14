package com.lispinterpreter;

public class SimpleLinkedList<E> extends AbstractList<E> {
    protected int count;
    protected Node<E> head;
    public SimpleLinkedList() {

    }

    @Override
    public int size() {
        return count;   // Return the count of the list
    }

    @Override
    public void addFirst(E value) {
        head = new Node<E>(value, head);
        count ++;
    }

    @Override
    public E getFirst() {
        return head.value();
    }

    @Override
    public E getLast() {
        Node<E> tempNode = head;
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
        Node<E> tempNode = head;    // Get the Node that is currently the head
        head = tempNode.next(); // Head is going to be the next node
        count--;
        return tempNode.value();
    }

    @Override
    public E remove() {
        // Declare variables to save the references
        Node<E> finger = head;
        Node<E> previous = null;
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
        Node<E> tempNode = new Node<E>(value); // Create the new node
        if (!isEmpty()) {
            Node<E> finger = head;
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
