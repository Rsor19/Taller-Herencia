package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado {

    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad,
                          float salarioBase, CategoriaEmpleado categoria,
                          float descuentoSalud, float descuentoPension,
                          String cargo, int horasExtra,
                          float valorHoraExtra, float auxilioTransporte) {

        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

        if (horasExtra < 0)
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas.");
        if (valorHoraExtra < 0)
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo.");

        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase
             + calcularBonificacionCategoria()
             + (horasExtra * valorHoraExtra)
             + auxilioTransporte;
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
        return "--- Empleado de Planta ---\n" +
        String.format("Cargo              : %s%n", cargo)+
        String.format("Horas extra        : %d$%.2f%n", horasExtra, valorHoraExtra)+
        String.format("Auxilio transporte : $%.2f%n", auxilioTransporte)+
                "\n" +
        super.mostrarInformacion();
    }
 }
