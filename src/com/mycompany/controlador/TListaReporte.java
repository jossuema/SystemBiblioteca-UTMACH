/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Reporte;
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
public class TListaReporte {
    
    /*public static void Eliminar(String da){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM reportes WHERE id='"+id+"';");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }*/
    
    public static Reporte Molde(ResultSet resultado) throws SQLException{
        return new Reporte(resultado.getString(1), resultado.getString(2), resultado.getDate(3),
                        resultado.getDate(4), resultado.getBoolean(5), resultado.getInt(6), resultado.getString(7), resultado.getInt(8));
    }
    
    public static void Agregar(Reporte e){
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.obtenerConexion();
            st = con.prepareStatement("INSERT INTO reportes (CEDULA, IDLIBRO, FECHASALIDA, FECHAENTREGA, DEVUELTO, RETRASO, NOTA) VALUES (?, ?, ?, ?, ?, ?, ?);");
            st.setString(1, e.getCedula());
            st.setString(2, e.getIDLibro());
            st.setString(3, cFecha.FechaSQL(e.getFechaSalida()));
            st.setString(4, cFecha.FechaSQL(e.getFechaEntrega()));
            st.setBoolean(5, e.getDevuelto());
            st.setInt(6, e.getRetraso());
            st.setString(7, e.getNota());
            st.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public static void Editar(Reporte e){
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.obtenerConexion();
            st = con.prepareStatement("UPDATE reportes SET CEDULA = ?,IDLIBRO = ?, FECHASALIDA = ?, FECHAENTREGA = ?, DEVUELTO = ?, RETRASO = ?, NOTA = ? WHERE ID = ?;");
            st.setString(1, e.getCedula());
            st.setString(2, e.getIDLibro());
            st.setString(3, cFecha.FechaSQL(e.getFechaSalida()));
            st.setString(4, cFecha.FechaSQL(e.getFechaEntrega()));
            st.setBoolean(5, e.getDevuelto());
            st.setInt(6, e.getRetraso());
            st.setString(7, e.getNota());
            st.setInt(8, e.getID());
            st.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public static Reporte getReporte(int i){
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        Reporte lb = null;
        try {
            con = Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM REPORTES WHERE ID = ?;");
            st.setInt(1, i);
            resultado = st.executeQuery();
            if(resultado.next()){
                lb = Molde(resultado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        return lb;
    }
    
    public static DefaultTableModel TablaPanelReporte(ArrayList<Reporte> ListaE){
        String[] columnas = {"No.", "Cedula usuario", "ID Libro", "Fecha Salida", "Fecha entrega", "Estado", "Retraso"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        for (int i = 0; i < ListaE.size(); i++) {
            Reporte e = ListaE.get(i);
            Object[] row = {e.getID(), e.getCedula(), String.valueOf(e.getIDLibro()), cFecha.ImprimirFecha(e.getFechaSalida()), cFecha.ImprimirFecha(e.getFechaEntrega()), 
                e.Estado(), e.DiasRetraso()};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    /*public static ArrayList<Reporte> BusquedaCed(String dato){
        ArrayList<Reporte> Al = new ArrayList<Reporte>();
        
        for (int i = 0; i < lista.size(); i++) {
            Reporte e = lista.get(i);
            if(e.getCedula().toLowerCase().startsWith(dato)
                    ||String.valueOf(e.getIDLibro()).toLowerCase().startsWith(dato)){
                Al.add(e);
            }
            
        }
        return Al;
    }*/
    
    public static ArrayList<Reporte> NoDevueltosBusqueda(String dato){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM reportes WHERE DEVUELTO = 0 AND (CEDULA LIKE '"+dato+"%' OR IDLIBRO LIKE '"+dato+"%');");
            while(resultado.next()){
                ListaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> NoDevueltos(){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM reportes WHERE DEVUELTO = 0;");
            while(resultado.next()){
                ListaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
    
    public static DefaultTableModel TablaReporteCuatroColumnas(ArrayList<Reporte> ListaE){
        String[] columnas = {"No.", "Cedula usuario", "ID Libro", "Fecha entrega", "Retraso"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        for (int i = 0; i < ListaE.size(); i++) {
            Reporte e = ListaE.get(i);
            Object[] row = {e.getID(), e.getCedula(), String.valueOf(e.getIDLibro()), cFecha.ImprimirFecha(e.getFechaEntrega()), e.DiasRetraso()};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    
    public static ArrayList<Reporte> ordenamientoBurbuja(){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM reportes ORDER BY FECHAENTREGA;");
            while(resultado.next()){
                ListaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> getLista(){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM reportes;");
            while(resultado.next()){
                ListaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> Busqueda(String dato){
        ArrayList<Reporte> ListaE= new ArrayList<Reporte>();

        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM reportes WHERE CEDULA LIKE '"+dato+"%' OR IDLIBRO LIKE '"+dato+"%';");
            while(resultado.next()){
                ListaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                Conexion.closeConexion();
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
        
        return ListaE;
    }
}
