package models.Ropa;

import enums.GeneroRopa;
import models.Producto;

import java.util.Comparator;
import java.util.List;

public abstract class Ropa extends Producto {


    private String color;
    private GeneroRopa genero;
    private float talle;
    private String material;


    /*Constructor*/
    public Ropa(String nombre, String marca, String modelo, double precio, int stock, String color, GeneroRopa genero, float talle, String material) {
        super(nombre, marca, modelo, precio, stock);
        this.color = color;
        this.genero = genero;
        this.talle = talle;
        this.material = material;
    }

    public Ropa() {
    }

    /*Getters y Setters*/
    public String getColor() {
        return color;
    }

    public Ropa color(String color) {
        this.color = color;
        return this;
    }

    public GeneroRopa getGenero() {
        return genero;
    }

    public Ropa genero(GeneroRopa genero) {
        this.genero = genero;
        return this;
    }

    public float getTalle() {
        return talle;
    }

    public Ropa talle(float talle) {
        this.talle = talle;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public Ropa material(String material) {
        this.material = material;
        return this;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Color......................: " + getColor());
        System.out.println("Genero.....................: " + getGenero());
        System.out.println("Talle......................: " + getTalle());
        System.out.println("Material...................: " + getMaterial());
    }

    /*
    CODIGO PARA REALIZAR COMPARACIONES

    public void sort(List<Ropa>list) {
        Comparator<Ropa> comparator = Comparator.comparing(Ropa::getTalle);
        list.sort(comparator);
    }*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Color......................: " + getColor());
        System.out.println("Genero.....................: " + getGenero());
        System.out.println("Talle......................: " + getTalle());
        System.out.println("Material...................: " + getMaterial());
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "color='" + color + '\'' +
                ", genero=" + genero +
                ", talle=" + talle +
                ", material='" + material + '\'' +
                "} " + super.toString();
    }
}