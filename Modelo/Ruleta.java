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
        if (saldoInicial < 0){
            saldoInicial = 0;
            this.saldo = saldoInicial;
        } else {
            this.saldo = saldoInicial;
        }
    }

    public int getSaldo(){
        return saldo;
    }
    public void setSaldo(int nuevoSaldo){
        this.saldo = nuevoSaldo;
    }

    public void depositar(int monto){
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto debe ser positivo");
            setSaldo(monto);
        } else {
            setSaldo(monto);
        }
    }

    public Resultado girar(TipoApuesta apuesta) {
        int numero = random.nextInt(37); // 0..36
        String color = (numero == 0) ? "VERDE" : (esRojo(numero) ? "ROJO" : "NEGRO");

        boolean acierto = switch (apuesta) {
            case ROJO -> color.equals("ROJO");
            case NEGRO -> color.equals("NEGRO");
            case PAR -> (numero != 0) && (numero % 2 == 0);
            case IMPAR -> (numero % 2 != 0);
        };

        double ganancia = acierto ? 1000.0 : -100.0;

        ajustarSaldo((int) -ganancia); 

        Resultado r = new Resultado(numero, color, acierto, ganancia, apuesta);
        resultados.add(r);
        return r;
    }

    private boolean esRojo(int numero) {
        if (numero == 0) return false;
        return (numero % 2 != 0);
    }

    public List<Resultado> getResultados() {
        return Collections.unmodifiableList(resultados);
    }
}
