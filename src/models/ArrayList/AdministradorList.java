package models.ArrayList;

import models.Producto;
import models.Ropa.Ropa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class AdministradorList <T extends Producto> {
    List<T> productosList;

    /**Constructores*/
    public AdministradorList(){
        this.productosList = new ArrayList<>();
    }

    public void get(int i){
        this.productosList.get(i);
    }

    public List<T> getProductos() {
        return this.productosList;
    }

    public AdministradorList(int dim){
        this.productosList = new ArrayList<>(dim);
    }


    /**Agregar producto*/
    public void add(T p){
        productosList.add(p);
    }

    /**Agregar producto modificando stock*/
    public void add(T p, int stock){
        int newStock = p.getStock() + stock;
        p.stock(newStock);
        productosList.add(p);
    }


    /**Eliminar producto*/
    public void remove(T p){
        productosList.remove(p);
    }

    /**Eliminar producto modificando stock*/
    public void remove(Producto p, int stock){
        if(p.getStock() - stock >= 0){
            int newStock = p.getStock() - stock;
            p.stock(newStock);
        }else{
            System.out.println("No hay el suficiente stock disponible para eliminar el producto");
        }
    }

    public int size(){
        return this.productosList.size();
    }

    public void removeTernario(T p, int stock){
        String mensaje = (p.getStock() - stock >= 0) ? "Stock actualizado" : "No hay stock suficiente disponible para eliminar el producto";
        System.out.println(mensaje);
    }



    public void show1(){
        for(Producto p : productosList){
            p.imprimirCliente();
        }
    }

    /**Mostrar producto segun nombre*/

    public void show(String nombre){
        for(Producto producto : productosList){
            if(producto.getNombre().equals(nombre)){
                System.out.println(producto);
            }
        }
    }

    public Producto show3(Producto p){
        for(Producto producto : productosList){
            if(producto.equals(p)){
                System.out.println(producto);
            }
        }
        return p;
    }

    public String[] getNombresProductos() {
        String[] nombres = new String[this.productosList.size()];
        for (int i = 0; i < this.productosList.size(); i++) {
            nombres[i] = this.productosList.get(i).getNombre(); // Suponiendo que Producto tiene un método getNombre()
        }
        return nombres;
    }

    // Método para buscar un producto por su nombre
    public Producto  buscarProductoPorNombre(String nombre) {
        for (Producto t : this.productosList) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null; // Retorna null si no encuentra el producto
    }

    public void mostrarProductosClases(String clase){
        for(Producto producto : productosList){
            if(producto.getClass().getSimpleName().equalsIgnoreCase(clase)){
                producto.imprimirCliente();
            }
        }
    }

    public String[] mostrarProductosClases2(String clase) {
        List<String> productosCoincidentes = new ArrayList<>();

        for (int i = 0; i < productosList.size(); i++) {

            if (productosList.get(i).getClass().getSimpleName().equalsIgnoreCase(clase)) {
                productosCoincidentes.add(productosList.get(i).toString());
            }
        }


        return productosCoincidentes.toArray(new String[0]);
    }

    public String[] obtenerNombresClases() {
        Set<String> clases = new HashSet<>();

        // Iterar sobre el arreglo de objetos y obtener el nombre de cada clase
        for (int i = 0; i < productosList.size(); i++) {
            clases.add(this.productosList.get(i).getClass().getSimpleName());  // Almacenar el nombre de la clase
        }

        String[] nombresClases = clases.toArray(new String[0]);
        return nombresClases;
    }

    public String[] crearArregloDeNombres() {
        // Crear un arreglo de nombres
        String[] nombresArray = productosList.stream()
                .map(Producto::getNombre)
                .toArray(String[]::new);

        // Imprimir el nombre de las clases de los elementos
        for (int i = 0; i < productosList.size(); i++) {
            nombresArray[i] = this.productosList.get(i).getClass().getSimpleName();
        }

        return nombresArray;
    }
    /**Mostrar producto segun marca*/
    public void showMarca(String marca){
        for(Producto producto : productosList){
            if(producto.getMarca().equals(marca)){
                System.out.println(producto);
            }
        }
    }

    /**Mostrar producto segun id ESTO TIENE QUE SER POR CODIGO DE PRODUCTO*/
    public Producto search(String id){
        Producto p = null;
        for(Producto producto : productosList){
            if(producto.getId().equals(id)){
                p = producto;
                return p;
            }
        }
        return p;
    }

    /**Buscar producto por marca y nombre*/
    public Producto search(String marca, String nombre){
        Producto p = null;
        for(Producto producto : productosList){
            if(producto.getMarca().equalsIgnoreCase(marca) && producto.getNombre().equalsIgnoreCase(nombre)){
                p = producto;
                return p;
            }
        }
        return p;
    }

    /**Editar los atributos de un producto y que se guarde el nuevo producto*/
    public void edit(Producto p, String nombre, String marca, String modelo, double precio, int stock){
        p.nombre(nombre);
        p.marca(marca);
        p.modelo(modelo);
        p.precio(precio);
        p.stock(stock);
    }

    /**Comparar segun el comparable de Producto*/
    public void sort(){
        Collections.sort(productosList);
    }

    public void mostrareFrame (JTextArea textArea){
        for (Producto producto : this.productosList) {
            textArea.append(producto + "\n");
        }
    }

    public void recorrerAdmin(JPanel panel){
        for (Producto producto : this.productosList) {
            JButton botonProducto = new JButton(producto.getNombre()+ " Stock=" + producto.getStock());
            botonProducto.setSize(20,10);
            botonProducto.addActionListener(e -> editAction());
            panel.add(botonProducto);
        }
    }

    private void editAction(){
        JFrame editFrame = new JFrame("Editar Producto");
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setLayout(new GridLayout());
        editFrame.setLocationRelativeTo(null);
        editFrame.setVisible(true);
        editFrame.setSize(400,175);
        editFrame.setResizable(false);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editFrame.add(panelBotones);


        JButton btnEditarNombre = new JButton("Editar Nombre");
        btnEditarNombre.setSize(20,10);
        //btnEditarNombre.addActionListener(e -> );
        panelBotones.add(btnEditarNombre);

        JButton btnEditarMarca = new JButton("Editar Marca");
        btnEditarMarca.setSize(20,10);
        panelBotones.add(btnEditarMarca);

        JButton btnEditarModelo = new JButton("Editar Modelo");
        btnEditarModelo.setSize(20,10);
        panelBotones.add(btnEditarModelo);

        JButton btnEditarPrecio = new JButton("Editar Precio");
        btnEditarPrecio.setSize(20,10);
        panelBotones.add(btnEditarPrecio);

        JButton btnEditarStock = new JButton("Editar Stock");
        btnEditarStock.setSize(20,10);
        panelBotones.add(btnEditarStock);


    }

    private void editarNombreFrame(){
        JFrame editNombreFrame = new JFrame("Editar Nombre");
        editNombreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editNombreFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editNombreFrame.setLocationRelativeTo(null);
        editNombreFrame.setVisible(true);
        editNombreFrame.setSize(200,175);
        editNombreFrame.setResizable(false);

        JTextField txtNombre = new JTextField("Ingrese nuevo nombre");
    }
}



