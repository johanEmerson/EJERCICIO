import java.util.Scanner;
import java.util.Random;

public class Ejercicio15 {

    public static void simularClima(double tempInicial, double probLluviaInicial, int dias) {
        Random random = new Random();
        double temperatura = tempInicial;
        double probLluvia = probLluviaInicial;

        double tempMax = temperatura;
        double tempMin = temperatura;
        int diasLluvia = 0;

        System.out.println("Día\tTemperatura\tProb. Lluvia (%)\t¿Llueve?");
        for (int dia = 1; dia <= dias; dia++) {

            boolean llueve = random.nextDouble() * 100 < probLluvia;

            // Mostrar datos del día
            System.out.printf("%d\t%.1f°C\t\t%.1f%%\t\t%s%n",
                    dia, temperatura, probLluvia, llueve ? "Sí" : "No");


            if (llueve) {
                diasLluvia++;
            }


            if (temperatura > tempMax) tempMax = temperatura;
            if (temperatura < tempMin) tempMin = temperatura;


            if (temperatura > 25) {
                probLluvia = Math.min(100, probLluvia * 1.20);
            } else if (temperatura < 5) {
                probLluvia = Math.max(0, probLluvia * 0.80);
            }

            if (llueve) {
                temperatura -= 1;
            }

            if (random.nextDouble() < 0.10) {
                if (random.nextBoolean()) {
                    temperatura += 2;
                } else {
                    temperatura -= 2;
                }
            }
        }

        System.out.println("\nResumen del periodo:");
        System.out.printf("Temperatura máxima: %.1f°C%n", tempMax);
        System.out.printf("Temperatura mínima: %.1f°C%n", tempMin);
        System.out.printf("Días con lluvia: %d de %d%n", diasLluvia, dias);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la temperatura inicial (°C): ");
        double tempInicial = scanner.nextDouble();

        System.out.print("Introduce la probabilidad inicial de lluvia (0-100%): ");
        double probLluviaInicial = scanner.nextDouble();
        if (probLluviaInicial < 0) probLluviaInicial = 0;
        if (probLluviaInicial > 100) probLluviaInicial = 100;

        System.out.print("Introduce el número de días para la predicción: ");
        int dias = scanner.nextInt();
        if (dias <= 0) {
            System.out.println("El número de días debe ser mayor que 0.");
            scanner.close();
            return;
        }

        System.out.println("\nSimulación de condiciones climáticas:\n");
        simularClima(tempInicial, probLluviaInicial, dias);


    }
}

