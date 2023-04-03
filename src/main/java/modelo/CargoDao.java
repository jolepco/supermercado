
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class CargoDao {
    Conexion conectar=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
        
    
    /**
 * Este método se encargar de realizar las consultar de los registros de la tabla Usuarios en
 * la Base de datos, retornando de esta manera una Lista de los registros almacenados hasta el momento en la base de datos 
 * @return List 
*/
    public ArrayList<ModelCargo> listar(){
     ArrayList<ModelCargo> datos=new ArrayList<>();
     Statement stmt;
     String sql="select * from cargo";
     
     try{
         con=conectar.getConnection();
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);
         //ps=con.prepareStatement(sql); //hndyhdoiqwioedqbahsdlsa
         //rs=ps.executeQuery();
         while(rs.next()){
            ModelCargo  p = new ModelCargo();
             p.setId(rs.getInt("id"));
             p.setNombre(rs.getString("nombre")); 
             datos.add(p);
         }
     }catch(Exception e){
     }
     return datos;
    }
    /**
 * Este método se encargar de realizar las insercciones de registros en 
 * la Base de datos, la informacion es proporcionada desde el controlador.
 * @param p es un objeto de tipo Supermercado
 * @return Integer 
*/
    public int agregar(ModelCargo p){
        String sql="insert into cargo(id, nombre,estado) values(?,?,?)";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setBoolean(3, p.getEstado());
            ps.executeUpdate();
        }catch(Exception e){
        }
        return 1;
    }

        /**
     * Este método se encargar de realizar las actualizaciones de registros en 
     * la Base de datos, la informacion es proporcionada desde el controlador.
     * @param p es un objeto de tipo Supermercado
     * @return Integer 
    */
    public int actualizar(ModelCargo p){
       int respuesta = 0; 
       String sql="update cargo set nombres = ? ,estafo =? where id = ?";
       try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setBoolean(3, p.getEstado());
            respuesta = ps.executeUpdate();
            if(respuesta==1){
                return 1;
            }else{
                return 0;
            }
       }catch(Exception e){
       }
       return respuesta;
    }
    /**
     * Este método se encargar de realizar las eliminaciones de registros en 
     * la Base de datos, la informacion es proporcionada desde el controlador.
     * @param id es un objeto integer, correspondiente al id del registro en Base de datos
    */
    public void eliminar(int id){
        String sql = "delete from cargo where id ="+id;
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();          
        }catch(Exception e){
        }
    }
}
