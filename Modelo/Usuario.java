package Modelo;

public class Usuario {
    private String username;
    private String contraseña;
    private String nombre;

    public Usuario(String username, String contraseña, String nombre) {
        if (username == null || username.isBlank() ||
            contraseña == null || contraseña.isBlank() ||
            nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Se requieren datos.");
        }
        this.username = username;
        this.contraseña = contraseña;
        this.nombre = nombre;
    }

    public Usuario() {
        this.username = null;
        this.contraseña = null;
        this.nombre = "Invitado";
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Nuevo username no ingresado");
        }
        this.username = username;
    }
}
