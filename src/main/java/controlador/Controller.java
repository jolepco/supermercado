package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CargoDao;
import modelo.ModelCargo;
import modelo.ModelUsuario;
import modelo.UsuarioDAO;
import vista.ViewUsuario;


/**
 *
 * @author Leonardo
 */
public class Controller implements ActionListener { 
 ModelUsuario musuario= new ModelUsuario();
 ModelCargo mcargo= new ModelCargo();
 ViewUsuario vusuario = new ViewUsuario();
 UsuarioDAO _daoUsuario = new  UsuarioDAO();
 CargoDao _daoCargo = new  CargoDao();
DefaultTableModel modelo = new DefaultTableModel();

public Controller(ViewUsuario v) {
        this.vusuario = v;
        this.vusuario.btnGuardar.addActionListener(this);
        this.vusuario.btnConsultar.addActionListener(this);
        this.vusuario.btnNuevo.addActionListener(this);
        llenarcomboBox();
        cargartodosusuarios();
    }


 @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vusuario.btnGuardar) {
        agregar();
        cargartodosusuarios();
    }
    else if (e.getSource() == vusuario.btnConsultar) {       
        cargartodosusuariosxCargo();
    } 
    else if (e.getSource() == vusuario.btnNuevo) {
         limpiar();
     }
   
}

public void agregar() {
        //int _id =Integer.parseInt(vusuario.txtid.getText());
        String nombre = vusuario.txtNombre.getText();
        String correo =vusuario.txtCorreo.getText();
        String codigo = vusuario.txtCodigo.getText();
        int idcargo = vusuario.cbCArgo.getSelectedIndex();
        ModelUsuario p = new  ModelUsuario();
        
        p.setNombre(nombre);
        p.setCorreo(correo);
        p.setCodigo(codigo);
        p.setIdcargo(idcargo);
        
        int r = _daoUsuario.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vusuario, "Se agregó el usuario " + p.getNombre() + "");
        } else {
            JOptionPane.showMessageDialog(vusuario, "Error al agregar el usuario " + p.getNombre() + "");
        }
    }
    
        // proceso de carga de todos los usuarios en la grilla
  
public void cargartodosusuarios()
{
    modelo.UsuarioDAO modUsuario  =new modelo.UsuarioDAO();
    ArrayList<ModelUsuario> listaUsuarios = modUsuario.listar();
    DefaultTableModel modelotablaUsuario= new DefaultTableModel();
    //modelotablaUsuario.addColumn("id");
    modelotablaUsuario.addColumn("codigo");
    modelotablaUsuario.addColumn("Nombre");
    modelotablaUsuario.addColumn("correo");
    //modelotablaUsuario.addColumn("idcargo");
    vusuario.tblAllUser.setModel(modelotablaUsuario);

    String[] visor =new String[3];
    for (int i = 0; i < listaUsuarios.size(); i++) {
        visor[0]=listaUsuarios.get(i).getCodigo();
        visor[1]=listaUsuarios.get(i).getNombre();
        visor[2]=listaUsuarios.get(i).getCorreo();
        modelotablaUsuario.addRow(visor);
    }
    
}
        
    
   // proceso de carga de todos los usuarios en la grilla
    public void cargartodosusuariosxCargo()
    {
    modelo.UsuarioDAO modUsuario  =new modelo.UsuarioDAO();
    int id=vusuario.cbCArgo.getSelectedIndex();
    ArrayList<ModelUsuario> listaUsuarios = modUsuario.listarC(id);
    DefaultTableModel modelotablaUsuario= new DefaultTableModel();
    //modelotablaUsuario.addColumn("id");
    modelotablaUsuario.addColumn("codigo");
    modelotablaUsuario.addColumn("Nombre");
    modelotablaUsuario.addColumn("correo");
    //modelotablaUsuario.addColumn("idcargo");
    vusuario.tblUserxCargo.setModel(modelotablaUsuario);
    String[] visor =new String[3];
    for (int i = 0; i < listaUsuarios.size(); i++) {
        visor[0]=listaUsuarios.get(i).getCodigo();
        visor[1]=listaUsuarios.get(i).getNombre();
        visor[2]=listaUsuarios.get(i).getCorreo();
        modelotablaUsuario.addRow(visor);
    }
    }
    
    /* 
        proceso de llenado del combo de cargos
        */
    public void llenarcomboBox(){
        modelo.CargoDao modCargo= new modelo.CargoDao();
        ArrayList<ModelCargo> listaCargos= modCargo.listar();
        
        vusuario.cbCArgo.removeAllItems();
        
        for (int i = 0; i < listaCargos.size(); i++) {
         vusuario. cbCArgo.addItem(new ModelCargo(listaCargos.get(i).getId()
                  ,listaCargos.get(i).getNombre(),listaCargos.get(i).getEstado()));
        }
        
    }

     public void limpiar() {
        vusuario.txtNombre.setText("");
        vusuario.txtCodigo.setText("");
        vusuario.txtCorreo.setText("");
    }

}

