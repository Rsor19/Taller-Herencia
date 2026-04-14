package co.edu.uniquindio.poo.model;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
public class Empresa {
    private String nombreEmpresa;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (buscarEmpleado(empleado.getDocumento()) == null) {
            listaEmpleados.add(empleado);
        }
    }

    public Empleado buscarEmpleado(String documento) {
        return listaEmpleados.stream()
                .filter(e -> e.getDocumento().equals(documento))
                .findAny()
                .orElse(null);
    }

    public String mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            return "No hay empleados registrados.";
        }

        return listaEmpleados.stream()
                .map(e -> e.mostrarInformacion())
                .collect(Collectors.joining("\n\n"));
    }

    public Empleado empleadoMayorSalario() {
        return listaEmpleados.stream()
                .max(Comparator.comparingDouble(Empleado::calcularSalarioNeto))
                .orElse(null);
    }

    public float calcularNominaTotal() {
        return (float) listaEmpleados.stream()
                .mapToDouble(Empleado::calcularSalarioNeto)
                .sum();
    }

    public String mostrarResumenesPago() {
        return listaEmpleados.stream()
                .map(e -> e.generarResumenPago().toString())
                .collect(Collectors.joining("\n\n"));
    }
}
