package java_backend_apirest.controller;

import java_backend_apirest.entity.Operacion;
import java_backend_apirest.exception.MarcaTarjetaInvalidaException;
import java_backend_apirest.exception.OperacionInvalidaException;
import java_backend_apirest.UseCase.CalculadoraTasa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para calcular tasas de operaciones con tarjetas de crédito.
 * Esta clase proporciona endpoints para consultar la tasa de una operación.
 */
@RestController
@RequestMapping("/api/tasas")
public class TasaController {

    /**
     * Calcula la tasa de una operación y la devuelve en formato JSON.
     *
     * @param operacion La operación de la que se calculará la tasa.
     * @return ResponseEntity con la tasa calculada en formato JSON.
     * @throws OperacionInvalidaException Cuando la operación no cumple con el requisito de consumo mínimo de 1000 pesos.
     * @throws MarcaTarjetaInvalidaException Cuando se proporciona una marca de tarjeta no válida.
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> consultarTasa(@RequestBody Operacion operacion) {
        try {
            operacion.esOperacionValida();
            double tasa = CalculadoraTasa.calcularTasa(operacion.getMarcaTarjeta());
            double resultado = tasa * operacion.getImporte();
            Map<String, String> response = new HashMap<>();
            response.put("tasa", String.valueOf(resultado));
            return ResponseEntity.ok(response);
        } catch (OperacionInvalidaException | MarcaTarjetaInvalidaException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}

