import java.util.*;

public class Ejercicio6 {

//BatallaPokemon


        private static final List<String> tiposValidos = Arrays.asList("Agua", "Fuego", "Planta", "Electrico");

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el tipo del Pokémon atacante (Agua, Fuego, Planta, Electrico):");
            String tipoAtacante = scanner.nextLine().trim();

            if (!tiposValidos.contains(tipoAtacante)) {
                System.out.println("Tipo atacante inválido.");
                scanner.close();
                return;
            }

            System.out.println("Ingrese el tipo del Pokémon defensor (Agua, Fuego, Planta, Electrico):");
            String tipoDefensor = scanner.nextLine().trim();

            if (!tiposValidos.contains(tipoDefensor)) {
                System.out.println("Tipo defensor inválido.");
                scanner.close();
                return;
            }

            System.out.println("Ingrese el valor de ataque (1 a 100):");
            int ataque = scanner.nextInt();
            if (ataque < 1 || ataque > 100) {
                System.out.println("Ataque fuera de rango.");
                scanner.close();
                return;
            }

            System.out.println("Ingrese el valor de defensa (1 a 100):");
            int defensa = scanner.nextInt();
            if (defensa < 1 || defensa > 100) {
                System.out.println("Defensa fuera de rango.");
                scanner.close();
                return;
            }

            double efectividad = obtenerEfectividad(tipoAtacante, tipoDefensor);
            double danio = 50 * ((double) ataque / defensa) * efectividad;

            System.out.printf("Daño causado: %.2f (Efectividad: %.1f)%n", danio, efectividad);

            scanner.close();
        }

        private static double obtenerEfectividad(String atacante, String defensor) {
            if (atacante.equals("Agua")) {
                if (defensor.equals("Fuego")) return 2.0;
                if (defensor.equals("Planta")) return 0.5;
            } else if (atacante.equals("Fuego")) {
                if (defensor.equals("Planta")) return 2.0;
                if (defensor.equals("Agua")) return 0.5;
            } else if (atacante.equals("Planta")) {
                if (defensor.equals("Agua")) return 2.0;
                if (defensor.equals("Fuego")) return 0.5;
            } else if (atacante.equals("Electrico")) {
                if (defensor.equals("Agua")) return 2.0;
                if (defensor.equals("Planta")) return 0.5;
            }
            return 1.0;
        }
    }
