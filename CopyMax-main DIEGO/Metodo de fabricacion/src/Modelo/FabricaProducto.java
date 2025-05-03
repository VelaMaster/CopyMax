package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface FabricaProducto {
    Productoclass crearProducto(ResultSet rs) throws SQLException;
}
