/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TListaUsuario {
    
    private Connection conexionTransaccional;
    
    public TListaUsuario(){
        try{
            this.conexionTransaccional = Conexion.obtenerConexion();
        }catch(SQLException ex){}
    }
    public TListaUsuario(Connection con){
        this.conexionTransaccional = con;
    }
    
    private Usuario Molde(ResultSet resultado) throws SQLException{
        return new Usuario(resultado.getString(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6),
                        resultado.getString(7),
                resultado.getString(8));
    }
    
    public void Eliminar(String ced)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("DELETE FROM usuarios WHERE CEDULA = ?;");
            st.setString(1, ced);
            st.executeUpdate();
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public void Agregar(Usuario e)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, e.getCedula());
            st.setString(2, e.getNombre());
            st.setString(3, e.getApellidoP());
            st.setString(4, e.getApellidoM());
            st.setString(5, e.getDomicilio());
            st.setString(6, e.getTelefono());
            st.setString(7, e.getCarrera());
            st.setString(8, e.getFacultad());        
            st.executeUpdate();
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public void Editar(Usuario e, String ced)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("UPDATE usuarios SET CEDULA = ?, NOMBRE = ?, APELLIDOP = ?, APELLIDOM = ?, DOMICILIO = ?, TELEFONO = ?, CARRERA = ?, FACULTAD = ? WHERE CEDULA = ?;");
            st.setString(1, e.getCedula());
            st.setString(2, e.getNombre());
            st.setString(3, e.getApellidoP());
            st.setString(4, e.getApellidoM());
            st.setString(5, e.getDomicilio());
            st.setString(6, e.getTelefono());
            st.setString(7, e.getCarrera());
            st.setString(8, e.getFacultad());        
            st.executeUpdate();
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public Usuario getUsuario(String ced)throws SQLException{        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        Usuario lb = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM usuarios WHERE CEDULA='"+ced+"';");
            resultado = st.executeQuery();
            if(resultado.next()){
                lb = Molde(resultado);
            } 
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
                resultado.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        return lb;
    }
    
    public static DefaultTableModel TablaPanelUsuario(ArrayList<Usuario> ListaE){
        String[] columnas = {"No.", "Cedula", "Nombre", "Apellido P", "Apellido M", "Domicilio", "Telefono", "Carrera", "Facultad"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        for (int i = 0; i < ListaE.size(); i++) {
            Usuario e = ListaE.get(i);
            Object[] row = {(i+1), e.getCedula(), e.getNombre(), e.getApellidoP(), e.getApellidoM(), 
                e.getDomicilio(), e.getTelefono(), e.getCarrera(), e.getFacultad()};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    public static DefaultTableModel TablaCuatroColumnas(ArrayList<Usuario> ListaE){
        String[] columnas = {"No.", "Cedula", "Nombre", "Apellido P", "Carrera"};        
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < ListaE.size(); i++) {
            Usuario e = ListaE.get(i);
            Object[] row = {(i+1), e.getCedula(), e.getNombre(), e.getApellidoP(), e.getCarrera()};
            tabla.addRow(row);
        }
        return tabla;
    }
    
    public DefaultTableModel TablaBusquedaCed(String ced, String clave)throws SQLException{
        ArrayList<Usuario> listaE = new ArrayList<Usuario>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM usuarios WHERE CEDULA LIKE '"+ced+"%';");
            resultado = st.executeQuery();
            while(resultado.next()){
                listaE.add(Molde(resultado));
            }
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
                resultado.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        if(clave.equals("Completa")){
            return TablaPanelUsuario(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public DefaultTableModel TablaBusquedaVarios(String ced, String clave)throws SQLException{
        ArrayList<Usuario> listaE = new ArrayList<Usuario>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM usuarios "
                    + "WHERE CEDULA LIKE '"+ced+"%' OR NOMBRE LIKE '"+ced+"%' OR APELLIDOP LIKE '"+ced+"%' OR APELLIDOM LIKE'"+ced+"%' OR CARRERA LIKE '"+ced+"%' OR FACULTAD LIKE '"+ced+"%';");
            resultado = st.executeQuery();
            while(resultado.next()){
                listaE.add(Molde(resultado));
            }
        } finally {
            try{
                if(this.conexionTransaccional == null){
                    Conexion.closeConexion();
                }
                st.close();
                resultado.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        if(clave.equals("Completa")){
            return TablaPanelUsuario(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    /*public static void leer() throws IOException {
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("Select * from usuarios");
            while(resultado.next()){
                Usuario lb = new Usuario(resultado.getString(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6),
                        resultado.getString(7),
                resultado.getString(8));
                lista.add(lb);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }

    public static void guardar() throws IOException {
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM usuarios");
            for (int i = 0; i < lista.size(); i++) {
                Usuario e = lista.get(i);
                String comando = "INSERT INTO usuarios VALUES ('"
                    +e.getCedula()+"','"
                            +e.getNombre()+"','"
                                    +e.getApellidoP()+"','"
                                            +e.getApellidoM()+"','"
                                                    +e.getDomicilio()+"','"
                                                            +e.getTelefono()+"','"
                                                                    +e.getCarrera()+"','"
                                                                            +e.getFacultad()+"')";
                System.out.println(comando);
                st.executeUpdate(comando);
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }*/
}
