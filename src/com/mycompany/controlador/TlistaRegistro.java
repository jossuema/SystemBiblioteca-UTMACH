/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Registro;
import com.mycompany.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TlistaRegistro{
    
    private Connection conexionTransaccional;
    
    public TlistaRegistro(){}
    public TlistaRegistro(Connection con){
        this.conexionTransaccional = con;
    }
    
    private Registro Molde(ResultSet resultado) throws SQLException{
        return new Registro(new Usuario(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5)
                        , resultado.getString(6), resultado.getString(7), resultado.getString(8)), resultado.getDate(9), resultado.getBoolean(10), resultado.getInt(11));
    }
    
    public void Eliminar(String id)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("DELETE FROM registros WHERE ID='"+id+"';");
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
    
    public void Agregar(Registro e)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("INSERT INTO registros (CEDULA, FECHA, LIBRO_PRESTADO) VALUES (?, ?, ?)");
            st.setString(1, e.getPersona().getCedula());
            st.setString(2, cFecha.FechaSQL(e.getFecha()));
            st.setBoolean(3, e.getLibroPrestado());
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
    
    public Registro getRegistro(String id)throws SQLException{        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        Registro lb = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA WHERE A.ID = '"+id+"';");
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
    
    public DefaultTableModel TablaPanelRegistro(ArrayList<Registro> ListaE){
        String[] columnas = {"ID", "Cedula", "Nombre", "Apellido", "Facultad", "Carrera"
                , "Fecha", "Libro prestado"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        for (int i = 0; i < ListaE.size(); i++) {
            Registro e = ListaE.get(i);
            Object[] row = {String.valueOf(e.getID()), e.getPersona().getCedula(), e.getPersona().getNombre(), e.getPersona().getApellidoP(), 
                e.getPersona().getFacultad(), e.getPersona().getCarrera(), cFecha.ImprimirFecha(e.getFecha()), LibroPrestado(e.getLibroPrestado())};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    private String LibroPrestado(boolean ok){
        if(ok){
            return "Si";
        }
        return "No";
    }
    
    public ArrayList<Registro> TablaBusquedaFecha(Date fecha)throws SQLException{
        ArrayList<Registro> ListaE =  new ArrayList<>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA WHERE FECHA = '"+cFecha.FechaSQL(fecha)+"';");
            resultado = st.executeQuery();
            while(resultado.next()) {                
                ListaE.add(Molde(resultado));
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
        
        return ListaE;
    }
    
    public ArrayList<Registro> TablaBusquedaVarios(String clave)throws SQLException{
        ArrayList<Registro> ListaE =  new ArrayList<>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA "
                    + "WHERE CEDULA LIKE '"+clave+"%' OR NOMBRE LIKE '"+clave+"%' OR APELLIDOP LIKE '"+clave+"%' OR APELLIDOM LIKE '"+clave+"%' OR CARRERA LIKE '"+clave+"%' OR FACULTAD LIKE '"+clave+"%';");
            resultado = st.executeQuery();
            while(resultado.next()) {                
                ListaE.add(getRegistro(resultado.getString(1)));
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
        return ListaE;
    }
    
    public ArrayList<Registro> TablaBusquedaAmbos(Date fecha, String clave)throws SQLException{
        ArrayList<Registro> ListaFechas =  TablaBusquedaFecha(fecha);
        ArrayList<Registro> ListaVarios = TablaBusquedaVarios(clave);
        ArrayList<Registro> ListaE =  new ArrayList<>();
        
        for (int i = 0; i < ListaVarios.size(); i++) {
            Registro v = ListaVarios.get(i);
            for (int j = 0; j < ListaFechas.size(); j++) {
                Registro f = ListaFechas.get(j);
                if(v.equals(f)){
                    ListaE.add(f);
                }
            }
            
        }
        return ListaE;
    }
    
    public ArrayList<Registro> getLISTA()throws SQLException{
        ArrayList<Registro> ListaE = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA;");
            resultado = st.executeQuery();
            while(resultado.next()){
                ListaE.add(Molde(resultado));
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
        
        return ListaE;
    }
    
    
    /*public static void leer() throws IOException {
        Conexion Conex = new Conexion();
        try {           
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("Select * from registros");
            while(resultado.next()){
                int pos = TListaUsuario.Buscar(resultado.getString(1));
                if(pos!=-1){
                    Registro lb = new Registro(TListaUsuario.getUsuario(pos), cFecha.crearFecha(resultado.getString(2)), Boolean.valueOf(resultado.getString(3)));
                    lista.add(lb);
                }
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
            st.executeUpdate("DELETE FROM registros");
            for (int i = 0; i < lista.size(); i++) {
                Registro e = lista.get(i);
                String comando = "INSERT INTO registros VALUES ('"
                    +e.getPersona().getCedula()+"','"
                            +cFecha.ImprimirFecha(e.getFecha())+"','"
                                    +e.getLibroPrestado()+"')";
                System.out.println(comando);
                st.executeUpdate(comando);
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }*/
    
    public ArrayList<Registro> ordenamientoBurbuja()throws SQLException{
        ArrayList<Registro> ListaE = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA ORDER BY FECHA;");
            resultado = st.executeQuery();
            while(resultado.next()){
                ListaE.add(getRegistro(resultado.getString(1)));
            }
        } finally {
            try{
                Conexion.closeConexion();
                st.close();
                resultado.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
}
