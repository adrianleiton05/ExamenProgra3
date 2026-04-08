package accesodatos;

import entidades.Usuario;
import java.io.*;
import java.util.*;

public class UsuarioDAO {
    private static final String FILE_NAME = "usuarios.txt";

    public void guardar(Usuario u) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(u.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                usuarios.add(Usuario.fromString(linea));
            }
        } catch (IOException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void eliminar(String id) {
        List<Usuario> usuarios = listarTodos();
        usuarios.removeIf(u -> u.getId().equals(id));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Usuario u : usuarios) {
                writer.write(u.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public Optional<Usuario> buscarPorId(String id) {
        List<Usuario> usuarios = listarTodos();
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}