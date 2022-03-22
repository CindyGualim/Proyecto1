package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 /* imports */
import java.util.ArrayList;

/*la clase nodo  */
public class Nodo<E> {

    protected float dataF;
    protected String dataS;
    protected ArrayList<Nodo> lista;
    protected int tipo;
    protected E data;   



    protected Nodo<E> nextElement; 

    /**
     * nodo en tipo float
     * @param v
     */
    public Nodo(float v)
    {
        dataF = v;
        tipo = 1;
    }

    /**
     * nodo en tipo string
     * @param v
     */
    public Nodo(String v)
    {
        dataS =v;
        tipo = 2;
    }

    /**
     * nodo en lista
     * @param v
     */
    public Nodo(ArrayList<Nodo> v)
    {
        lista = v;
        tipo = 3;
    }


    /**
     * Crear nodo
     * @param data
     * @param nextElement
     */
    public Nodo(E data, Nodo<E> nextElement) {
        this.data = data;
        this.nextElement = nextElement;
    }

    /**
     * crear nodo con solo la data
     * @param data
     */
    public Nodo(E data) {
        this(data, null);
    }

    /**
     * sigueinte nodo
     * @return
     */
    public Nodo<E> next() {
        return this.nextElement;
    }

    /**
     * next nodo
     * @param next
     */
    public void setNext(Nodo<E> prox) {
        this.nextElement = prox;
    }

    /**
     * valor actual
     * @return
     */
    public E value() {
        return this.data;
    }

    /**
     * set el valor
     * @param value
     */
    public void setValue(E valor) {
        this.data = valor;
    }

}
