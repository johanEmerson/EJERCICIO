import java.util.Scanner;
import java.util.regex.Pattern;

public class Ejercicio13 {

    private static final Pattern PATRON_NUMERO = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
    private static final String OPERADORES = "+-*/%";

    public static boolean esExpresionValida(String expresion) {
        if (expresion == null || expresion.trim().isEmpty()) {
            return false;
        }

        String[] tokens = expresion.trim().split("\\s+");

        if (tokens.length < 3) {
            return false;
        }

        if (tokens.length % 2 == 0) {
            return false;
        }

        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                if (!PATRON_NUMERO.matcher(tokens[i]).matches()) {
                    return false;
                }
            } else {
                if (tokens[i].length() != 1 || OPERADORES.indexOf(tokens[i].charAt(0)) == -1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa una expresión matemática (números y operadores separados por espacios):");
        String expresion = scanner.nextLine();

        if (esExpresionValida(expresion)) {
            System.out.println("La expresión es válida.");
        } else {
            System.out.println("La expresión NO es válida.");
        }

        scanner.close();
    }
}

