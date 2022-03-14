package com.lispinterpreter;

import java.util.ArrayList;
import java.util.Arrays;

public final class LispParser {

    private static ArrayList<Node> parsedProgram = new ArrayList<Node>();


    /** Method to separate the program as an Array List */
    public static ArrayList<Node> separator(String program) {
        String[] programa= program.split(" ");
        ArrayList<String> tokensList= new ArrayList(Arrays.asList(programa));
        return parseProgram(tokensList);
    }


    /**
     * Parse a lisp program
     * @param separatedProgram
     * @return
     */
    public static ArrayList<Node> parseProgram(ArrayList<String> separatedProgram) {
        ArrayList<Node> parsedProgram = new ArrayList<>();
        while(!separatedProgram.isEmpty()) {
            Node node;
            String t = separatedProgram.remove(0);
            if (t.equals("(")) {
                node = new Node(parseProgram(separatedProgram));
                parsedProgram.add(node);
            } else if (t.equals(")")) {
                return parsedProgram;
            } else if (isNumber(t)) {
                parsedProgram.add(new Node(Float.parseFloat(t)));
            } else {
                parsedProgram.add(new Node(t));
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
