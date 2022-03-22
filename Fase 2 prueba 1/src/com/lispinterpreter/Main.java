package com.lispinterpreter;
/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y estructuras de datos
 *  @author Diana Díaz 21066
 *  @author Andres Chivalan 
 *  @author Cindy Gualim
 */

 //imports
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*la clase pricnipal del programa */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n Programa de interprete lisp");

        try {
            // Abrir archivo
            File lisp = new File("Proyecto1.lisp");
            Scanner lector = new Scanner(lisp); // leer el programa lisp
            String archivo = "";

            // Guardar el programa en el string
            while(lector.hasNextLine()) {
                archivo = lector.nextLine();
            }

            // guardar en arraylist
            ArrayList<Nodo> tokens = CambioLisp.separator(archivo);

            // 
            printTokens(tokens, 0);
            // Imprimir 

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * imprime los tokens del programa
     * @param tokens
     * @param tabs
     */
    public static void printTokens(ArrayList<Nodo> tokens, int f) {

        while (!tokens.isEmpty()) {
            Nodo n = tokens.remove(0);
            if (n.tipo == 1) {
                for (int i = 0; i < f; i++) {
                    System.out.print("  ");
                }
                System.out.printf("%f \n", n.dataF);
            } else if (n.tipo == 2) {
                for (int i = 0; i < f; i++) {
                    System.out.print("  ");
                }
                System.out.printf("%s \n", n.dataS);
            } else if (n.tipo == 3) {
                printTokens(n.lista, f);
            }
        }
    }
}
