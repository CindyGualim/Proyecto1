import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Diana
public class Defun {

    private String funName = "";
    private HashMap<String, Object> variables = new HashMap<>();
    private List<Object> instructions;

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


    public List<Object> executeInstructions(List variables) {
        List tempInstructions = this.instructions;
        HashMap<String, Object> tempVariables = this.variables;
        
        if (variables.size() == tempVariables.size()) {
            int i = 0;
            for (String key : tempVariables.keySet()) {
                tempVariables.replace(key, variables.get(i));
                i++;
            }
           
            i = 0;
            while (i < tempInstructions.size()) {
                if ((tempInstructions.get(i) instanceof String)) {
                    for (String key : tempVariables.keySet()) {
                        if (tempInstructions.get(i).equals(key)) {
                            tempInstructions.add(i, tempVariables.get(key));
                            tempInstructions.remove(i + 1);
                        }
                    }
                } else if (tempInstructions.get(i) instanceof ArrayList) {
                    List subInstruction = (List) tempInstructions.get(i);
                    int j = 0;
                    while (j < subInstruction.size()) {
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

    public String getFunName() {
        return this.funName;
    }

}
