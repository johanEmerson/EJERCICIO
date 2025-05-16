import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el rango máximo (entero positivo): ");
        int rangoMaximo = scanner.nextInt();

        if (rangoMaximo < 2) {
            System.out.println("El rango debe ser mayor o igual a 2.");
            return;
        }

        System.out.println("Pares de números primos gemelos en el rango:");
        for (int i = 2; i <= rangoMaximo - 2; i++) {
            if (esPrimo(i) && esPrimo(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }

    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}
