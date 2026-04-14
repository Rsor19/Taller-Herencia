package co.edu.uniquindio.poo.model;

public record ResumenPago(
        String documento,
        String nombre,
        CategoriaEmpleado tipoEmpleado,
        float salarioBruto,
        float descuentos,
        float salarioNeto
){

}
