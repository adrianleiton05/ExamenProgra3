package entidades;

import java.time.LocalDateTime;

public class Acceso {
    private String idUsuario;
    private LocalDateTime entrada;
    private LocalDateTime salida;

    public Acceso(String idUsuario, LocalDateTime entrada) {
        this.idUsuario = idUsuario;
        this.entrada = entrada;
        this.salida = null;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        String salidaStr = salida != null ? salida.toString() : "null";
        return idUsuario + "," + entrada.toString() + "," + salidaStr;
    }

    public static Acceso fromString(String linea) {
        String[] partes = linea.split(",");
        String idUsuario = partes[0];
        LocalDateTime entrada = LocalDateTime.parse(partes[1]);
        LocalDateTime salida = partes[2].equals("null") ? null : LocalDateTime.parse(partes[2]);
        Acceso acceso = new Acceso(idUsuario, entrada);
        acceso.setSalida(salida);
        return acceso;
    }
}