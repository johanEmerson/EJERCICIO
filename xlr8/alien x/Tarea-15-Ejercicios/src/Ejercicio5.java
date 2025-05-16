
import java.util.*;

    public class Ejercicio5 {

        private static final Map<Integer, Producto> productos = new HashMap<>();
        private static final List<Integer> monedasSoportadas = Arrays.asList(5, 10, 50, 100, 200);

        static {
            productos.put(1, new Producto("Agua", 15));
            productos.put(2, new Producto("Refresco", 20));
            productos.put(3, new Producto("Snack", 30));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Bienvenido a la máquina expendedora");
            System.out.println("Productos disponibles:");
            for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
                System.out.printf("%d - %s: %d céntimos%n", entry.getKey(), entry.getValue().nombre, entry.getValue().precio);
            }

            System.out.print("Seleccione el número del producto: ");
            int seleccion = scanner.nextInt();

            if (!productos.containsKey(seleccion)) {
                System.out.println("Producto no existe. Se devuelve el dinero.");
                scanner.close();
                return;
            }

            Producto producto = productos.get(seleccion);
            System.out.printf("El producto seleccionado es %s y cuesta %d céntimos.%n", producto.nombre, producto.precio);

            System.out.println("Ingrese las monedas para pagar (monedas soportadas: 5, 10, 50, 100, 200).");
            System.out.println("Ingrese las monedas separadas por espacios y presione Enter:");

            scanner.nextLine(); // Limpiar buffer
            String lineaMonedas = scanner.nextLine();
            String[] monedasStr = lineaMonedas.trim().split("\\s+");
            List<Integer> monedasIngresadas = new ArrayList<>();

            for (String mStr : monedasStr) {
                try {
                    int moneda = Integer.parseInt(mStr);
                    if (!monedasSoportadas.contains(moneda)) {
                        System.out.printf("Moneda %d no soportada. Se devuelve todo el dinero.%n", moneda);
                        scanner.close();
                        return;
                    }
                    monedasIngresadas.add(moneda);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Se devuelve todo el dinero.");
                    scanner.close();
                    return;
                }
            }

            int totalIngresado = monedasIngresadas.stream().mapToInt(Integer::intValue).sum();

            if (totalIngresado < producto.precio) {
                System.out.println("Dinero insuficiente. Se devuelve todo el dinero.");
                System.out.println("Dinero devuelto: " + monedasIngresadas);
                scanner.close();
                return;
            }

            int cambio = totalIngresado - producto.precio;
            List<Integer> monedasCambio = calcularCambio(cambio);

            System.out.printf("Producto entregado: %s%n", producto.nombre);
            if (cambio == 0) {
                System.out.println("No hay dinero de vuelta.");
            } else {
                System.out.println("Dinero de vuelta (en céntimos): " + monedasCambio);
            }

            scanner.close();
        }

        private static List<Integer> calcularCambio(int cambio) {
            List<Integer> cambioMonedas = new ArrayList<>();
            List<Integer> monedasOrdenadas = new ArrayList<>(monedasSoportadas);
            monedasOrdenadas.sort(Collections.reverseOrder());

            for (int moneda : monedasOrdenadas) {
                while (cambio >= moneda) {
                    cambio -= moneda;
                    cambioMonedas.add(moneda);
                }
            }
            return cambioMonedas;
        }

        private static class Producto {
            String nombre;
            int precio;

            Producto(String nombre, int precio) {
                this.nombre = nombre;
                this.precio = precio;
            }
        }
    }
