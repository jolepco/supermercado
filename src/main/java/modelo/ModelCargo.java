/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Leonardo
 */
public class ModelCargo {
    private int id;
    private String nombre;
    private Boolean estado;

    public ModelCargo(){}
    public ModelCargo(int id, String nombre, Boolean estado){
        this.estado=estado;
        this.id=id;
        this.nombre=nombre;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String toString(){
    return nombre;
} 
}
