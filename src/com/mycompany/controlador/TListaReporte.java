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
    
    public static void Agregar(Reporte e){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "INSERT INTO reportes (CEDULA, IDLIBRO, FECHASALIDA, FECHAENTREGA, DEVUELTO, RETRASO, NOTA) VALUES ('"
                +e.getCedula()+"','"
                    +e.getIDLibro()+"','"
                        +cFecha.FechaSQL(e.getFechaSalida())+"','"
                            +cFecha.FechaSQL(e.getFechaEntrega())+"',"
                                +e.getDevuelto()+","
                                    +e.getRetraso()+",'"
                                        +e.getNota()+"')";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Editar(Reporte e){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "UPDATE reportes SET "
                +"CEDULA = '"+e.getCedula()+"',"
                        +"IDLIBRO = '"+e.getIDLibro()+"',"
                                +"FECHASALIDA = '"+cFecha.FechaSQL(e.getFechaSalida())+"',"
                                        +"FECHAENTREGA = '"+cFecha.FechaSQL(e.getFechaEntrega())+"',"
                                                +"DEVUELTO = "+e.getDevuelto()+","
                                                        +"RETRASO = "+e.getRetraso()+","
                                                                +"NOTA = '"+e.getNota()+"'"
                    +" WHERE ID="+e.getID()+";";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static Reporte getReporte(int i){
        Conexion Conex = new Conexion();
        Reporte lb = null;
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM REPORTES WHERE ID = '"+i+"';");
            if(resultado.next()){
                lb = new Reporte(resultado.getString(1), resultado.getString(2), resultado.getDate(3),
                        resultado.getDate(4), resultado.getBoolean(5), resultado.getInt(6), resultado.getString(7), resultado.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
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
            ResultSet resultado = st.executeQuery("SELECT ID FROM reportes WHERE DEVUELTO = 0 AND (CEDULA LIKE '"+dato+"%' OR IDLIBRO LIKE '"+dato+"%');");
            while(resultado.next()){
                ListaE.add(getReporte(resultado.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> NoDevueltos(){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM reportes WHERE DEVUELTO = 0;");
            while(resultado.next()){
                ListaE.add(getReporte(resultado.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
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
            ResultSet resultado = st.executeQuery("SELECT ID FROM reportes ORDER BY FECHAENTREGA;");
            while(resultado.next()){
                ListaE.add(getReporte(resultado.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> getLista(){
        ArrayList<Reporte> ListaE = new ArrayList<Reporte>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM reportes;");
            while(resultado.next()){
                ListaE.add(getReporte(resultado.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
    
    public static ArrayList<Reporte> Busqueda(String dato){
        ArrayList<Reporte> ListaE= new ArrayList<Reporte>();

        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM reportes WHERE CEDULA LIKE '"+dato+"%' OR IDLIBRO LIKE '"+dato+"%';");
            while(resultado.next()){
                ListaE.add(getReporte(resultado.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
}
