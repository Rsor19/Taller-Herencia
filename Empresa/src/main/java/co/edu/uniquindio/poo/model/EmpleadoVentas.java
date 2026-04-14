package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado{
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }
    public float calcularComisionVentas() {
        return totalVentas * porcentajeComision / 100;
    }
    @Override
    public float calcularSalarioBruto() {
        return salarioBase
                + calcularBonificacionCategoria()
                + calcularComisionVentas();
    }
    @Override
    public float calcularDescuentos(){
        float bruto = calcularSalarioBruto();
        return (bruto * descuentoSalud) + (bruto * descuentoPension);
    }
    @Override
    public ResumenPago generarResumenPago(){
        float bruto = calcularSalarioBruto();
        float descuentos = calcularDescuentos();
        float neto = calcularSalarioNeto();

        return new ResumenPago(
                documento,
                nombre,
                categoria,
                bruto,
                descuentos,
                neto);
    }
    @Override
    public String mostrarInformacion() {
        return "--- Empleado de Ventas---\n" +
                String.format("Total Ventas : %.2f%n", totalVentas)+
                String.format("Porcentaje de Comisión : $%.2f%%%n " , porcentajeComision) +
                "\n" +
                super.mostrarInformacion();
    }
}
