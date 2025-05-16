import java.time.*;
import java.util.*;

public class Ejercicio8 {

    private static final Map<Integer, String> regalos = Map.ofEntries(
            Map.entry(1, "Libro: Git y GitHub desde cero"),
            Map.entry(2, "Suscripción MetalCode Pro"),
            Map.entry(3, "Libro: Entiende la tecnología"),
            Map.entry(4, "Curso: Dominando JavaScript"),
            Map.entry(5, "Libro: Código Sostenible"),
            Map.entry(6, "Licencia de JetBrains"),
            Map.entry(7, "Curso: Ultimate Python"),
            Map.entry(8, "Libro: Aprender a programar con C#"),
            Map.entry(9, "Libro: Git y GitHub desde cero"),
            Map.entry(10, "Suscripción MetalCode Pro"),
            Map.entry(11, "Curso: AppCademy"),
            Map.entry(12, "Acceso: Hack4U"),
            Map.entry(13, "Libro: El Programador Pragmático"),
            Map.entry(14, "Suscripción MetalCode"),
            Map.entry(15, "Sticker MetalCode"),
            Map.entry(16, "Libro: Git y GitHub desde cero"),
            Map.entry(17, "Suscripción MetalCode Pro"),
            Map.entry(18, "Libro: No todo es programar"),
            Map.entry(19, "Libro: Clean JavaScript"),
            Map.entry(20, "Libro: Patrones de diseño"),
            Map.entry(21, "Curso intensivo de Python"),
            Map.entry(22, "Acceso a plataforma de cursos"),
            Map.entry(23, "Libro: Git y GitHub desde cero"),
            Map.entry(24, "Suscripción MetalCode Pro")
    );

    private static final LocalDateTime INICIO = LocalDateTime.of(2022, 12, 1, 0, 0, 0);
    private static final LocalDateTime FIN = LocalDateTime.of(2022, 12, 24, 23, 59, 59);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número de día (1-24): ");
        int dia = scanner.nextInt();

        if (dia < 1 || dia > 24) {
            System.out.println("Día inválido. Debe estar entre 1 y 24.");
            scanner.close();
            return;
        }

        LocalTime horaActual = LocalTime.now();
        LocalDateTime fechaConsulta;


        try {
            fechaConsulta = LocalDateTime.of(2022, 12, dia, horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond());
        } catch (DateTimeException e) {
            System.out.println("Día inválido para diciembre.");

            return;
        }

        String resultado = obtenerInfoAdviento(fechaConsulta);
        System.out.println(resultado);


    }

    public static String obtenerInfoAdviento(LocalDateTime fechaConsulta) {
        if (fechaConsulta.isBefore(INICIO)) {
            Duration duracion = Duration.between(fechaConsulta, INICIO);
            return formatearDuracion("Faltan", duracion, "para que comience el calendario de aDEViento.");
        } else if (fechaConsulta.isAfter(FIN)) {
            Duration duracion = Duration.between(FIN, fechaConsulta);
            return formatearDuracion("El calendario de aDEViento terminó hace", duracion, ".");
        } else {
            int dia = fechaConsulta.getDayOfMonth();
            String regalo = regalos.getOrDefault(dia, "Regalo sorpresa");
            LocalDateTime finDia = LocalDateTime.of(2022, 12, dia, 23, 59, 59);
            Duration restante = Duration.between(fechaConsulta, finDia);
            return String.format(
                    "Regalo del día %d: %s. Quedan %d horas, %d minutos y %d segundos para que finalice el sorteo de este día.",
                    dia,
                    regalo,
                    restante.toHoursPart(),
                    restante.toMinutesPart(),
                    restante.toSecondsPart()
            );
        }
    }

    private static String formatearDuracion(String prefijo, Duration duracion, String sufijo) {
        long dias = duracion.toDays();
        long horas = duracion.toHoursPart();
        long minutos = duracion.toMinutesPart();
        return String.format("%s %d días, %d horas y %d minutos %s", prefijo, dias, horas, minutos, sufijo);
    }
}
