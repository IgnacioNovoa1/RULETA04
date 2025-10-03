package Modelo;

public class Ruleta {
    private double saldo;

    public Ruleta(String saldo) {
        try {
            this.saldo = Double.parseDouble(saldo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dato no válido: saldo debe ser numérico");
        }
    }
    public Ruleta(){
        this.saldo = 0.0;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(String saldo) {
        try {
            this.saldo = Double.parseDouble(saldo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dato no válido: saldo debe ser numérico");
        }
    }
    private String depositar(String monto){
        System.out.println("Ingresa un munto a depositar: ");
        setSaldo(monto);
        return "Tu nuevo saldo es: " + monto;

    }

}

