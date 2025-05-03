package Modelo;

public class FabricaProductoGeneral {

    public static Producto crearProducto(int id, String nombre, double precio, int cantidad, String categoria) {
        FabricaProductos fabrica;

        switch (categoria.toLowerCase()) {
            case "útil escolar":
                fabrica = new FabricaUtilEscolar();
                break;
            case "impresión":
                fabrica = new FabricaImpresion();
                break;
            default:
                fabrica = new FabricaDefault();
                break;
        }

        return fabrica.crearProducto(id, nombre, precio, cantidad);
    }
}