/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guido
 */
public class Persona {
    Connection cnn;
    Statement state;
    ResultSet result;
    
    String dui;
    String apellidos;
    String nombres;
    
    public Persona()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recurso_humano?zeroDateTimeBehavior=convertToNull", "root", "");               
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
                
    }
    
  public Persona(String dui, String apellidos, String nombres){
        this.dui = dui;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }
  
    public boolean insertarDatos(){
        try{
            String miQuery = "insert into tb_persona values('" + dui + "','" + apellidos + "','" + nombres + "');";
            int estado = 0;
            state = cnn.createStatement();
            estado = state.executeUpdate(miQuery);
            if(estado == 1){
                return true;
            }        
        }catch (SQLException ex){
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
            
    public ArrayList<Persona> ConsultarRegistro(){
        ArrayList<Persona> person = new ArrayList();
        try {
            String miQuery = "select * from tb_persona;";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombre_persona")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
    
     public boolean BuscarId(String dui)
    {
       
       try {
            String miQuery = "select * from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            state.executeQuery(miQuery);
            
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }
    
    public Persona list(String dui)
    {
        Persona p = new Persona();
       try {
            String miQuery = "select * from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                p.setDui(result.getString("dui_persona"));
                p.setApellidos(result.getString("apellidos_persona"));
                p.setNombres(result.getString("nombre_persona"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }
    
    public boolean Editar(Persona per)
    {
       try {
            String miQuery = "update tb_persona set apellidos_persona='" + per.getApellidos() + "',nombre_persona='" + per.getNombres() + "' where dui_persona='"+per.getDui()+"'";
            state = cnn.createStatement();
            state.executeUpdate(miQuery);
           
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
     public boolean Eliminar(String dui)
    {
       try {
            String miQuery = "delete from tb_persona where dui_persona='"+dui+"'";
            state = cnn.createStatement();
            state.executeUpdate(miQuery);
           
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
      
    public String getDui() {
        return dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
