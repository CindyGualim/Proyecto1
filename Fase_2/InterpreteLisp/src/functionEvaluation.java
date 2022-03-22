/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos 
 * @author Diana Díaz 21066
 * @author Cindy Gualim 21226
 * @author Andres Chivalan 21534
 * @version 1.0 22/03/2022
 */

 //imports
import java.util.ArrayList;
import java.util.List;

//esta es la clase que evalua las entradas 
public class functionEvaluation {

    /**
     * verificar si es atom
     * @param value
     * @return boleano 
     */
    public boolean isAtom(Object value) {
        try {
            if ((Integer) Integer.parseInt(value.toString()) instanceof Integer) {
                return true;
            }
        } catch (NumberFormatException e) {
            try {

                if ((Float) Float.parseFloat(value.toString()) instanceof Float) {
                    return true;
                }
            } catch (NumberFormatException e2) {
                try {

                    if ((Double) Double.parseDouble(value.toString()) instanceof Double) {
                        return true;
                    }
                } catch (NumberFormatException e3) {

                    try {
                        String valor = value.toString();
                        if (valor instanceof String) {
                            if (Character.toString(valor.charAt(0)).equals("'")) {
                                return true;
                            }
                            return false;
                        }
                    } catch (Exception e4) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     *  pasar a lista
     * @param values
     * @return lista
     */
    public List<Object> toList(List<Object> values) {
        return values;
    }

    /**
     * verificar si es igual 
     * @param a
     * @param b
     * @return
     */
    public boolean isEqual(Object a, Object b) {
        return a.equals(b);
    }

    /**
     * si es mayor que 
     * @param a
     * @param b
     * @return la lista
     */
    public boolean isGreaterThan(Object a, Object b) {
        return (Double.parseDouble(a.toString()) > Double.parseDouble(b.toString()));
    }

    /**
     * es menor que 
     * @param a
     * @param b
     * @return lista
     */
    public boolean isLessThan(Object a, Object b) {
        return (Double.parseDouble(a.toString()) < Double.parseDouble(b.toString()));
    }

    /**
     * 
     * @param instructions
     * @return lsita
     */
    public Object cond(List instructions) {// Cond
        List subList = instructions.subList(1, instructions.size());
        List subList2 = (List) subList.get(0);
        int i = 0;
        for (Object inst : subList2) {
            List instruccion = (List) inst;
            if (instruccion.contains("equal")) {
                if (isEqual(instruccion.get(1), instruccion.get(2))) { //comparar si es igual
                    return instruccion.get(3);
                }
            } else if (instruccion.contains("<")) {
                if (isLessThan(instruccion.get(1), instruccion.get(2))) { //comparar si es menor que 
                    return instruccion.get(3);
                }
            } else if (instruccion.contains(">")) {
                if (isGreaterThan(instruccion.get(1), instruccion.get(2))) { //comparar si es mayor que 
                    return instruccion.get(3);
                }
            } else if (i == subList2.size()) { //verificar si es igual que el tamaño 
                return subList2.get(i);
            }
            i++;
        }
        return null;
    }

}
