package Modelo;
public class FabricaProductoGeneral {
    public static Producto crearProducto(int id, String nombre, double precio, int cantidad, String categoria) {
        switch (categoria.toLowerCase()) {
            case "papeleria":
                return new FabricaUtilEscolar().crearProducto(id, nombre, precio, cantidad);
            case "copia / impresion":
                return new FabricaImpresion().crearProducto(id, nombre, precio, cantidad);
            default:
                Productoclass producto = new Productoclass();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                producto.setCategoria(categoria);
                return producto;
        }
    }
}