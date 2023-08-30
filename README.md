# ApiRest en Java con SpringBoot
## ¿En que consiste la App?  
Este desarrollo facilita el procesamiento de operaciones financieras con tarjetas de crédito.
## ¿Que solución cumple? 
Según tarjeta e importe permite calcular las tasas de servicio 
## Caracteristicas
- Informando marca de tarjeta e importe calcula el interés  
- Se emplea varias capas en la arquitectura (Controller, UseCase, Entity y Exception)
- Si la tarjeta esta mal nombrada ó el importe es menos de 1000 envia un mensaje correspondiente por consola según sea el error.

### Requerimientos para su uso:  
- URL: http://localhost:8080/api/tasas
- Method: Post
- Body: 
{
    "marcaTarjeta": "VISA",
    "importe": 500
}


