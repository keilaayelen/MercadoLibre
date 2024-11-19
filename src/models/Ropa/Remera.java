package models.Ropa;

import enums.Genero;
import enums.TalleRemera;
import enums.TipoDeRemera;

public class Remera extends Ropa {
    private TipoDeRemera tipoDeRemera;
    private TalleRemera talle;


    /**Constructores*/
    public Remera(String nombre, String cdp, int stock, double precio, String marca, String modelo, String color, Genero genero, TalleRemera talle, String material, TipoDeRemera tipoDeRemera, TalleRemera talle1) {
        super(nombre, cdp, stock, precio, marca, modelo, color, genero, talle, material);
        this.tipoDeRemera = tipoDeRemera;
        this.talle = talle1;
    }

    /**Getters y Setters*/
    public TipoDeRemera getTipoDeRemera() {
        return tipoDeRemera;
    }
    public Remera tipoDeRemera(TipoDeRemera tipoDeRemera) {
        this.tipoDeRemera = tipoDeRemera;
        return this;
    }
    public TalleRemera getTalle() {
        return talle;
    }
    public Remera talle(TalleRemera talle) {
        this.talle = talle;
        return this;
    }

    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de remera:...........: " + tipoDeRemera);
        System.out.println("Talle:....................: " + talle);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Tipo de remera:...........: " + tipoDeRemera);
        System.out.println("Talle:....................: " + talle);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Nombre:........................:" +getNombre() +
                "\nMarca:.........................: " + getMarca() +
                "\nModelo:.........................: " + getModelo() +
                "\nPrecio:.........................: " + getPrecio() +
                "\nColor...........................: " + getColor() +
                "\nGenero..........................: " +getGenero() +
                "\nTalle...........................: " + getTalle() +
                "\nMaterial........................: " + getMaterial() +
                "\nTipo de remera:.................: " + getTipoDeRemera()+
                "\n==============================================\n\n";
    }
}
