package logicadenegocio;

import accesodatos.UsuarioDAO;
import accesodatos.AccesoDAO;
import entidades.Usuario;
import entidades.Acceso;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LaboratorioServicio {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private AccesoDAO accesoDAO = new AccesoDAO();

    public void registrarUsuario(String id, String nombre, String rol) {
        if (id == null || id.trim().isEmpty() || nombre == null || nombre.trim().isEmpty() || rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos deben estar llenos");
        }
        if (!rol.equalsIgnoreCase("Estudiante") && !rol.equalsIgnoreCase("Docente")) {
            throw new IllegalArgumentException("Rol inválido. Use: Estudiante o Docente.");
        }
        if (usuarioDAO.buscarPorId(id).isPresent()) {
            throw new IllegalArgumentException("El ID ya existe");
        }
        Usuario u = new Usuario(id, nombre, rol);
        usuarioDAO.guardar(u);
    }

    public void eliminarUsuario(String id) {
        if (!usuarioDAO.buscarPorId(id).isPresent()) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        usuarioDAO.eliminar(id);
    }

    public void registrarEntrada(String idUsuario) {
        if (!usuarioDAO.buscarPorId(idUsuario).isPresent()) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        List<Acceso> accesos = accesoDAO.listarTodos();
        boolean hasActive = accesos.stream().anyMatch(a -> a.getIdUsuario().equals(idUsuario) && a.getSalida() == null);
        if (hasActive) {
            throw new IllegalArgumentException("El usuario ya está dentro del laboratorio.");
        }
        Acceso a = new Acceso(idUsuario, LocalDateTime.now());
        accesoDAO.guardar(a);
    }

    public void registrarSalida(String idUsuario) {
        List<Acceso> accesos = accesoDAO.listarTodos();
        Acceso active = accesos.stream().filter(a -> a.getIdUsuario().equals(idUsuario) && a.getSalida() == null).findFirst().orElse(null);
        if (active == null) {
            throw new IllegalArgumentException("El usuario no tiene una entrada registrada.");
        }
        accesoDAO.actualizarSalida(idUsuario, LocalDateTime.now());
    }

    public List<Acceso> obtenerHistorial(String idUsuario) {
        return accesoDAO.listarTodos().stream().filter(a -> a.getIdUsuario().equals(idUsuario)).collect(Collectors.toList());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    public long calcularTiempoTotal(String idUsuario) {
        List<Acceso> accesos = obtenerHistorial(idUsuario);
        long totalMinutos = 0;
        for (Acceso a : accesos) {
            if (a.getSalida() != null) {
                Duration duration = Duration.between(a.getEntrada(), a.getSalida());
                totalMinutos += duration.toMinutes();
            }
        }
        return totalMinutos;
    }
}