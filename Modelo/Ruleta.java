package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private final List<Resultado> resultados = new ArrayList<>();
    private final Random random = new Random();
    private int saldo;

    public Ruleta() {
        this.saldo = 0;
    }

    public Ruleta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int nuevoSaldo) {
        this.saldo += nuevoSaldo;
    }

    public void depositar(int monto) {
        setSaldo(monto);
    }

    public Resultado girar(TipoApuesta apuesta, int montoApuesta) {
        int numero = random.nextInt(37) + 1;
        String color;
        if (esRojo(numero) == true) {
            color = "ROJO";
        } else {
            color = "NEGRO";
        }

        boolean acierto = switch (apuesta) {
            case ROJO -> color.equals("ROJO");
            case NEGRO -> color.equals("NEGRO");
            case PAR -> (numero != 0) && (numero % 2 == 0);
            case IMPAR -> (numero % 2 != 0);
        };
        if (acierto == true) {
            setSaldo(montoApuesta * 2);
        } else {
            setSaldo(-montoApuesta);
        }

        Resultado r = new Resultado(numero, color, acierto, montoApuesta, apuesta);
        resultados.add(r);
        return r;
    }

    private boolean esRojo(int numero) {
        return (numero % 2 != 0);
    }

    public List<Resultado> getResultados() {
        return Collections.unmodifiableList(resultados);
    }
}
