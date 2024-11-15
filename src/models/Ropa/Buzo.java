package models.Ropa;

import enums.Genero;
import enums.TalleRemera;

public class Buzo extends Ropa {
    private boolean tieneCapucha;
    private boolean tieneCierre;
    private boolean tieneBolsillos;
    private boolean tieneEstampado;
    private boolean impermeable;

    /**Constructores*/
    public Buzo(String nombre, String cdp, int stock, double precio, String marca, String modelo, String color, Genero genero, TalleRemera talle, String material, boolean tieneCapucha, boolean tieneCierre, boolean tieneBolsillos, boolean tieneEstampado, boolean impermeable) {
        super(nombre, cdp, stock, precio, marca, modelo, color, genero, talle, material);
        this.tieneCapucha = tieneCapucha;
        this.tieneCierre = tieneCierre;
        this.tieneBolsillos = tieneBolsillos;
        this.tieneEstampado = tieneEstampado;
        this.impermeable = impermeable;
    }

    /**Getters y Setters*/

    public boolean isTieneCapucha() {
        return tieneCapucha;
    }
    public Buzo tieneCapucha(boolean tieneCapucha) {
        this.tieneCapucha = tieneCapucha;
        return this;
    }
    public boolean isTieneCierre() {
        return tieneCierre;
    }
    public Buzo tieneCierre(boolean tieneCierre) {
        this.tieneCierre = tieneCierre;
        return this;
    }
    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }
    public Buzo tieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
        return this;
    }
    public boolean isTieneEstampado() {
        return tieneEstampado;
    }
    public Buzo tieneEstampado(boolean tieneEstampado) {
        this.tieneEstampado = tieneEstampado;
        return this;
    }
    public boolean isImpermeable() {
        return impermeable;
    }
    public Buzo impermeable(boolean impermeable) {
        this.impermeable = impermeable;
        return this;
    }


    /**Imprimir*/
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Capucha:...................: " + tieneCapucha);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("Bolsillos:.................: " + tieneBolsillos);
        System.out.println("Estampado:.................: " + tieneEstampado);
        System.out.println("Impermeable:...............: " + impermeable);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Capucha:...................: " + tieneCapucha);
        System.out.println("Cierre:....................: " + tieneCierre);
        System.out.println("Bolsillos:.................: " + tieneBolsillos);
        System.out.println("Estampado:.................: " + tieneEstampado);
        System.out.println("Impermeable:...............: " + impermeable);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Buzo{" +
                "tieneCapucha=" + tieneCapucha +
                ", tieneCierre=" + tieneCierre +
                ", tieneBolsillos=" + tieneBolsillos +
                ", tieneEstampado=" + tieneEstampado +
                ", impermeable=" + impermeable +
                '}';
    }
}
