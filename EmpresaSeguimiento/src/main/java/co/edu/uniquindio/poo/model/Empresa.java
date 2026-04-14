package co.edu.uniquindio.poo.model;
import java.time.LocalTime;
import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private LocalTime horaEntradaEmpresa;
    private ArrayList<Empleado>listaEmpleados;

    public Empresa(String nombre,LocalTime horaEntradaEmpresa) {
        this.nombre = nombre;
        this.horaEntradaEmpresa = horaEntradaEmpresa;
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Empleado buscarEmpleado(String cedula){
        for(Empleado e : listaEmpleados){
            if(e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }

    public void agregarEmpleado(Empleado empleado){
        if(empleado != null){
            for(Empleado e : listaEmpleados){
                if(e.getCedula().equals(empleado.getCedula())){
                    System.out.println("El empleado ya existe");
                    return;
                }
            }
            listaEmpleados.add(empleado);
        }
    }

    public ArrayList<Empleado> consultarEmpleadosTarde(){
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleadoAux = listaEmpleados.get(i);
            if (empleadoAux.llegoTarde(horaEntradaEmpresa)) {
                resultado.add(empleadoAux);
            }
        }
        return resultado;
    }
}
