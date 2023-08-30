package java_backend_apirest.UseCase;

import java_backend_apirest.exception.MarcaTarjetaInvalidaException;

import java.time.LocalDate;

/**
 * Clase para calcular la tasa de servicio de acuerdo a la marca de una tarjeta de crédito.
 * Proporciona métodos estáticos para realizar cálculos basados en la marca de la tarjeta.
 */
public class CalculadoraTasa {

    /**
     * Calcula la tasa de servicio según la marca de la tarjeta.
     *
     * @param marcaTarjeta La marca de la tarjeta de crédito (p. ej., "VISA", "NARA", "AMEX").
     * @return La tasa de servicio calculada como un número decimal.
     * @throws MarcaTarjetaInvalidaException Cuando se proporciona una marca de tarjeta no válida.
     */
    public static double calcularTasa(String marcaTarjeta) {
        // Obtiene la fecha actual.
        LocalDate today = LocalDate.now();

        // Extrae el año, el mes y el día del mes de la fecha actual.
        int year = today.getYear();
        int month = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();

        // Calcula la tasa de servicio en función de la marca de la tarjeta.
        if ("VISA".equalsIgnoreCase(marcaTarjeta)) {
            return (double) year / month;
        } else if ("NARA".equalsIgnoreCase(marcaTarjeta)) {
            return dayOfMonth * 0.5;
        } else if ("AMEX".equalsIgnoreCase(marcaTarjeta)) {
            return month * 0.1;
        } else {
            // Lanza una excepción si se proporciona una marca de tarjeta no válida.
            throw new MarcaTarjetaInvalidaException("Marca de tarjeta no válida: " + marcaTarjeta);
        }
    }
}