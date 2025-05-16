
import java.util.Scanner;

public class Ejercicio4  {

    private static final char X = 'X';
    private static final char O = 'O';
    private static final char VACIO = ' ';
    private static char[][] tablero = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);

    public static String analizarMatriz(char[][] matriz) {

        if (matriz.length != 3 || matriz[0].length != 3 ||
                matriz[1].length != 3 || matriz[2].length != 3) {
            return "Nulo";
        }
        int contadorX = 0;
        int contadorO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == X) {
                    contadorX++;
                } else if (matriz[i][j] == O) {
                    contadorO++;
                } else if (matriz[i][j] != VACIO) {

                    return "Nulo";
                }
            }
        }

        if (Math.abs(contadorX - contadorO) > 1) {
            return "Nulo";
        }

        boolean victoriaX = hayVictoria(matriz, X);

        boolean victoriaO = hayVictoria(matriz, O);


        if (victoriaX && victoriaO) {
            return "O si han ganado los 2";
        } else if (victoriaX) {
            return "X";
        } else if (victoriaO) {
            return "O";
        } else if (contadorX + contadorO == 9) {
            return "Empate";
        } else {
            // El juego aún no ha terminado, pero lo consideramos empate para cumplir con los requisitos
            return "Empate";
        }
    }
    private static boolean hayVictoria(char[][] matriz, char jugador) {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == jugador && matriz[i][1] == jugador && matriz[i][2] == jugador) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (matriz[0][j] == jugador && matriz[1][j] == jugador && matriz[2][j] == jugador) {
                return true;
            }
        }

        if (matriz[0][0] == jugador && matriz[1][1] == jugador && matriz[2][2] == jugador) {
            return true;
        }
        if (matriz[0][2] == jugador && matriz[1][1] == jugador && matriz[2][0] == jugador) {
            return true;
        }

        return false;
    }

    private static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    private static void mostrarTablero() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -+-+-");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            inicializarTablero();
            boolean turnoX = true;
            String resultado = "";

            System.out.println("¡Bienvenido al juego de Michi (Tres en Raya)!");
            System.out.println("Formato de entrada: fila columna (ejemplo: 1 1 para el centro)");


            while (resultado.equals("")) {
                mostrarTablero();

                char jugadorActual = turnoX ? X : O;
                System.out.println("Turno de " + jugadorActual);


                int fila, columna;
                while (true) {
                    try {
                        System.out.print("Ingresa tu jugada (fila columna): ");
                        fila = scanner.nextInt();
                        columna = scanner.nextInt();


                        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                            System.out.println("Error: Posición fuera del tablero. Intenta de nuevo.");
                            continue;
                        }

                        if (tablero[fila][columna] != VACIO) {
                            System.out.println("Error: Casilla ocupada. Intenta de nuevo.");
                            continue;
                        }

                        break;
                    } catch (Exception e) {
                        System.out.println("Error: Entrada inválida. Usa formato: fila columna");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }
                tablero[fila][columna] = jugadorActual;

                resultado = analizarMatriz(tablero);

                if (resultado.equals("Empate") && !tableroLleno()) {
                    resultado = ""; // El juego aún no ha terminado
                    turnoX = !turnoX;
                }
            }
            mostrarTablero();

            switch (resultado) {
                case "X":
                    System.out.println("¡El jugador X ha ganado!");
                    break;
                case "O":
                    System.out.println("¡El jugador O ha ganado!");
                    break;
                case "Empate":
                    System.out.println("¡Es un empate!");
                    break;
                case "Nulo":
                    System.out.println("El juego es nulo (proporción incorrecta).");
                    break;
                case "O si han ganado los 2":
                    System.out.println("¡Ambos jugadores han ganado! (Esto no debería ocurrir en un juego normal)");
                    break;
            }
            System.out.print("\n¿Quieres jugar de nuevo? (s/n): ");
            scanner.nextLine(); // Limpiar buffer
            String respuesta = scanner.nextLine().toLowerCase();
            jugarDeNuevo = respuesta.equals("s") || respuesta.equals("si");
        }

        System.out.println("¡Gracias por jugar al Michi!");
        scanner.close();
    }
    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == VACIO) {
                    return false;
                }
            }
        }
        return true;
    }
}


