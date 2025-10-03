package Controlador;

import Modelo.Usuario;

public class SessionController {
    private Usuario usuarioActual;

    public void registrarUsuario(String username, String contraseña, String nombre) {
        if (username == null || username.isBlank() || contraseña == null || contraseña.isBlank() || nombre == null
                || nombre.isBlank()) {
            throw new IllegalArgumentException("Todos los datos son requeridos");
        }
        Usuario user = new Usuario(username, contraseña, nombre);
        this.usuarioActual = user;
    }

    public boolean iniciarSesion(String username, String contraseña) {
        if (usuarioActual == null)
            return false;
        if (usuarioActual.validarCredenciales(username, contraseña)) {
            return true;
        }
        return false;
    }

    public boolean hayUsuario() {
        return usuarioActual != null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }

    public String getNombreUsuario() {
        return hayUsuario() ? usuarioActual.getNombre() : "";
    }

    public void setNombreUsuario(String nuevoNombre) {
        if (!hayUsuario())
            throw new IllegalStateException("No hay usuario en sesión");
        usuarioActual.setNombre(nuevoNombre);
    }
}
