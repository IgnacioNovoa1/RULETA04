package Controlador;

import Modelo.Ruleta;
import java.util.Objects;

public class RuletaController {
    private final Ruleta ruleta;
    private final SessionController session;

    public RuletaController(Ruleta ruleta, SessionController session) {
        this.ruleta = Objects.requireNonNull(ruleta);
        this.session = Objects.requireNonNull(session);
    }

    public Resultado jugar(TipoApuesta apuesta) {
        if (!session.hayUsuario())
            throw new IllegalStateException("No hay usuario autenticado");
        Resultado r = ruleta.girar(apuesta);
        session.getUsuarioActual().agregarResultado(r);
        return r;
    }

    public int getSaldoRuleta() {
        return ruleta.getSaldo();
    }

    public void depositarEnRuleta(int monto) {
        ruleta.depositar(monto);
    }
}
