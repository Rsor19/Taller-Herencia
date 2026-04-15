package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Mi Empresa");
        int opcion;

        do {

            try {

                String menu = """
                        --- MENÚ ---
                        1. Agregar empleado de planta
                        2. Agregar empleado de ventas
                        3. Agregar empleado temporal
                        4. Mostrar todos los empleados
                        5. Buscar empleado por documento
                        6. Mostrar empleado con mayor salario neto
                        7. Mostrar nómina total
                        8. Mostrar resumen de pagos
                        9. Salir
                        """;

                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String documento = JOptionPane.showInputDialog("Documento:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                        int opcionCategoria = Integer.parseInt(
                                JOptionPane.showInputDialog("Categoría (1=Junior, 2=Semi Senior, 3=Senior):")
                        );

                        CategoriaEmpleado categoria;

                        switch (opcionCategoria) {
                            case 1 -> categoria = CategoriaEmpleado.JUNIOR;
                            case 2 -> categoria = CategoriaEmpleado.SEMI_SENIOR;
                            case 3 -> categoria = CategoriaEmpleado.SENIOR;
                            default -> throw new IllegalArgumentException("Categoría inválida");
                        }
                        String cargo = JOptionPane.showInputDialog("Cargo:");
                        int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("Horas extra:"));
                        float valorHoraExtra = Float.parseFloat(JOptionPane.showInputDialog("Valor hora extra:"));
                        float auxilio = Float.parseFloat(JOptionPane.showInputDialog("Auxilio transporte:"));
                        float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de salud de el empleado: "));
                        float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de salud de el empleado: "));

                        EmpleadoPlanta e = new EmpleadoPlanta(
                                nombre,
                                documento,
                                edad,
                                salario,
                                categoria,
                                descuentoSalud,
                                descuentoPension,
                                cargo,
                                horasExtra,
                                valorHoraExtra,
                                auxilio
                        );

                        empresa.agregarEmpleado(e);
                    }

                    case 2 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String documento = JOptionPane.showInputDialog("Documento:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
                        float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de salud de el empleado: "));
                        float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de pension de el empleado: "));
                        int opcionCategoria = Integer.parseInt(
                                JOptionPane.showInputDialog("Categoría (1=Junior, 2=Semi Senior, 3=Senior):")
                        );

                        CategoriaEmpleado categoria;

                        switch (opcionCategoria) {
                            case 1 -> categoria = CategoriaEmpleado.JUNIOR;
                            case 2 -> categoria = CategoriaEmpleado.SEMI_SENIOR;
                            case 3 -> categoria = CategoriaEmpleado.SENIOR;
                            default -> throw new IllegalArgumentException("Categoría inválida");
                        }
                        float ventas = Float.parseFloat(JOptionPane.showInputDialog("Total ventas:"));
                        float comision = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje comisión:"));

                        EmpleadoVentas e = new EmpleadoVentas(
                                nombre,
                                documento,
                                edad,
                                salario,
                                categoria,
                                descuentoSalud,
                                descuentoPension,
                                ventas,
                                comision
                        );

                        empresa.agregarEmpleado(e);
                    }

                    case 3 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre: ");
                        String documento = JOptionPane.showInputDialog("Documento: ");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad: "));
                        float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario base: "));
                        int opcionCategoria = Integer.parseInt(
                                JOptionPane.showInputDialog("Categoría (1=Junior, 2=Semi Senior, 3=Senior):")
                        );

                        CategoriaEmpleado categoria;

                        switch (opcionCategoria) {
                            case 1 -> categoria = CategoriaEmpleado.JUNIOR;
                            case 2 -> categoria = CategoriaEmpleado.SEMI_SENIOR;
                            case 3 -> categoria = CategoriaEmpleado.SENIOR;
                            default -> throw new IllegalArgumentException("Categoría inválida");
                        }
                        float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de salud de el empleado: "));
                        float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento de pension de el empleado: "));
                        int diasTrabajados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los días trabajados del empleado temporal: "));
                        float valorDia = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de los días trabajdos: "));
                        EmpleadoTemporal e = new EmpleadoTemporal(
                                nombre, documento, edad, salario,
                                categoria,
                                descuentoSalud,
                                descuentoPension,
                                diasTrabajados,
                                valorDia
                        );

                        empresa.agregarEmpleado(e);
                    }

                    case 4 -> JOptionPane.showMessageDialog(null, empresa.mostrarEmpleados());

                    case 5 -> {
                        String doc = JOptionPane.showInputDialog("Documento a buscar:");
                        Empleado e = empresa.buscarEmpleado(doc);

                        if (e != null) {
                            JOptionPane.showMessageDialog(null, e.mostrarInformacion());
                        } else {
                            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                        }
                    }

                    case 6 -> {
                        Empleado e = empresa.empleadoMayorSalario();
                        if (e != null) {
                            JOptionPane.showMessageDialog(null, e.mostrarInformacion());
                        }
                    }

                    case 7 -> {
                        float total = empresa.calcularNominaTotal();
                        JOptionPane.showMessageDialog(null, "Nómina total: $" + total);
                    }

                    case 8 -> JOptionPane.showMessageDialog(null, empresa.mostrarResumenesPago());

                    case 9 -> JOptionPane.showMessageDialog(null, "Saliendo...");

                    default -> JOptionPane.showMessageDialog(null, "Opción inválida");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido");
                opcion = -1; // evita que el programa termine por error
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 9);

    }
}