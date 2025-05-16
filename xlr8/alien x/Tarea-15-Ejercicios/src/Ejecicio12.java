import java.util.Scanner;

public class Ejecicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número inicial de la cuenta atrás: ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese los segundos (enteros) entre cada número: ");
        int intervalo = scanner.nextInt();

        cuentaAtras(inicio, intervalo);
    }

    public static void cuentaAtras(int inicio, int intervalo) {
        if (inicio <= 0 || intervalo <= 0) {
            System.out.println("Ambos parámetros deben ser enteros positivos mayores que cero.");
            return;
        }

        try {
            for (int i = inicio; i >= 0; i--) {
                System.out.println(i);
                if (i > 0) {
                    Thread.sleep(intervalo * 1000); // Pausa en milisegundos
                }
            }
        } catch (InterruptedException e) {
            System.out.println("La cuenta atrás fue interrumpida.");
        }
    }
}
