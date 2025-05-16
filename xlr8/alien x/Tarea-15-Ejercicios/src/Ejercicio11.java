import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        // Código Konami: ↑↑↓↓←→←→BA
        int[] codigoKonami = {38, 38, 40, 40, 37, 39, 37, 39, 66, 65};
        int indice = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el Código Konami usando las teclas de flecha y BA:");

        while (true) {
            int entrada = leerTecla(scanner);

            if (entrada == codigoKonami[indice]) {
                indice++;
                if (indice == codigoKonami.length) {
                    System.out.println("¡Código Konami introducido correctamente!");
                    break;
                }
            } else {
                indice = 0; // Reinicia si la secuencia no coincide
            }
        }
    }

    private static int leerTecla(Scanner scanner) {
        String tecla = scanner.nextLine().toUpperCase();
        return switch (tecla) {
            case "ARRIBA" -> 38;
            case "ABAJO" -> 40;
            case "IZQUIERDA" -> 37;
            case "DERECHA" -> 39;
            case "B" -> 66;
            case "A" -> 65;
            default -> -1; // Entrada inválida
        };
    }
}
