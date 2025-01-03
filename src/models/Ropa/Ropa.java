package models.Ropa;

import enums.Genero;
import enums.TalleRemera;
import models.Producto;

public abstract class Ropa extends Producto {


    private String color;
    private Genero genero;
    private TalleRemera talle;
    private String material;



    /**Constructor*/

    public Ropa(String nombre, String cdp, int stock, double precio, String marca, String modelo, String color, Genero genero, TalleRemera talle, String material) {
        super(nombre, cdp, stock, precio, marca, modelo);
        this.color = color;
        this.genero = genero;
        this.talle = talle;
        this.material = material;
    }

    public Ropa() {
    }

    /**Getters y Setters*/
    public String getColor() {
        return color;
    }

    public Ropa color(String color) {
        this.color = color;
        return this;
    }

    public Genero getGenero() {
        return genero;
    }
    public Ropa genero(Genero genero) {
        this.genero = genero;
        return this;
    }
    public TalleRemera getTalle() {
        return talle;
    }
    public Ropa talle(TalleRemera talle) {
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


    /**Imprimir*/
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Color......................: " + getColor());
        System.out.println("Genero.....................: " + getGenero());
        System.out.println("Talle......................: " + getTalle());
        System.out.println("Material...................: " + getMaterial());
    }

    /**
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
        return super.toString() +
                "\nColor:..........................: " + color +
                "\nGenero:.........................: " + genero +
                "\nTalle:..........................: " + talle +
                "\nMaterial:.......................: " + material +
                "\n==============================================\n\n";
    }
}
