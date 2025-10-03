package Modelo;

public class Resultado {
    private final int numero;
    private final String color;
    private final boolean acierto;
    private final double ganancia;
    private final TipoApuesta tipoApuesta;

    public Resultado(int numero, String color, boolean acierto, double ganancia, TipoApuesta tipoApuesta) {
        this.numero = numero;
        this.color = color;
        this.acierto = acierto;
        this.ganancia = ganancia;
        this.tipoApuesta = tipoApuesta;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public double getGanancia() {
        return ganancia;
    }

    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    @Override
    public String toString() {
        return String.format("N:%d | %s | Acierto:%b | Ganancia: %.2f | Apuesta:%s",
                numero, color, acierto, ganancia, tipoApuesta);
    }
}
