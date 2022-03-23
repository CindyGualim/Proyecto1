/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos 
 * @author Diana Díaz 21066
 * @author Cindy Gualim 21226
 * @version 1.0 22/03/2022
 */


 //imports
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Cindy Gualim
 *es la clase que maneja las operaciones aritmeticas
 */
public class ArithmeticCalculator {

    /**
     * calcular
     * @param prefixList
     * @return peek
     */
    public Double calculate(List<Object> prefixList) {

        Stack<Double> result = new Stack<>();

        String signo = String.valueOf(prefixList.get(0));

        for (int i = 1; i < prefixList.size(); i++) {
            if (prefixList.get(i) instanceof Integer || prefixList.get(i) instanceof Double) {
                result.push(Double.parseDouble(prefixList.get(i).toString()));
            } else if (prefixList.get(i) instanceof ArrayList) {
                result.push(calculate((List) prefixList.get(i)));
            }
        }

        //si hace match con el simbolo
        if (signo.matches("[+]")) {
            result.push(sumar(result));
        }
        if (signo.matches("[-]")) {
            result.push(restar(result));
        }
        if (signo.matches("[*]")) {
            result.push(multiplicar(result));
        }
        if (signo.matches("[/]")) {
            result.push(dividir(result));
        }

        return result.peek();
    }

    
    /**
     * suma
     * @param value
     * @return respuesta de suma
     */
    public double sumar(Stack<Double> value) {

        double res = 0.00;
        int lenstack = value.size();
        for (int control = 0; control < lenstack; control++) {
            res += value.pop();
        }
        return res;
    }

    
    /**
     * resta 
     * @param value
     * @return respuesta de resta
     */
    public double restar(Stack<Double> value) {
        Stack<Double> temp_stack = revertStack(value);
        double res = temp_stack.pop();
        int lenstack = temp_stack.size();

        for (int control = 0; control < lenstack; control++) {
            res -= temp_stack.pop();
        }
        return res;
    }

    
    /**
     * multiplicación
     * @param value
     * @return respuesta de multiplciacaión
     */
    public double multiplicar(Stack<Double> value) {
        double res = value.pop();
        int lenstack = value.size();
        for (int control = 0; control < lenstack; control++) {
            res *= value.pop();
        }
        return res;
    }

    
    /**
     * dividir
     * @param value
     * @return respuesta de división
     */
    public double dividir(Stack<Double> value) {

        Stack<Double> temp_stack = revertStack(value);

        double res = temp_stack.pop();
        int lenstack = temp_stack.size();

        for (int control = 0; control < lenstack; control++) {
            res /= temp_stack.pop();
        }

        return res;
    }

    /**
     * 
     * @param value
     * @return stack
     */
    public Stack<Double> revertStack(Stack<Double> value) {
        Stack<Double> temp_stack = new Stack();
        while (!value.empty()) {
            temp_stack.add((double) value.pop());
        }

        return temp_stack;
    }
}
