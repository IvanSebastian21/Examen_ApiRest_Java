package java_backend_apirest.exception;

    public class OperacionInvalidaException extends RuntimeException {
        public OperacionInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
