
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Conexion {
    
    public Connection getConnection() throws ClassNotFoundException
    {
        String url="jdbc:mysql://localhost:3306/supermercado?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usua="root";
    String pass="j.8916";
    
    Connection conn=null;
    try { Class.forName("com.mysql.jdbc.Driver"); // De esta forma cargamos la clase Driver de MySQL.
        conn = DriverManager.getConnection(url, usua, pass);
        System.out.println("Conexión Exitosa");
    }
     catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return conn;
    }
    
    
}
