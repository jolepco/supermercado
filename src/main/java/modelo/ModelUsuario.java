
package modelo;

public class ModelUsuario {
    private int id;
    private String codigo;
    private String Nombre;
    private String correo;
    private int idcargo;
    public ModelUsuario(){
    
    }
    public ModelUsuario(int id, String codigo, String Nombre, String correo, int idcargo){
    this.id=id;
        this.codigo=codigo;
    this.Nombre=Nombre;
    this.correo=correo;
    this.idcargo=idcargo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

public String toString(){
    return codigo +" - "+Nombre;
}    
}
