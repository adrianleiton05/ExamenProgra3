package presentacion;

import logicadenegocio.LaboratorioServicio;
import entidades.Usuario;
import entidades.Acceso;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LaboratorioServicio servicio = new LaboratorioServicio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Control de Acceso a Laboratorio ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Registrar entrada al laboratorio");
            System.out.println("5. Registrar salida del laboratorio");
            System.out.println("6. Ver historial de accesos de un usuario");
            System.out.println("7. Ver tiempo total en laboratorio de un usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Rol (Estudiante/Docente): ");
                        String rol = scanner.nextLine();
                        servicio.registrarUsuario(id, nombre, rol);
                        System.out.println("Usuario registrado exitosamente.");
                        break;
                    case 2:
                        List<Usuario> usuarios = servicio.listarUsuarios();
                        if (usuarios.isEmpty()) {
                            System.out.println("No hay usuarios registrados.");
                        } else {
                            for (Usuario u : usuarios) {
                                System.out.println(u.getId() + " - " + u.getNombre() + " (" + u.getRol() + ")");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("ID del usuario a eliminar: ");
                        String idEliminar = scanner.nextLine();
                        servicio.eliminarUsuario(idEliminar);
                        System.out.println("Usuario eliminado exitosamente.");
                        break;
                    case 4:
                        System.out.print("ID del usuario: ");
                        String idEntrada = scanner.nextLine();
                        servicio.registrarEntrada(idEntrada);
                        System.out.println("Entrada registrada.");
                        break;
                    case 5:
                        System.out.print("ID del usuario: ");
                        String idSalida = scanner.nextLine();
                        servicio.registrarSalida(idSalida);
                        System.out.println("Salida registrada.");
                        break;
                    case 6:
                        System.out.print("ID del usuario: ");
                        String idHistorial = scanner.nextLine();
                        List<Acceso> historial = servicio.obtenerHistorial(idHistorial);
                        if (historial.isEmpty()) {
                            System.out.println("No hay accesos registrados para este usuario.");
                        } else {
                            for (Acceso a : historial) {
                                System.out.println("Entrada: " + a.getEntrada() + ", Salida: " + (a.getSalida() != null ? a.getSalida() : "Activa"));
                            }
                        }
                        break;
                    case 7:
                        System.out.print("ID del usuario: ");
                        String idTiempo = scanner.nextLine();
                        long totalMin = servicio.calcularTiempoTotal(idTiempo);
                        long horas = totalMin / 60;
                        long minutos = totalMin % 60;
                        System.out.println("Tiempo total: " + horas + " horas y " + minutos + " minutos");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        } while (opcion != 0);

        scanner.close();
    }
}