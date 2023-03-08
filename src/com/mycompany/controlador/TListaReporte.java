/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Reporte;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static ArrayList<Reporte> lista = new ArrayList<Reporte>();
    
    public static void Eliminar(int i){
        lista.remove(i);
    }
    
    public static void Agregar(Reporte e){
        lista.add(e);
    }
    
    public static void Editar(Reporte e, int i){
        lista.set(i, e);
    }
    
    public static Reporte getReporte(int i){
        return lista.get(i);
    }
    
    public static int Buscar(String ced, String id){
        for (int i = 0; i < lista.size(); i++) {
            Reporte get = lista.get(i);
            if(get.getCedula().equals(ced)&&String.valueOf(get.getIDLibro()).equals(id)){
                return i;
            }
        }
        return -1;
    }
    
    public static DefaultTableModel TablaPanelReporte(ArrayList<Reporte> ListaE){
        String[] columnas = {"No.", "Cedula usuario", "ID Libro", "Fecha Salida", "Fecha entrega", "Estado", "Retraso"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        for (int i = 0; i < ListaE.size(); i++) {
            Reporte e = ListaE.get(i);
            Object[] row = {(i+1), e.getCedula(), String.valueOf(e.getIDLibro()), cFecha.ImprimirFecha(e.getFechaSalida()), cFecha.ImprimirFecha(e.getFechaEntrega()), 
                e.Estado(), e.DiasRetraso()};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    public static ArrayList<Reporte> Busqueda(String dato){
        ArrayList<Reporte> Al = new ArrayList<Reporte>();
        
        for (int i = 0; i < lista.size(); i++) {
            Reporte e = lista.get(i);
            if(e.getCedula().toLowerCase().startsWith(dato)
                    ||String.valueOf(e.getIDLibro()).toLowerCase().startsWith(dato)){
                Al.add(e);
            }
            
        }
        return Al;
    }
    
    public static ArrayList<Reporte> NoDevueltosBusqueda(String dato){
        ArrayList<Reporte> Al = new ArrayList<Reporte>();
        
        for (int i = 0; i < lista.size(); i++) {
            Reporte e = lista.get(i);
            if((e.getCedula().toLowerCase().startsWith(dato)
                    ||String.valueOf(e.getIDLibro()).toLowerCase().startsWith(dato))&&!e.getDevuelto()){
                Al.add(e);
            }
            
        }
        return Al;
    }
    
    public static ArrayList<Reporte> NoDevueltos(){
        ArrayList<Reporte> Al = new ArrayList<Reporte>();
        
        for (int i = 0; i < lista.size(); i++) {
            Reporte e = lista.get(i);
            if(!e.getDevuelto()){
                Al.add(e);
            }
        }
        return Al;
    }
    
    public static DefaultTableModel TablaReporteCuatroColumnas(ArrayList<Reporte> ListaE){
        String[] columnas = {"No.", "Cedula usuario", "ID Libro", "Fecha entrega", "Retraso"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        for (int i = 0; i < ListaE.size(); i++) {
            Reporte e = ListaE.get(i);
            Object[] row = {(i+1), e.getCedula(), String.valueOf(e.getIDLibro()), cFecha.ImprimirFecha(e.getFechaEntrega()), e.DiasRetraso()};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    public static void leer() throws IOException {
        try {
            Conexion Conex = new Conexion();
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("Select * from reporte");
            while(resultado.next()){
                Reporte lb = new Reporte(resultado.getString(1), resultado.getString(2), cFecha.crearFecha(resultado.getString(3)),
                        cFecha.crearFecha(resultado.getString(4)), Boolean.valueOf(resultado.getString(5)), resultado.getInt(6), resultado.getString(7));
                lista.add(lb);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.closeConnexion();
        }
    }

    public static void guardar() throws IOException {
        try {
            Conexion Conex = new Conexion();
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM reporte");
            for (int i = 0; i < lista.size(); i++) {
                Reporte e = lista.get(i);
                String comando = "INSERT INTO reporte VALUES ('"
                    +e.getCedula()+"','"
                            +e.getIDLibro()+"','"
                                    +cFecha.ImprimirFecha(e.getFechaSalida())+"','"
                                            +cFecha.ImprimirFecha(e.getFechaEntrega())+"','"
                                                    +String.valueOf(e.getDevuelto())+"',"
                                                            +e.getRetraso()+",'"
                                                                    +e.getNota()+"')";
                System.out.println(comando);
                st.executeUpdate(comando);
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.closeConnexion();
        }
    }
    
    public static ArrayList<Reporte> ordenamientoBurbuja(){
        ArrayList<Reporte> al = lista;
        for (int i = 0; i < al.size() - 1; i++) {
            for (int j = 0; j < al.size() - i - 1; j++) {
                if (al.get(j).getFechaEntrega().compareTo(al.get(j+1).getFechaEntrega()) < 0) {
                    Reporte pe = al.get(j);
                    al.set(j, al.get(j+1));
                    al.set(j+1, pe);
                }
            }
        }
        return al;
    }
}
