/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.conexion.Conexion;
import com.mycompany.entidades.Registro;
import com.mycompany.entidades.Usuario;
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
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TlistaRegistro{
    public static void Eliminar(String id){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM registros WHERE ID='"+id+"';");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Agregar(Registro e){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "INSERT INTO registros (CEDULA, FECHA, LIBRO_PRESTADO) VALUES ('"
                +e.getPersona().getCedula()+"','"
                    +cFecha.FechaSQL(e.getFecha())+"',"
                        +e.getLibroPrestado()+")";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static Registro getRegistro(String id){        
        Conexion Conex = new Conexion();
        Registro lb = null;
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT B.*, A.FECHA, A.LIBRO_PRESTADO, A.ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA WHERE A.ID = '"+id+"';");
            if(resultado.next()){
                lb = new Registro(new Usuario(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5)
                        , resultado.getString(6), resultado.getString(7), resultado.getString(8)), resultado.getDate(9), resultado.getBoolean(10), resultado.getInt(11));
            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        return lb;
    }
    
    public static DefaultTableModel TablaPanelRegistro(ArrayList<Registro> ListaE){
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
    
    private static String LibroPrestado(boolean ok){
        if(ok){
            return "Si";
        }
        return "No";
    }
    
    public static ArrayList<Registro> TablaBusquedaFecha(Date fecha){
        ArrayList<Registro> ListaE =  new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM registros WHERE FECHA = '"+cFecha.FechaSQL(fecha)+"';");
            System.out.println(cFecha.FechaSQL(fecha));
            while(resultado.next()) {                
                ListaE.add(getRegistro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
    
    public static ArrayList<Registro> TablaBusquedaVarios(String clave){
        ArrayList<Registro> ListaE =  new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM registros A INNER JOIN usuarios B ON A.CEDULA = B.CEDULA "
                    + "WHERE CEDULA LIKE '"+clave+"%' OR NOMBRE LIKE '"+clave+"%' OR APELLIDOP LIKE '"+clave+"%' OR APELLIDOM LIKE '"+clave+"%' OR CARRERA LIKE '"+clave+"%' OR FACULTAD LIKE '"+clave+"%';");
            while(resultado.next()) {                
                ListaE.add(getRegistro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        return ListaE;
    }
    
    public static ArrayList<Registro> TablaBusquedaAmbos(Date fecha, String clave){
        ArrayList<Registro> ListaFechas =  TablaBusquedaFecha(fecha);
        ArrayList<Registro> ListaVarios = TablaBusquedaVarios(clave);
        ArrayList<Registro> ListaE =  new ArrayList<Registro>();
        
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
    
    public static ArrayList<Registro> getLISTA(){
        ArrayList<Registro> ListaE = new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM registros;");
            while(resultado.next()){
                ListaE.add(getRegistro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
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
    
    public static ArrayList<Registro> ordenamientoBurbuja(){
        ArrayList<Registro> ListaE = new ArrayList<>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT ID FROM registros ORDER BY FECHA;");
            while(resultado.next()){
                ListaE.add(getRegistro(resultado.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        return ListaE;
    }
}
