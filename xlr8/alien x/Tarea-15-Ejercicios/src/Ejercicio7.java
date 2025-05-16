
import java.util.*;

public class Ejercicio7  {

    private static final Map<String, Integer> bondadosas = Map.of(
            "Pelosos", 1,
            "Sureños buenos", 2,
            "Enanos", 3,
            "Númenóreanos", 4,
            "Elfos", 5
    );

    private static final Map<String, Integer> malvadas = Map.of(
            "Sureños malos", 2,
            "Orcos", 2,
            "Goblins", 2,
            "Huargos", 3,
            "Trolls", 5
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ejército bondadoso: ingresa el número de integrantes para cada raza.");
        Map<String, Integer> ejercitoBien = pedirEjercito(scanner, bondadosas);

        System.out.println("\nEjército malvado: ingresa el número de integrantes para cada raza.");
        Map<String, Integer> ejercitoMal = pedirEjercito(scanner, malvadas);

        int fuerzaBien = calcularFuerza(ejercitoBien, bondadosas);
        int fuerzaMal = calcularFuerza(ejercitoMal, malvadas);

        System.out.printf("%nFuerza total ejército bondadoso: %d%n", fuerzaBien);
        System.out.printf("Fuerza total ejército malvado: %d%n", fuerzaMal);

        if (fuerzaBien > fuerzaMal) {
            System.out.println("¡Gana el bien!");
        } else if (fuerzaMal > fuerzaBien) {
            System.out.println("¡Gana el mal!");
        } else {
            System.out.println("Empate en la batalla.");
        }

    }

    private static Map<String, Integer> pedirEjercito(Scanner scanner, Map<String, Integer> razas) {
        Map<String, Integer> ejercito = new HashMap<>();
        for (String raza : razas.keySet()) {
            System.out.printf("Número de %s: ", raza);
            int cantidad = scanner.nextInt();
            if (cantidad < 0) {
                System.out.println("Cantidad inválida, se toma 0.");
                cantidad = 0;
            }
            ejercito.put(raza, cantidad);
        }
        return ejercito;
    }

    private static int calcularFuerza(Map<String, Integer> ejercito, Map<String, Integer> valores) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : ejercito.entrySet()) {
            String raza = entry.getKey();
            int cantidad = entry.getValue();
            int valor = valores.get(raza);
            total += cantidad * valor;
        }
        return total;
    }
}

