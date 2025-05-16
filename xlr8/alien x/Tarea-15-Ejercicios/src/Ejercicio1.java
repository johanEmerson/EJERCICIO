public class Ejercicio1 {
    public static void main(String[] args) {

        long[] fibonacci = new long[50];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < 50; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        System.out.println("Los 50 primeros números de la sucesión de Fibonacci son:");
        for (int i = 0; i < 50; i++) {
            System.out.print(fibonacci[i]);

            if (i < 49) {
                System.out.print(", ");
            }
        }
    }
}
