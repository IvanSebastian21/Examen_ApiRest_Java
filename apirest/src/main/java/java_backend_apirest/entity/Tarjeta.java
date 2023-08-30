package java_backend_apirest.entity;

import java_backend_apirest.exception.OperacionInvalidaException;
import java_backend_apirest.exception.TarjetaInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
/**
 * Clase que representa una tarjeta de crédito.
 * Contiene información sobre la marca, número, titular y fecha de vencimiento de la tarjeta.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Tarjeta {
    private String marca;
    private String numero;
    private String cardholder;
    private LocalDate fechaVencimiento;

    /**
     * Verifica si la tarjeta es válida según la fecha de vencimiento.
     *
     * @return `true` si la tarjeta es válida, `false` en caso contrario.
     * @throws TarjetaInvalidaException Cuando la fecha de vencimiento de la tarjeta es menor o igual a la fecha actual.
     */
    public boolean esTarjetaValida() {
        LocalDate today = LocalDate.now();
        if (!fechaVencimiento.isAfter(today)) {
            throw new TarjetaInvalidaException("La tarjeta no es válida debido a la fecha de vencimiento.");
        }
        return true;
    }
}
