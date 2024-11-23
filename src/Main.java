import Menus.*;
import enums.*;
import models.ArrayList.AdministradorList;
import models.Excepciones.NoHayStock;
import models.Herramienta.HerramientaElectrica;
import models.Herramienta.HerramientaManual;
import models.Herramienta.Insumo;
import models.Hogar.Bazar;
import models.Hogar.Escritorio;
import models.Hogar.Mueble;
import models.Hogar.Sillon;
import models.Juguete.JuegoDeMesa;
import models.Juguete.JugueteElectrico;
import models.Juguete.JugueteManual;
import models.Producto;
import models.Ropa.Buzo;
import models.Ropa.Calzado;
import models.Ropa.Pantalon;
import models.Ropa.Remera;
import models.Tecnologia.*;
import models.Usuario.Cliente;

import javax.swing.*;
import java.util.Scanner;

import static json.JsonCliente.deserializarCliente;
import static json.JsonCliente.serializarCliente;

import static json.JsonProductos.serializarProductos;
import static json.JsonProductos.deserializarProductos;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int opcion;
    public static void main(String[] args) {

        // Inicializar el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AdministradorList<Producto> t = new AdministradorList<>();
            //Direccion s = new Direccion();
            Cliente r = new Cliente("Richard","Moreno", "w323232", Genero.MASCULINO, "23232323", "s", 3000000);

            //CARGA RANDOM

            HerramientaElectrica herramientaElectricaRandom = HerramientaElectrica.herramientaElectricaRandom();
            HerramientaManual herramientaManualRandom = HerramientaManual.herramientaManualRandom();
            Insumo insumoRandom = Insumo.insumoRandom();
            Bazar bazarRandom = Bazar.bazarRandom();
            Escritorio escritorioRandom = Escritorio.escritorioRandom();
            Mueble muebleRandom = Mueble.muebleRandom();
            Sillon silloRandom = Sillon.sillonRandom();
            JuegoDeMesa juegoDeMesa = JuegoDeMesa.juegoDeMesaRandom();
            JugueteElectrico jugueteElectrico = JugueteElectrico.jugueteElectricoRandom();
            JugueteManual jugueteManual = JugueteManual.jugueteManualRandom();
            Buzo buzo = Buzo.buzoRandom();
            Calzado calzado = Calzado.calzadoRandom();
            Pantalon pantalon = Pantalon.pantalonRandom();
            Remera remera = Remera.remeraRandom();
            Celular celular = Celular.celularRandom();
            PC_Escritorio pcEscritorio = PC_Escritorio.PC_EscritorioRandom();
            Portatil portatil = Portatil.portatilRandom();
            Televisor televisor = Televisor.televisorRandom();



/*
            HerramientaElectrica taladro = new HerramientaElectrica("Taladro", "CDP001", 10, 1500.0, "Bosch", "X200", 18.0f, true);
            HerramientaElectrica sierraCircular = new HerramientaElectrica("Sierra Circular", "CDP002", 5, 3200.0, "Makita", "CS600", 20.0f, false);
            HerramientaElectrica amoladora = new HerramientaElectrica("Amoladora", "CDP003", 7, 2100.0, "DeWalt", "DWE402", 12.0f, true);
            HerramientaElectrica destornillador = new HerramientaElectrica("Destornillador Eléctrico", "CDP004", 15, 850.0, "Black & Decker", "BDX01", 4.8f, true);
            HerramientaElectrica lijadora = new HerramientaElectrica("Lijadora Orbital", "CDP005", 12, 1800.0, "Ryobi", "RS300", 6.0f, false);
            Remera e = new Remera("Coca", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera d = new Remera("Fernet", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera n = new Remera("Pistola", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera b = new Remera("Cuchillo", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera u = new Remera("F-17", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);
            Remera q = new Remera("Agua mineral", "213123", 21, 2121, "123213", "32131", "312312", Genero.UNISEX, TalleRemera.L, "dwadawd", TipoDeRemera.MANGA3_4, TalleRemera.M);

            t.add(sierraCircular);
            t.add(amoladora);
            t.add(lijadora);
            t.add(destornillador);
            t.add(e);
            t.add(d);
            t.add(n);
            t.add(b);
            t.add(u);
            t.add(q);
*/
            // Suponiendo que `t` es una lista de tipo adecuado (por ejemplo, List<Object> o alguna otra tipo específico):
            t.add(herramientaElectricaRandom);
            t.add(herramientaManualRandom);
            t.add(insumoRandom);
            t.add(bazarRandom);
            t.add(escritorioRandom);
            t.add(muebleRandom);
            t.add(silloRandom);
            t.add(juegoDeMesa);
            t.add(jugueteElectrico);
            t.add(jugueteManual);
            t.add(buzo);
            t.add(calzado);
            t.add(pantalon);
            t.add(remera);
            t.add(celular);
            t.add(pcEscritorio);
            t.add(portatil);
            t.add(televisor);

            //MenuCliente2 j = new MenuCliente2(t,r);
            MenuPpal menuPpal = new MenuPpal(t, r);

            r.imprimirCliente();


            System.out.println("La opcion es " + menuPpal.getOpcion());

            //menuPpal.mostrar();
            //j.mostrar();
            AdministradorList<Producto> productos = new AdministradorList<>();
            productos.cargarProductosRandom2(5);
            productos.show1();


            serializarProductos(productos);

        });
    }

}