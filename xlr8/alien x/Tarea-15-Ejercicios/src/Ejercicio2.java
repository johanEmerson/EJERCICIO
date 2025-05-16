import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio2 {


    public static int diasEntreFechas(String fecha1, String fecha2) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);


        Date date1 = formato.parse(fecha1);
        Date date2 = formato.parse(fecha2);

        long diferenciaMs = Math.abs(date1.getTime() - date2.getTime());


        return (int) TimeUnit.DAYS.convert(diferenciaMs, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Calculadora de días entre fechas");
            System.out.println("Formato de fecha: dd/MM/yyyy (ejemplo: 01/01/2023)");

            System.out.print("Ingresa la primera fecha: ");
            String fecha1 = scanner.nextLine();

            System.out.print("Ingresa la segunda fecha: ");
            String fecha2 = scanner.nextLine();


            int dias = diasEntreFechas(fecha1, fecha2);


            System.out.println("Hay " + dias + " días entre " + fecha1 + " y " + fecha2);

        } catch (ParseException e) {
            System.out.println("Error: Fecha inválida. " + e.getMessage());
            System.out.println("Asegúrate de usar el formato dd/MM/yyyy correctamente.");

        }
    }
}