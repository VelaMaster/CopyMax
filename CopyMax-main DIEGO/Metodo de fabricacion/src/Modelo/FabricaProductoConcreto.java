package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaProductoConcreto implements FabricaProducto {
    @Override
    public Productoclass crearProducto(ResultSet rs) throws SQLException {
        Productoclass producto = new Productoclass();
        
        producto.setId(rs.getInt("idProductos"));
        producto.setNombre(rs.getString("Nombre_producto"));
        producto.setPrecio(rs.getDouble("Precio"));
        producto.setCantidad(rs.getInt("Cantidad"));
        producto.setCategoria(rs.getString("Categoria"));
        
        return producto;
    }
}