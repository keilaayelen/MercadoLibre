package Menus;

import models.ArrayList.AdministradorList;
import models.Producto;
import models.Usuario.Cliente;
import models.ArrayList.CartMap;  // Importa la clase CartMap

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MenuCliente2 extends JFrame {

    // Simular las listas de productos y carrito
    private AdministradorList productos;
    private Cliente cliente;
    private CartMap carrito;  // Usa CartMap en lugar de la lista de carrito

    public MenuCliente2(AdministradorList productos, Cliente cliente) {
        this.productos = productos; // Inicializar productos
        this.cliente = cliente;     // Inicializar cliente
        this.carrito = new CartMap();  // Inicializar el carrito como un CartMap

        // Resto del código para configurar el JFrame principal...
        JFrame frame = new JFrame("Menu Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Menu Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10)); // Ahora hay 4 botones

        JButton btnVerProductos = new JButton("Ver Productos");
        btnVerProductos.addActionListener(e -> verProductos());

        JButton btnVerCarrito = new JButton("Ver Carrito");
        btnVerCarrito.addActionListener(e -> verCarrito());

        JButton btnVerHistorial = new JButton("Ver Historial de Compras");
        btnVerHistorial.addActionListener(e -> verHistorial());

        JButton btnComprarCarrito = new JButton("Comprar Carrito");
        btnComprarCarrito.addActionListener(e -> comprarCarrito());

        panelBotones.add(btnVerProductos);
        panelBotones.add(btnVerCarrito);
        panelBotones.add(btnVerHistorial);
        panelBotones.add(btnComprarCarrito); // Agregado el botón para comprar el carrito

        frame.add(panelBotones, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para mostrar los productos y permitir añadirlos al carrito
    private void verProductos() {
        // Crear el JFrame para "Ver Productos"
        JFrame frameProductos = new JFrame("Ver Productos");
        frameProductos.setSize(400, 300);
        frameProductos.setLayout(new BorderLayout());

        // Crear un área con los productos y un JScrollPane
        JTextArea textAreaProductos = new JTextArea();
        textAreaProductos.setEditable(false);

        this.productos.mostrareFrame(textAreaProductos);

        JScrollPane scrollPane = new JScrollPane(textAreaProductos);
        frameProductos.add(scrollPane, BorderLayout.CENTER);

        // Botón para añadir productos al carrito
        JButton btnAgregarCarrito = new JButton("Añadir Producto al Carrito");
        btnAgregarCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreProducto = JOptionPane.showInputDialog(
                        frameProductos,
                        "Ingrese el nombre del producto a añadir:",
                        "Añadir Producto",
                        JOptionPane.PLAIN_MESSAGE
                );
                Producto p = productos.buscarProductoPorNombre(nombreProducto);
                if (p != null) {
                    String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad:");
                    int cantidad = Integer.parseInt(cantidadStr);
                    try {
                        carrito.agregarAlCarrito(p, cantidad);  // Usando CartMap
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(frameProductos, "Producto añadido al carrito.");
                } else {
                    JOptionPane.showMessageDialog(frameProductos, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frameProductos.add(btnAgregarCarrito, BorderLayout.SOUTH);

        frameProductos.setLocationRelativeTo(null);
        frameProductos.setVisible(true);
    }

    // Método para mostrar el carrito
    private void verCarrito() {
        // Crear el JFrame para "Ver Carrito"
        JFrame frameCarrito = new JFrame("Carrito de Cliente");
        frameCarrito.setSize(400, 300);
        frameCarrito.setLayout(new BorderLayout());

        // Crear un área con los productos del carrito y un JScrollPane
        JTextArea textAreaCarrito = new JTextArea();
        textAreaCarrito.setEditable(false);

        if (carrito.isEmpty()) {
            textAreaCarrito.setText("El carrito está vacío.");
        } else {
            for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
                Producto producto = entry.getKey();
                int cantidad = entry.getValue();
                textAreaCarrito.append(
                        "Producto: " + producto.getNombre() +
                                ", Precio: $" + producto.getPrecio() +
                                ", Cantidad: " + cantidad + "\n"
                );
            }
        }
        JScrollPane scrollPane = new JScrollPane(textAreaCarrito);
        frameCarrito.add(scrollPane, BorderLayout.CENTER);

        frameCarrito.setLocationRelativeTo(null);
        frameCarrito.setVisible(true);
    }

    // Método para mostrar el historial de compras
    private void verHistorial() {
        // Crear el JFrame para "Ver Historial de Compras"
        JFrame frameHistorial = new JFrame("Historial de Compras");
        frameHistorial.setSize(400, 300);
        frameHistorial.setLayout(new BorderLayout());

        JTextArea textAreaHistorial = new JTextArea();
        textAreaHistorial.setEditable(false);

        // Obtener las compras del historial y mostrarlas
        if (cliente.getHistorialCompras().getCompras().isEmpty()) {
            textAreaHistorial.setText("No hay compras en tu historial.");
        } else {
            for (String compra : cliente.getHistorialCompras().getCompras()) {
                textAreaHistorial.append(compra + "\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(textAreaHistorial);
        frameHistorial.add(scrollPane, BorderLayout.CENTER);

        frameHistorial.setLocationRelativeTo(null);
        frameHistorial.setVisible(true);
    }

    // Método para realizar la compra del carrito
    private void comprarCarrito() {
        // Comprobar si el carrito está vacío
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío. No se puede realizar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Comprobar si el cliente tiene saldo suficiente
        double totalCompra = carrito.totalPrecioCarrito();
        if (totalCompra > cliente.getSaldo()) {
            JOptionPane.showMessageDialog(this, "No tienes suficiente saldo para realizar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Realizar la compra (descontar saldo y vaciar el carrito)
        carrito.comprarCarrito(cliente);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Su compra ha sido realizada con éxito. Total: $" + totalCompra + "\nMuchas gracias por su compra.");
    }

    public void mostrar() {
        setVisible(true);
    }
}



