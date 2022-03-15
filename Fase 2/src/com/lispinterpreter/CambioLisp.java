package com.lispinterpreter;

import java.util.ArrayList;
import java.util.Arrays;

public final class CambioLisp {

    private static ArrayList<Nodo> parsedProgram = new ArrayList<Nodo>();


    /** Method to separate the program as an Array List */
    public static ArrayList<Nodo> separator(String program) {
        String[] programa= program.split(" ");
        ArrayList<String> tokensList= new ArrayList(Arrays.asList(programa));
        return parseProgram(tokensList);
    }


    /**
     * Parse a lisp program
     * @param separatedProgram
     * @return
     */
    public static ArrayList<Nodo> parseProgram(ArrayList<String> separatedProgram) {
        ArrayList<Nodo> parsedProgram = new ArrayList<>();
        while(!separatedProgram.isEmpty()) {
            Nodo node;
            String t = separatedProgram.remove(0);
            if (t.equals("(")) {
                node = new Nodo(parseProgram(separatedProgram));
                parsedProgram.add(node);
            } else if (t.equals(")")) {
                return parsedProgram;
            } else if (isNumber(t)) {
                parsedProgram.add(new Nodo(Float.parseFloat(t)));
            } else {
                parsedProgram.add(new Nodo(t));
            }
        }
        return parsedProgram;
    }

    private static boolean isNumber(String value) {
        try {
            Double number = Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }

}
