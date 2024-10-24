package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;

public class Escritorio extends Mueble {

    private int numeroDePuertas;
    private boolean tieneCajones;

    /***CONSTRUCTORES*/

    public Escritorio(String nombre, String marca, String modelo, double precio, int stock, float peso, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo, int numeroDePuertas, boolean tieneCajones) {
        super(nombre, marca, modelo, precio, stock, peso, categoria, uso, material, capacidad, estilo);
        this.numeroDePuertas = numeroDePuertas;
        this.tieneCajones = tieneCajones;
    }

    public Escritorio() {
    }

    /***Getters and setters*/

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public Escritorio numeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
        return this;
    }

    public boolean isTieneCajones() {
        return tieneCajones;
    }

    public Escritorio tieneCajones(boolean tieneCajones) {
        this.tieneCajones = tieneCajones;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Numero de Puertas..........:" + numeroDePuertas);
        String mensaje = isTieneCajones() ? "Tiene cajones" : "No tiene cajones";
        System.out.println(mensaje);
        System.out.println("==============================================");

    }

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Numero de Puertas..........:" + numeroDePuertas);
        String mensaje = isTieneCajones() ? "Tiene cajones" : "No tiene cajones";
        System.out.println(mensaje);
        System.out.println("==============================================");

    }
}
