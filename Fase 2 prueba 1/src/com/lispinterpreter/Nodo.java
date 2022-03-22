package com.lispinterpreter;
import java.util.ArrayList;

public class Nodo<E> {
    protected float dataF;
    protected String dataS;
    protected ArrayList<Nodo> lista;
    protected int tipo;
    protected E data;   // Store the node data



    protected Nodo<E> nextElement; // Store a reference to the next element

    public Nodo(float v)
    {
        dataF = v;
        tipo = 1;
    }

    public Nodo(String v)
    {
        dataS =v;
        tipo = 2;
    }

    public Nodo(ArrayList<Nodo> v)
    {
        lista = v;
        tipo = 3;
    }


    /**
     * Create a node with all the params.
     * @param data
     * @param nextElement
     */
    public Nodo(E data, Nodo<E> nextElement) {
        this.data = data;
        this.nextElement = nextElement;
    }

    /**
     * Create a Node with only the data (nextElement is null).
     * @param data
     */
    public Nodo(E data) {
        this(data, null);
    }

    /**
     * Get the next Node
     * @return
     */
    public Nodo<E> next() {return this.nextElement;}

    /**
     * Set the next node
     * @param next
     */
    public void setNext(Nodo<E> next) {
        this.nextElement = next;
    }

    /**
     * Get the current value for the data
     * @return
     */
    public E value() {
        return this.data;
    }

    /**
     * Set the new value for data
     * @param value
     */
    public void setValue(E value) {
        this.data = value;
    }

}
