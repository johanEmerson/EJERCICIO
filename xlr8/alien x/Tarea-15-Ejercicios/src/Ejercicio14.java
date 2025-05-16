

    import java.util.Scanner;


    public class Ejercicio14 {



        public static class Vector2D {
            public double x, y;
            public Vector2D(double x, double y) {
                this.x = x; this.y = y;
            }
            public Vector2D sumar(Vector2D otro, double escalar) {
                return new Vector2D(this.x + otro.x * escalar, this.y + otro.y * escalar);
            }
            @Override
            public String toString() {
                return String.format("(%.4f, %.4f)", x, y);
            }
        }

        public static String calcularEncuentro(Vector2D p1, Vector2D v1, Vector2D p2, Vector2D v2) {
            double dx = p2.x - p1.x;
            double dy = p2.y - p1.y;
            double dvx = v1.x - v2.x;
            double dvy = v1.y - v2.y;

            final double EPS = 1e-9;

            if (Math.abs(dvx) < EPS && Math.abs(dvy) < EPS) {
                if (Math.abs(dx) < EPS && Math.abs(dy) < EPS) {
                    return "Los objetos ya están juntos en la posición " + p1 + " en t=0.";
                } else {
                    return "Los objetos se mueven con la misma velocidad y no se encontrarán.";
                }
            }

            Double tX = null, tY = null;

            if (Math.abs(dvx) > EPS) {
                tX = dx / dvx;
            } else {
                if (Math.abs(dx) > EPS) {
                    return "Los objetos no se encontrarán (trayectorias paralelas en X).";
                }
            }

            if (Math.abs(dvy) > EPS) {
                tY = dy / dvy;
            } else {
                if (Math.abs(dy) > EPS) {
                    return "Los objetos no se encontrarán (trayectorias paralelas en Y).";
                }
            }

            if (tX != null && tY != null) {
                if (Math.abs(tX - tY) > EPS || tX < 0) {
                    return "Los objetos no se encontrarán (tiempos diferentes o negativos).";
                }
                Vector2D punto = p1.sumar(v1, tX);
                return String.format("Los objetos se encuentran en %s tras %.4f unidades de tiempo.", punto, tX);
            }

            if (tX != null) {
                if (tX < 0) return "Los objetos no se encontrarán (tiempo negativo).";
                double y1 = p1.y + v1.y * tX;
                double y2 = p2.y + v2.y * tX;
                if (Math.abs(y1 - y2) < EPS) {
                    Vector2D punto = new Vector2D(p1.x + v1.x * tX, y1);
                    return String.format("Los objetos se encuentran en %s tras %.4f unidades de tiempo.", punto, tX);
                } else {
                    return "Los objetos no se encontrarán (no coinciden en Y en tiempo calculado).";
                }
            }

            if (tY != null) {
                if (tY < 0) return "Los objetos no se encontrarán (tiempo negativo).";
                double x1 = p1.x + v1.x * tY;
                double x2 = p2.x + v2.x * tY;
                if (Math.abs(x1 - x2) < EPS) {
                    Vector2D punto = new Vector2D(x1, p1.y + v1.y * tY);
                    return String.format("Los objetos se encuentran en %s tras %.4f unidades de tiempo.", punto, tY);
                } else {
                    return "Los objetos no se encontrarán (no coinciden en X en tiempo calculado).";
                }
            }

            return "No se puede determinar el punto de encuentro.";
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese la posición inicial del objeto 1 (x y):");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();

            System.out.println("Ingrese la velocidad del objeto 1 (vx vy):");
            double vx1 = scanner.nextDouble();
            double vy1 = scanner.nextDouble();

            System.out.println("Ingrese la posición inicial del objeto 2 (x y):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            System.out.println("Ingrese la velocidad del objeto 2 (vx vy):");
            double vx2 = scanner.nextDouble();
            double vy2 = scanner.nextDouble();

            Vector2D p1 = new Vector2D(x1, y1);
            Vector2D v1 = new Vector2D(vx1, vy1);
            Vector2D p2 = new Vector2D(x2, y2);
            Vector2D v2 = new Vector2D(vx2, vy2);

            String resultado = calcularEncuentro(p1, v1, p2, v2);
            System.out.println(resultado);

        }
    }
