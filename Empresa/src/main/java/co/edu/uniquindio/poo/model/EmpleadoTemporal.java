package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado{
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension){
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
    }

    @Override
    public float calcularSalarioBruto() {
        return (diasTrabajados * valorDia)
        + calcularBonificacionCategoria();
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
    public String mostrarInformacion(){
        return "------Empleado Temporal-------" +
                String.format("Dias trabajados : %d", diasTrabajados)+
                String.format("Valor Día : %.2f%n", valorDia)+
                "\n" +
                super.mostrarInformacion();
    }


}
