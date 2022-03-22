
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InterpreteLisp {

    final static String DELIMITADOR = " \t\n\r\f";

    public static void main(String[] args) {

        int opcion = 0;

        try {
            while (true) {

                System.out.println("\n\t\tMENÚ");
                System.out.println("\n\t 1) Ejecutar");
                System.out.println("\n\t 2) Salir");

                System.out.print("Ingrese la opción: ");
                opcion = Keyboard.readInt();

                switch (opcion) {
                    case 1:
                        String path = "";
                        System.out.print("Ingrese el Path del archivo: ");

                        path = Keyboard.readString();

                        DataManager archivo = new DataManager();

                        archivo.setPathFile(path);

                        if (archivo.getExists()) {

                            System.out.println(
                                    String.format("\n\n\t\tExpresión a Evaluar: \n\n%s\n", archivo.getDataFile()));

                            runLisp(archivo.getListInstruccion());
                        } else {
                            System.out.println(String.format("\n\t\tEl archivo de la ruta %s no fue encontrado", path));
                        }
                        break;
                    case 2:
                        System.exit(0);
                }

            }
        } catch (Exception e) {
            System.out.println(String.format("\n\n\t\tOcurrio el problema: %s", e.toString()));
        }

    }

    public static void runLisp(Object value) throws Exception {
        try {

            List instruccions = (List) value;

            List tempIns = new ArrayList();

            DataManager archivo = new DataManager();

            for (int control = 0; control < instruccions.size(); control++) {
                tempIns.add(
                        archivo.getInstruccion(archivo.getTokens(DELIMITADOR, instruccions.get(control).toString())));

            }

            List<Defun> deFun = new ArrayList<>();

            for (Object i : tempIns) {

                List instruccion = null;

                if (i instanceof ArrayList) {
                    instruccion = (List) i;
                } else if (i instanceof String) {
                    instruccion = Arrays.asList(tempIns.toString().split(" "));

                } else {
                    instruccion = tempIns;
                }

                if (instruccion.contains("atom")) {

                    if (instruccion.size() == 2) {

                        if ((new functionEvaluation()).isAtom(instruccion.get(1))) {
                            System.out.print("\n\t\tResultado: True\n\n");
                        } else {
                            System.out.print("\n\t\tResultado: NIL\n\n");
                        }
                    }

                    else {
                        System.out.println("La función de atom tiene erroes de sintaxis");
                    }
                } else if (instruccion.contains("defun")) {
                    List subList = (List) instruccion.get(2);
                    Defun newFunc = new Defun(instruccion.get(1).toString(), subList.get(0), subList.get(1));
                    deFun.add(newFunc);
                } else if (instruccion.contains("list")) {
                    List<Object> list = new functionEvaluation().toList(instruccion.subList(1, instruccion.size()));
                    System.out.println(list);
                } else if (instruccion.contains("equal")) {
                    if ((new functionEvaluation()).isEqual(instruccion.get(1), instruccion.get(2))) {
                        System.out.print("\n\t\tResultado: True\n\n");
                    } else {
                        System.out.print("\n\t\tResultado: NIL\n\n");
                    }
                } else if (instruccion.contains(">")) {
                    if ((new functionEvaluation()).isGreaterThan(instruccion.get(1), instruccion.get(2))) {
                        System.out.print("\n\t\tResultado: True\n\n");
                    } else {
                        System.out.print("\n\t\tResultado: NIL\n\n");
                    }
                } else if (instruccion.contains("<")) {
                    if ((new functionEvaluation()).isLessThan(instruccion.get(1), instruccion.get(2))) {
                        System.out.print("\n\t\tResultado: True\n\n");
                    } else {
                        System.out.print("\n\t\tResultado: NIL\n\n");
                    }
                } else if (instruccion.contains("+") || instruccion.contains("-") || instruccion.contains("*")
                        || instruccion.contains("/")) {
                    ArithmeticCalculator calculator = new ArithmeticCalculator();
                    System.out.println("\n\t\tResultado: " + calculator.calculate(instruccion));
                    break;
                } else if (instruccion.contains("cond")) {

                    runLisp((new functionEvaluation()).cond(instruccion));

                } else {
                    for (Defun fun : deFun) {
                        if (instruccion.contains(fun.getFunName())) {
                            List<Object> tempSubIns = fun
                                    .executeInstructions(instruccion.subList(1, instruccion.size()));

                            String sub_instruccion = String.format("(%s)", listToString(tempSubIns));

                            // System.out.println( archivo.getInstruccion(archivo.getTokens( DELIMITADOR ,
                            // sub_instruccion )) );
                            runLisp(archivo.getInstruccion(archivo.getTokens(DELIMITADOR, sub_instruccion)));
                            // runLisp(archivo.getInstruccion(archivo.getTokens( DELIMITADOR , tempSIns )));
                        }
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("\n\n\tOcurrio un problema al evaluar la expreción. \n\tError: " + e.toString());
        }
    }

    public static String listToString(List value) {
        String tempSIns = "";

        List tempList = (List) value;
        for (int control = 0; control < tempList.size(); control++) {

            if (tempList.get(control) instanceof List) {
                tempSIns += "(";
                tempSIns += listToString((List) tempList.get(control)) + "\t";
                tempSIns += ")";
            } else {
                tempSIns += tempList.get(control) + "\t";
            }

        }

        return tempSIns;
    }
}
