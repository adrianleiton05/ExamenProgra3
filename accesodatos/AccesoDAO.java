package accesodatos;

import entidades.Acceso;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class AccesoDAO {
    private static final String FILE_NAME = "accesos.txt";

    public void guardar(Acceso a) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(a.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar acceso: " + e.getMessage());
        }
    }

    public List<Acceso> listarTodos() {
        List<Acceso> accesos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                accesos.add(Acceso.fromString(linea));
            }
        } catch (IOException e) {
            System.err.println("Error al listar accesos: " + e.getMessage());
        }
        return accesos;
    }

    public void actualizarSalida(String idUsuario, LocalDateTime salida) {
        List<Acceso> accesos = listarTodos();
        for (Acceso a : accesos) {
            if (a.getIdUsuario().equals(idUsuario) && a.getSalida() == null) {
                a.setSalida(salida);
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Acceso a : accesos) {
                writer.write(a.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar salida: " + e.getMessage());
        }
    }
}