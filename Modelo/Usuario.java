package Modelo;

public class Usuario {
    private String username;
    private String contraseña;
    private String nombre;

    public Usuario(String username, String contraseña, String nombre) {
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
        this.username = username;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
