package models.Hogar;

import enums.CategoriasHogar;
import enums.EstiloMueble;
import enums.UsoHogar;
import mocks.Mock;

import java.util.Random;

import static mocks.Mock.*;

public class Mueble extends Hogar{
    private int capacidad;
    private EstiloMueble estilo;

    public Mueble(String nombre, String cdp, int stock, double precio, String marca, String modelo, CategoriasHogar categoria, UsoHogar uso, String material, int capacidad, EstiloMueble estilo) {
        super(nombre, cdp, stock, precio, marca, modelo, categoria, uso, material);
        this.capacidad = capacidad;
        this.estilo = estilo;
    }

    public Mueble() {
    }

    /**Getter and setters**/

    public int getCapacidad() {
        return capacidad;
    }

    public Mueble capacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public EstiloMueble getEstilo() {
        return estilo;
    }

    public Mueble estilo(EstiloMueble estilo) {
        this.estilo = estilo;
        return this;
    }

    /***IMPRIMIR*/

    @Override
    public void imprimirCliente() {
        super.imprimirCliente();
        System.out.println("Capacidad:.................:" + capacidad);
        System.out.println("Estilo:....................:" + estilo);

    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Capacidad:.................:" + capacidad);
        System.out.println("Estilo:....................:" + estilo);

    }

    public static Mueble muebleRandom(){
        Mueble mueble = (Mueble) new Mueble()
                .capacidad((int) (Math.random() * 4))
                .estilo(EstiloMueble.OFICINA)
                .stock(Mock.getStock())
                .precio(Mock.getPrecio())
                .marca(Mock.getMarcaBazar())
                .modelo(Mock.getModeloBazar())
                .nombre("Mueble");
        mueble.categoria(CategoriasHogar.MUEBLES);
        mueble.uso(UsoHogar.ORGANIZAR);
        mueble.material(Mock.getMaterialMuebles());
        return mueble;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCapacidad:......................: " + capacidad +
                "\nEstilo:.........................: " + estilo +
                "\n==============================================\n\n";
    }
}
