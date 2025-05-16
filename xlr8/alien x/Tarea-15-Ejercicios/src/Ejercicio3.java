import java.util.Scanner;

public class Ejercicio3 {

    public static boolean evaluarCarrera(String[] movimientos, String pista) {
        if (movimientos.length != pista.length()) {
            System.out.println("Error: Los movimientos y la pista deben tener la misma longitud");
            return false;
        }


        StringBuilder pistaResultado = new StringBuilder(pista);
        boolean superada = true;


        for (int i = 0; i < movimientos.length; i++) {
            char seccionPista = pista.charAt(i);
            String movimiento = movimientos[i];


            if (seccionPista == '_' && movimiento.equals("run")) {
            } else if (seccionPista == '|' && movimiento.equals("jump")) {

            } else if (seccionPista == '_' && movimiento.equals("jump")) {

                pistaResultado.setCharAt(i, 'x');
                superada = false;
            } else if (seccionPista == '|' && movimiento.equals("run")) {

                pistaResultado.setCharAt(i, '/');
                superada = false;
            }
        }
        System.out.println("Pista original: " + pista);
        System.out.println("Pista final:    " + pistaResultado.toString());
        System.out.println("Carrera " + (superada ? "superada" : "no superada"));

        return superada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Ingresa la pista (usa '_' para suelo y '|' para valla):");
            String pista = scanner.nextLine();

            for (char c : pista.toCharArray()) {
                if (c != '_' && c != '|') {
                    System.out.println("Error: La pista solo puede contener '_' (suelo) o '|' (valla)");
                    return;
                }
            }


            String[] movimientos = new String[pista.length()];


            System.out.println("Para cada sección de la pista, escribe 'run' o 'jump':");

            for (int i = 0; i < pista.length(); i++) {
                char seccion = pista.charAt(i);
                System.out.print("Sección " + (i+1) + " [" + seccion + "]: ");
                String movimiento = scanner.nextLine().toLowerCase();

                if (!movimiento.equals("run") && !movimiento.equals("jump")) {
                    System.out.println("Error: Solo puedes escribir 'run' o 'jump'");
                    return;
                }

                movimientos[i] = movimiento;
            }


            System.out.println("\nResultado de la carrera:");
            evaluarCarrera(movimientos, pista);

        } finally {

        }
    }
}



