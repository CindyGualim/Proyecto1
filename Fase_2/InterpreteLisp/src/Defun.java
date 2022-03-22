/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos 
 * @author Diana Díaz 21066
 * @author Cindy Gualim 21226
 * @author Andres Chivalan 21534
 * @version 1.0 22/03/2022
 */

 //imports
import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Diana
//es la clase defun
public class Defun {

    private String funName = "";
    private HashMap<String, Object> variables = new HashMap<>();
    private List<Object> instructions;

    /**
     * 
     * @param funName
     * @param vars
     * @param inst
     */
    public Defun(String funName, Object vars, Object inst) {


        List<String> variables = new ArrayList<>();
        variables.add(vars.toString());
        List instructions = (List) inst;
        this.funName = funName;
        for (String item : variables) {
            this.variables.put(item, null);
        }
        this.instructions = instructions;
    }


    /**
     * correr las instrucciones
     * @param variables
     * @return hashmap
     */
    public List<Object> executeInstructions(List variables) {
        List tempInstructions = this.instructions;
        HashMap<String, Object> tempVariables = this.variables;
        
        if (variables.size() == tempVariables.size()) { //verificar si las variables es igual que el hashmap
            int i = 0; //contador
            for (String key : tempVariables.keySet()) {
                tempVariables.replace(key, variables.get(i));
                i++;
            }
           
            i = 0;
            while (i < tempInstructions.size()) { //mientras sea menor que el hashmap
                if ((tempInstructions.get(i) instanceof String)) {
                    for (String key : tempVariables.keySet()) {
                        if (tempInstructions.get(i).equals(key)) {
                            tempInstructions.add(i, tempVariables.get(key)); //add la key
                            tempInstructions.remove(i + 1);
                        }
                    }
                } else if (tempInstructions.get(i) instanceof ArrayList) { 
                    List subInstruction = (List) tempInstructions.get(i); //hacer el cast para pasar el hashmap a lsita
                    int j = 0;
                    while (j < subInstruction.size()) { //mientras sea menor
                        if ((subInstruction.get(j) instanceof String)) {
                            for (String key : tempVariables.keySet()) {
                                if (subInstruction.get(j).equals(key)) {
                                    subInstruction.add(j, tempVariables.get(key));
                                    subInstruction.remove(j + 1);
                                }
                            }
                        }
                        j++;
                    }
                    tempInstructions.add(i, subInstruction);
                    tempInstructions.remove(i + 1);
                }
                i++;
            }
            return tempInstructions;

        } else {

        }

        return tempInstructions;
    }

    /**
     * get el nombre
     * @return el nombre
     */
    public String getFunName() {
        return this.funName;
    }

}
