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
    
    public static Usuario Molde(ResultSet resultado) throws SQLException{
        return new Usuario(resultado.getString(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6),
                        resultado.getString(7),
                resultado.getString(8));
    }
    
    public static void Eliminar(String ced){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM usuarios WHERE CEDULA='"+ced+"';");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Agregar(Usuario e){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
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
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static void Editar(Usuario e, String ced){
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            String comando = "UPDATE usuarios SET "
                +"CEDULA='"+e.getCedula()+"',"
                    +"NOMBRE='"+e.getNombre()+"',"
                            +"APELLIDOP='"+e.getApellidoP()+"',"
                                    +"APELLIDOM='"+e.getApellidoM()+"',"
                                            +"DOMICILIO='"+e.getDomicilio()+"',"
                                                    +"TELEFONO='"+e.getTelefono()+"',"
                                                            +"CARRERA='"+e.getCarrera()+"',"
                                                                    +"FACULTAD= '"+e.getFacultad()
                    +"' WHERE CEDULA='"+ced+"';";
                System.out.println(comando);
                st.executeUpdate(comando);
        } catch (SQLException x) {
            System.out.println(x.getMessage());
        } finally {
            Conex.closeConexion();
        }
    }
    
    public static Usuario getUsuario(String ced){        
        Conexion Conex = new Conexion();
        Usuario lb = null;
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios WHERE CEDULA='"+ced+"';");
            if(resultado.next()){
                lb = Molde(resultado);
            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
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
    
    public static DefaultTableModel TablaBusquedaCed(String ced, String clave){
        ArrayList<Usuario> listaE = new ArrayList<Usuario>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios WHERE CEDULA LIKE '"+ced+"%';");
            while(resultado.next()){
                listaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conex.closeConexion();
        }
        
        if(clave.equals("Completa")){
            return TablaPanelUsuario(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public static DefaultTableModel TablaBusquedaVarios(String ced, String clave){
        ArrayList<Usuario> listaE = new ArrayList<Usuario>();
        
        Conexion Conex = new Conexion();
        try {
            Connection con = Conex.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios "
                    + "WHERE CEDULA LIKE '"+ced+"%' OR NOMBRE LIKE '"+ced+"%' OR APELLIDOP LIKE '"+ced+"%' OR APELLIDOM LIKE'"+ced+"%' OR CARRERA LIKE '"+ced+"%' OR FACULTAD LIKE '"+ced+"%';");
            while(resultado.next()){
                listaE.add(Molde(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            Conex.closeConexion();
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
