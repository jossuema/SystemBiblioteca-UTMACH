/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Libro;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TListaLibros {
    
    public static void Eliminar(String id){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM libros WHERE ID='"+id+"';");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Agregar(Libro e){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "INSERT INTO libros VALUES ('"
                +e.getID()+"','"
                    +e.getTitulo()+"','"
                            +cFecha.FechaSQL(e.getFecha())+"','"
                                    +e.getAutor()+"','"
                                            +e.getCategoria()+"','"
                                                    +e.getEdicion()+"','"
                                                            +e.getIdioma()+"',"
                                                                    +e.getPaginas()+",'"
                                                                            +e.getDescripcion()+"',"
                                                                                    +e.getStock()+","
                                                                                            +e.getDisponible()+")";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Editar(Libro e, String id){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "UPDATE libros SET "
                +"ID='"+e.getID()+"',"
                    +"TITULO='"+e.getTitulo()+"',"
                            +"FECHA='"+cFecha.ImprimirFecha(e.getFecha())+"',"
                                    +"AUTOR='"+e.getAutor()+"',"
                                            +"CATEGORIA='"+e.getCategoria()+"',"
                                                    +"EDICION='"+e.getEdicion()+"',"
                                                            +"IDIOMA='"+e.getIdioma()+"',"
                                                                    +"PAGINAS="+e.getPaginas()+","
                                                                            +"DESCRIPCION='"+e.getDescripcion()+"',"
                                                                                    +"STOCK="+e.getStock()+","
                                                                                            +"DISPONIBLE="+e.getDisponible()
                    +" WHERE ID='"+id+"';";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static Libro getLibro(String id){        
        Conexion Conex = new Conexion();
        Libro lb = null;
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM libros WHERE ID='"+id+"';");
            if(resultado.next()){
                lb = new Libro(resultado.getString(1),
                    resultado.getString(2),
                    resultado.getDate(3),
                    resultado.getString(4),
                    resultado.getString(5),
                    resultado.getString(6),
                    resultado.getString(7),
                    resultado.getInt(8),
                    resultado.getString(9),
                    resultado.getInt(10),
                    resultado.getBoolean(11));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        return lb;
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
        ArrayList<Libro> listaE = new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM libros WHERE ID LIKE '"+ced+"%';");
            while(resultado.next()){
                listaE.add(getLibro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        if(clave.equals("Completa")){
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public static DefaultTableModel TablaBusquedaVarios(String ced, String clave){
        ArrayList<Libro> listaE = new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM libros WHERE TITULO LIKE '%"+ced+"%' OR FECHA LIKE '%"+ced+"%' OR CATEGORIA LIKE '"+ced+"%' "
                    + "OR EDICION LIKE '"+ced+"%' OR AUTOR LIKE '%"+ced+"%' OR IDIOMA LIKE '"+ced+"%';");
            while(resultado.next()){
                listaE.add(getLibro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        if(clave.equals("Completa")){
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    
}
