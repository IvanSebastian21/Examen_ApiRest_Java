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

## Ejercicio 3: PL/SQL
- Resultado: 10. Recuperará un máximo de 10 registros en la colección "fname" utilizando la cláusula "LIMIT"

## Ejercicio 4: PL/SQL
- La función no compilará correctamente debido a la falta de una declaración RETURN para devolver el valor calculado. Debería verse algo como esto:


Create or Replace function Get_salary(P_Emp_id Number) Return Number As 
   L_salary Number;
Begin
   Select Salary into L_salary from Employees where employee_id = P_Emp_id;
   Return L_salary; --> Se añade la declaración RETURN para devolver el valor.
End Get_salary;
