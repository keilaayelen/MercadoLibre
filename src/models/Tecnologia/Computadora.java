package models.Tecnologia;

import enums.SOComputadora;

public class Computadora extends Tecnologia{
    private SOComputadora so;
    private String procesador;
    private int ram;
    private int capacidad;



    /**Constructores*/
    public Computadora(String nombre, String marca, String modelo, double precio, int stock, float peso, String color, int anio, SOComputadora so, String procesador, int ram, int capacidad) {
        super(nombre, marca, modelo, precio, stock, peso, color, anio);
        this.so = so;
        this.procesador = procesador;
        this.ram = ram;
        this.capacidad = capacidad;
    }

    public Computadora() {
    }


    /**Getters y Setters*/
    public SOComputadora getSO() {
        return so;
    }
    public Computadora SO(SOComputadora SO) {
        this.so = so;
        return this;
    }
    public String getProcesador() {
        return procesador;
    }
    public Computadora procesador(String procesador) {
        this.procesador = procesador;
        return this;
    }
    public int getRam() {
        return ram;
    }
    public Computadora ram(int ram) {
        this.ram = ram;
        return this;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public Computadora capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }



    /**Imprimir*/

    public void imprimir() {
        super.imprimir();
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("RAM........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");



    }
    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Sistema Operativo:.........: " + so);
        System.out.println("Procesador.................: " + procesador);
        System.out.println("RAM........................: " + ram);
        System.out.println("Capacidad..................: " + capacidad);
        System.out.println("==============================================");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "so=" + so +
                ", procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", capacidad=" + capacidad +
                '}';
    }
}
