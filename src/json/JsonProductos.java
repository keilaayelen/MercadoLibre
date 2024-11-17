package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ArrayList.AdministradorList;
import models.Producto;

import java.io.File;
import java.io.IOException;

public class JsonProductos {
    public static void serializarProductos(AdministradorList<Producto> productos) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("productos.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, productos);
            System.out.println("Productos guardados en productos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AdministradorList<Producto> deserializarProductos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            File file = new File("productos.json");
            AdministradorList<Producto> productos = objectMapper.readValue(file, AdministradorList.class);
            return productos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}