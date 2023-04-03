package modelo;
/**
 *
 * DAO: Objeto de Acceso a Datos
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion conectar=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
     public ArrayList<ModelUsuario> listar(){
     ArrayList<ModelUsuario> datos=new ArrayList<>();
     String sql="select * from usuarios";
     try{

         con=conectar.getConnection();
         ps=con.prepareStatement(sql); //hndyhdoiqwioedqbahsdlsa
         rs=ps.executeQuery();
         while(rs.next()){
            ModelUsuario  p = new ModelUsuario();
             p.setId(rs.getInt("id"));
             p.setCodigo(rs.getString("codigo")); 
             p.setNombre(rs.getString("nombre")); 
             p.setCorreo(rs.getString("correo"));
             p.setIdcargo(rs.getInt("idcargo"));
             datos.add(p);
         }
     }catch(Exception e){
     }
     return datos;
    }
    
    /**
 * Este método se encargar de realizar las consultar de los registros de la tabla Usuarios en
 * la Base de datos, retornando de esta manera una Lista de los registros almacenados hasta el momento en la base de datos 
     * @param idcargo
 * @return List 
*/
    public ArrayList<ModelUsuario> listarC(int idcargo){
     ArrayList<ModelUsuario> datos=new ArrayList<>();
     String sql="select * from usuarios where idcargo ="+idcargo;
     try{

         con=conectar.getConnection();
         ps=con.prepareStatement(sql); //hndyhdoiqwioedqbahsdlsa
         rs=ps.executeQuery();
         while(rs.next()){
            ModelUsuario  p = new ModelUsuario();
             p.setId(rs.getInt("id"));
             p.setCodigo(rs.getString("codigo")); 
             p.setNombre(rs.getString("nombre")); 
             p.setCorreo(rs.getString("correo"));
             p.setIdcargo(rs.getInt("idcargo"));
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
    
    public int agregar(ModelUsuario p){
        String sql="insert into usuarios(codigo,nombre,correo,idcargo) values(?,?,?,?)";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            //ps.setInt(1, p.getId());
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getCorreo());
            ps.setInt(4, p.getIdcargo());
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
    public int actualizar(ModelUsuario p){
       int respuesta = 0; 
       String sql="update usuario set nombres = ?, correo = ?, Idcargo = ? where id = ?";
       try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            //ps.setInt(1, p.getId());
            //ps.setString(2, p.getCodigo());
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCorreo());
            ps.setInt(3, p.getIdcargo());
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
        String sql = "delete from usuario where id ="+id;
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();          
        }catch(Exception e){
        }
    }
}
