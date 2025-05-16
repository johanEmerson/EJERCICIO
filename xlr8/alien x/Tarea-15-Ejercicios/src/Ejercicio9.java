import java.util.*;

public class Ejercicio9 {

    private static final List<String> palabras = Arrays.asList(
            "murcielago", "computadora", "programacion", "java", "electroencefalografista", "desarrollo", "teclado", "pantalla", "raton"
    );

    private static final int MAX_INTENTOS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String palabraOriginal = palabras.get(random.nextInt(palabras.size())).toLowerCase();
        char[] palabraOculta = ocultarLetras(palabraOriginal);

        int intentosRestantes = MAX_INTENTOS;

        System.out.println("¡Bienvenido al juego de adivinar la palabra!");
        while (intentosRestantes > 0) {
            System.out.println("\nPalabra: " + new String(palabraOculta));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingresa una letra o la palabra completa: ");
            String entrada = scanner.nextLine().toLowerCase().trim();

            if (entrada.isEmpty()) {
                System.out.println("Entrada vacía, intenta de nuevo.");
                continue;
            }

            if (entrada.length() == 1) {

                char letra = entrada.charAt(0);
                if (!Character.isLetter(letra)) {
                    System.out.println("Por favor ingresa una letra válida.");
                    continue;
                }

                if (palabraOriginal.indexOf(letra) >= 0) {
                    boolean cambio = false;
                    for (int i = 0; i < palabraOriginal.length(); i++) {
                        if (palabraOriginal.charAt(i) == letra && palabraOculta[i] == '_') {
                            palabraOculta[i] = letra;
                            cambio = true;
                        }
                    }
                    if (cambio) {
                        System.out.println("¡Bien! La letra '" + letra + "' está en la palabra.");
                    } else {
                        System.out.println("La letra '" + letra + "' ya estaba descubierta.");
                    }
                } else {
                    intentosRestantes--;
                    System.out.println("La letra '" + letra + "' no está en la palabra.");
                }
            } else if (entrada.length() == palabraOriginal.length()) {
                // El usuario intenta adivinar la palabra completa
                if (entrada.equals(palabraOriginal)) {
                    System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraOriginal);
                    break;
                } else {
                    intentosRestantes--;
                    System.out.println("Palabra incorrecta.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa una letra o una palabra de longitud " + palabraOriginal.length());
            }

            if (new String(palabraOculta).equals(palabraOriginal)) {
                System.out.println("¡Felicidades! Has descubierto toda la palabra: " + palabraOriginal);
                break;
            }
        }

        if (intentosRestantes == 0) {
            System.out.println("\n¡Has perdido! La palabra era: " + palabraOriginal);
        }

        scanner.close();
    }
    private static char[] ocultarLetras(String palabra) {
        int longitud = palabra.length();
        int maxOcultas = (int) Math.floor(longitud * 0.6);

        char[] resultado = palabra.toCharArray();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < longitud; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);

        int ocultas = 0;
        for (int idx : indices) {
            if (ocultas >= maxOcultas) break;
            resultado[idx] = '_';
            ocultas++;
        }

        return resultado;
    }
}


