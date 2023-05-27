/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TListaLibros {
    
    private Connection conexionTransaccional;
    
    public TListaLibros(){
        try{
            this.conexionTransaccional = Conexion.obtenerConexion();
        }catch(SQLException ex){}
    }
    
    public TListaLibros(Connection con){
        this.conexionTransaccional = con;
    }
    
    private Libro Molde(ResultSet resultado)throws SQLException{
        return new Libro(resultado.getString(1),
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
    
    public void Eliminar(String id)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("DELETE FROM libros WHERE ID='"+id+"';");
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
    
    public void Agregar(Libro e)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, e.getID());
            st.setString(2, e.getTitulo());
            st.setString(3, cFecha.FechaSQL(e.getFecha()));
            st.setString(4, e.getAutor());
            st.setString(5, e.getCategoria());
            st.setString(6, e.getEdicion());
            st.setString(7, e.getIdioma());
            st.setInt(8, e.getPaginas());
            st.setString(9, e.getDescripcion());
            st.setInt(10, e.getStock());
            st.setBoolean(11, e.getDisponible());
            st.executeUpdate();
        } finally {
            try{
                Conexion.closeConexion();
                st.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            } 
        }
    }
    
    public void Editar(Libro e, String id)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("UPDATE libros SET ID = ?, TITULO = ?, FECHA = ?, AUTOR = ?, CATEGORIA = ?, EDICION = ?, IDIOMA = ?, PAGINAS = ?,DESCRIPCION = ?, STOCK = ?, DISPONIBLE = ? WHERE ID = ? ;");
            st.setString(1, e.getID());
            st.setString(2, e.getTitulo());
            st.setString(3, cFecha.FechaSQL(e.getFecha()));
            st.setString(4, e.getAutor());
            st.setString(5, e.getCategoria());
            st.setString(6, e.getEdicion());
            st.setString(7, e.getIdioma());
            st.setInt(8, e.getPaginas());
            st.setString(9, e.getDescripcion());
            st.setInt(10, e.getStock());
            st.setBoolean(11, e.getDisponible());
            st.setString(12, id);
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
    
    public Libro getLibro(String id)throws SQLException{        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        Libro lb = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM libros WHERE ID='"+id+"';");
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
    
    public DefaultTableModel TablaPanelLibros(ArrayList<Libro> ListaE){
        String[] columnas = {"No.", "ID", "Titulo", "Fecha publicacion", "Autor", "Categoria"
                , "Edicion", "Idioma", "Paginas", "Descripcion", "Stock", "Disponibilidad"};        
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        
        ListaE.forEach((e)->{
            Object[] row = {(ListaE.indexOf(e)+1), String.valueOf(e.getID()), e.getTitulo(), cFecha.ImprimirFecha(e.getFecha()), e.getAutor(), 
                    e.getCategoria(), e.getEdicion(), e.getIdioma(), e.getPaginas(), e.getDescripcion(), e.getStock(), Disponibilidad(e.getDisponible())};
                tabla.addRow(row);
        });
        return tabla;
    }
    
    private String Disponibilidad(boolean ok){
        if(ok){
            return "Disponible";
        }
        return "No diponible";
    }
    
    public DefaultTableModel TablaCuatroColumnas(ArrayList<Libro> ListaE){
        String[] columnas = {"No.", "ID", "Titulo", "Paginas", "Disponibilidad"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        ListaE.forEach((e)->{
            Object[] row = {(ListaE.indexOf(e)+1), String.valueOf(e.getID()), e.getTitulo(), e.getPaginas(), Disponibilidad(e.getDisponible())};
            tabla.addRow(row);
        });
        return tabla;
    }
    
    public DefaultTableModel TablaBusquedaID(String ced, String clave)throws SQLException{
        ArrayList<Libro> listaE = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM libros WHERE ID LIKE '"+ced+"%';");
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
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public DefaultTableModel TablaBusquedaVarios(String ced, String clave)throws SQLException{
        ArrayList<Libro> listaE = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.obtenerConexion();
            st = con.prepareStatement("SELECT * FROM libros WHERE TITULO LIKE %?% OR FECHA LIKE '%?%' OR CATEGORIA LIKE ?% OR EDICION LIKE ?% OR AUTOR LIKE %?% OR IDIOMA LIKE ?%;");
            st.setString(1, ced);
            st.setString(2, ced);
            st.setString(3, ced);
            st.setString(4, ced);
            st.setString(5, ced);
            st.setString(6, ced);
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
            return TablaPanelLibros(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    
}
