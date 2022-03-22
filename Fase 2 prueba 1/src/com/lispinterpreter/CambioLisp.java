package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 //imports
import java.util.ArrayList;
import java.util.Arrays;

/* clase donde se pasa a lisp */
public class CambioLisp {

    private ArrayList<Nodo> parsedProgram = new ArrayList<Nodo>();


    /** separa el programa lisp y lo guarda en una lista */
    public static ArrayList<Nodo> separator(String p) {
        String[] programa= p.split(" ");
        ArrayList<String> tokens= new ArrayList(Arrays.asList(programa));
        return parseProgram(tokens);
    }


    /**
     * Pasar a lisp
     * @param programa
     * @return
     */
    public static ArrayList<Nodo> parseProgram(ArrayList<String> programa) {
        ArrayList<Nodo> p = new ArrayList<>();
        while(!programa.isEmpty()) {
            Nodo nodo;
            String t = programa.remove(0);
            if (t.equals("(")) {
                nodo = new Nodo(parseProgram(programa));
                p.add(nodo);
            } else if (t.equals(")")) {
                return p;
            } else if (isNumber(t)) {
                p.add(new Nodo(Float.parseFloat(t)));
            } else {
                p.add(new Nodo(t));
            }
        }
        return p;
    }

    private static boolean isNumber(String numero) {
        try {
            Double n = Double.parseDouble(numero);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

}
