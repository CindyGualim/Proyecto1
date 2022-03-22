
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
public class DataManager {

    String PATH_FILE = "";

    public DataManager() {

    }

    public void setPathFile(String path) {
        PATH_FILE = path;
    }

    public String getDataFile() {
        BufferedReader reader;
        String linea, datos = "";

        try {
            reader = new BufferedReader(new FileReader(PATH_FILE));

            while ((linea = reader.readLine()) != null) {
                datos += linea + "\n";
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return datos;
    }

    public boolean getExists() {
        return (new File(PATH_FILE)).exists();
    }

    public List getTokens(String delimitador) {

        return Collections
                .list(new StringTokenizer(getDataFile().replaceAll("[", "").replaceAll("]", "").replaceAll("\\(", " ( ")
                        .replaceAll("\\)", " ) ").trim(), delimitador))
                .stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());

    }

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

    // obtener el parseo en forma de arreglos del lenguaje LISP

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

    //
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