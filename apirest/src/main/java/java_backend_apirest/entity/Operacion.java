package java_backend_apirest.entity;

import java_backend_apirest.exception.OperacionInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase que representa una operación con tarjeta de crédito.
 * Contiene información sobre la marca de la tarjeta y el importe de la operación.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Operacion {
        private String marcaTarjeta;
        private double importe;

        /**
         * Verifica si la operación es válida según el requisito de consumo mínimo.
         *
         * @return `true` si la operación es válida, `false` en caso contrario.
         * @throws OperacionInvalidaException Cuando la operación no cumple con el requisito de consumo mínimo de 1000 pesos.
         */

        public boolean esOperacionValida() {
                if (importe < 1000) {
                        throw new OperacionInvalidaException("La operación no cumple con el requisito de consumo mínimo de 1000 pesos.");
                }
                return true;
        }

}
