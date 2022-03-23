/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos 
 * @author Diana Díaz 21066
 * @author Cindy Gualim 21226
 * @author Andres Chivalan 21534
 * @version 1.0 22/03/2022
 */

 //imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Cindy Gualim
 */
//esta es la clase donde se maneja el file y el guardado de datos
public class DataManager {

    String PATH_FILE = "";

    //constructor
    public DataManager() {

    }

    /**
     * set el path
     * @param path
     */
    public void setPathFile(String path) {
        PATH_FILE = path;
    }

    /**
     * get lo que esta en el file
     * @return datos del file
     */
    public String getDataFile() {
        BufferedReader reader;
        String linea, datos = "";

        try {
            reader = new BufferedReader(new FileReader(PATH_FILE));

            while ((linea = reader.readLine()) != null) { //mientras exista otra linea
                datos += linea + "\n";
            }
            reader.close();

        } catch (Exception e) { //manejo de errores
            e.printStackTrace();
        }

        return datos;
    }

    /**
     * get del verificador que existe
     * @return si existe
     */
    public boolean getExists() {
        return (new File(PATH_FILE)).exists();
    }

    /**
     * get tokens
     * @param delimitador
     * @return las colecciones
     */
    public List getTokens(String delimitador) {

        return Collections
                .list(new StringTokenizer(getDataFile().replaceAll("[", "").replaceAll("]", "").replaceAll("\\(", " ( ")
                        .replaceAll("\\)", " ) ").trim(), delimitador))
                .stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());

    }

    /**
     * get tokens
     * @param delimitador
     * @param value
     * @return la lista
     */
    public List getTokens(String delimitador, String value) {
        String tempValue = value.replaceAll("\\,", " ").replaceAll("\\[", "(").replaceAll("\\]", ")");
        List tempList = Collections
                .list(new StringTokenizer(tempValue.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim(),
                        delimitador))
                .stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        return tempList;

    }

    /**
     * get atom
     * @param token
     * @return token
     */
    private Object getAtom(String token) {
        try {
            // Si es entero, retornamos el valor en tipo int
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            try {
                // Si es flotante, se convierte el string a Float
                return Float.parseFloat(token);
            } catch (NumberFormatException e2) {
                try {
                    // Si es un double, se convierte el string a decimal
                    return Double.parseDouble(token);
                } catch (NumberFormatException e3) {
                    // Si no es numerico, se retorna el token original en un tipo string
                    return token;
                }
            }
        }
    }

    
    /**
     * obtener el parseo en forma de arreglos del lenguaje LISP
     * @param instruccion
     * @return lista
     * @throws Exception
     */

    public Object getInstruccion(List instruccion) throws Exception {

        if (instruccion.isEmpty()) {
            throw new IllegalArgumentException(" La instrucción no es valida debido al valor incongruente.");
        }

        String token = instruccion.remove(0).toString();

        if (token.equals("(")) {

            List<Object> tempList = new ArrayList<Object>(instruccion.size() - 1);
            try {

                while (!instruccion.get(0).equals(")")) {

                    tempList.add(getInstruccion(instruccion));
                }

                // removemos el primer valor
                instruccion.remove(0);

                if (instruccion.get(0).equals("(") && instruccion.size() > 1) {
                    tempList.add(getInstruccion(instruccion));
                }

                // Retornamos el sub arreglo para almacenarlo en la lista.
                return tempList;
            } catch (Exception e) {
                return tempList;
            }

        } else if (token.equals(")")) {
            throw new Exception("Inconsistencia en la busqueda ')' dentro de lo pedido.");
        } else {
            // retornamos el valor con su estructura de datos para almacenarlo en el arreglo
            return getAtom(token);
        }

    }

    /**
     * get lista
     * @return lista
     */
    public List<Object> getListInstruccion() {
        String tempInstruction = "";
        char[] caracteres = (getDataFile().replace("\n", "") + "\n").toCharArray();

        List<Object> listas = new ArrayList<Object>();

        for (int control = 0; control < caracteres.length; control++) {

            if (caracteres[control] == ')') {
                tempInstruction += caracteres[control];

                if (control < (caracteres.length - 2)) {
                    if (caracteres[control + 1] == '(') {
                        listas.add(tempInstruction);
                        tempInstruction = "";
                    }
                }

            } else if (caracteres[control] == '\n') {
                listas.add(tempInstruction);
                tempInstruction = "";
            } else {
                tempInstruction += caracteres[control];
            }

        }

        return listas;
    }

}