/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Libro;
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
public class TListaLibros {
    public static ArrayList<Libro> lista = new ArrayList<Libro>();
    
    public static void Eliminar(int i){
        lista.remove(i);
    }
    
    public static void Agregar(Libro e){
        lista.add(e);
    }
    
    public static void Editar(Libro e, int i){
        lista.set(i, e);
    }
    
    public static Libro getLibro(int i){
        return lista.get(i);
    }
    
    public static int Buscar(String id){
        for (int i = 0; i < lista.size(); i++) {
            Libro get = lista.get(i);
            if(String.valueOf(get.getID()).equals(id)){
                return i;
            }
        }
        if(0==lista.size()){
            return -2;
        }
        return -1;
    }
    
    public static DefaultTableModel TablaPanelLibros(ArrayList<Libro> ListaE){
        String[] columnas = {"No.", "ID", "Titulo", "Fecha publicacion", "Autor", "Categoria"
                , "Edicion", "Idioma", "Paginas", "Descripcion", "Stock", "Disponibilidad"};        
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
            
        for (int i = 0; i < ListaE.size(); i++) {
            Libro e = ListaE.get(i);
            Object[] row = {(i+1), String.valueOf(e.getID()), e.getTitulo(), cFecha.ImprimirFecha(e.getFecha()), e.getAutor(), 
                e.getCategoria(), e.getEdicion(), e.getIdioma(), e.getPaginas(), e.getDescripcion(), e.getStock(), Disponibilidad(e.getDisponible())};
            tabla.addRow(row);
        }
        
        return tabla;
    }
    
    private static String Disponibilidad(boolean ok){
        if(ok){
            return "Disponible";
        }
        return "No diponible";
    }
    
    public static DefaultTableModel TablaCuatroColumnas(ArrayList<Libro> ListaE){
        String[] columnas = {"No.", "ID", "Titulo", "Paginas", "Disponibilidad"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
         
        for (int i = 0; i < ListaE.size(); i++) {
            Libro e = ListaE.get(i);
            Object[] row = {(i+1), String.valueOf(e.getID()), e.getTitulo(), e.getPaginas(), Disponibilidad(e.getDisponible())};
            tabla.addRow(row);
        }
        return tabla;
    }
    
    public static DefaultTableModel TablaBusquedaID(String ced, String clave){
        ArrayList<Libro> listaE = new ArrayList<Libro>();
        for (int i = 0; i < lista.size(); i++) {
            Libro e = lista.get(i);
            if(String.valueOf(e.getID()).toLowerCase().startsWith(ced)){
                listaE.add(e);
            }
        }
        if(clave.equals("Completa")){
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public static DefaultTableModel TablaBusquedaVarios(String ced, String clave){
        ArrayList<Libro> listaE = new ArrayList<Libro>();
        for (int i = 0; i < lista.size(); i++) {
            Libro e = lista.get(i);
            if(e.getTitulo().toLowerCase().startsWith(ced)){
                listaE.add(e);
            }
        }
        if(clave.equals("Completa")){
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }

    public static void leer() throws IOException {
        try {
            Conexion Conex = new Conexion();
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("Select * from libros");
            while(resultado.next()){
                Libro lb = new Libro(resultado.getString(1),
                        resultado.getString(2),
                        cFecha.crearFecha(resultado.getString(3)),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6),
                        resultado.getString(7),
                        resultado.getInt(8),
                        resultado.getString(9),
                        resultado.getInt(10),
                        Boolean.valueOf(resultado.getString(11)));
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
            st.executeUpdate("DELETE FROM libros");
            for (int i = 0; i < lista.size(); i++) {
                Libro e = lista.get(i);
                String comando = "INSERT INTO libros VALUES ('"
                    +e.getID()+"','"
                            +e.getTitulo()+"','"
                                    +cFecha.ImprimirFecha(e.getFecha())+"','"
                                            +e.getAutor()+"','"
                                                    +e.getCategoria()+"','"
                                                            +e.getEdicion()+"','"
                                                                    +e.getIdioma()+"',"
                                                                            +e.getPaginas()+",'"
                                                                                    +e.getDescripcion()+"',"
                                                                                            +e.getStock()+",'"
                                                                                                    +String.valueOf(e.getDisponible())+"')";
                System.out.println(comando);
                st.executeUpdate(comando);
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexion.closeConnexion();
        }
    }
    
}
