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
public class TlistaRegistro {
    public static ArrayList<Registro> lista = new ArrayList<Registro>();
    
    public static void Eliminar(int i){
        lista.remove(i);
    }
    
    public static void Agregar(Registro e){
        lista.add(e);
    }
    
    public static void Editar(Registro e, int i){
        lista.set(i, e);
    }
    
    public static int Buscar(String ced){
        for (int j = 0; j < lista.size(); j++) {
            Registro get = lista.get(j);
            if(get.getPersona().getCedula().equals(ced)){
                return j;
            }
            
        }
        return -1;
    }
    
    public static DefaultTableModel TablaPanelRegistro(ArrayList<Registro> ListaE){
        String[] columnas = {"No.", "Cedula", "Nombre", "Apellido", "Facultad", "Carrera"
                , "Fecha", "Libro prestado"};        
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        
        for (int i = 0; i < ListaE.size(); i++) {
            Registro e = ListaE.get(i);
            Object[] row = {(i+1), e.getPersona().getCedula(), e.getPersona().getNombre(), e.getPersona().getApellidoP(), 
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
        ArrayList<Registro> ListaE =  new ArrayList<Registro>();
        for (int i = 0; i < lista.size(); i++) {
            Registro e = lista.get(i);
            if(e.getFecha().getDate()==fecha.getDay()&&e.getFecha().getMonth()==fecha.getMonth()&&e.getFecha().getYear()==fecha.getYear()){
                ListaE.add(e);
            }
        }
        if(ListaE.size()<1){
            for (int i = 0; i < lista.size(); i++) {
                Registro e = lista.get(i);
                if(e.getFecha().getMonth()==fecha.getMonth()&&e.getFecha().getYear()==fecha.getYear()){
                    ListaE.add(e);
                }
            }
        }
        if(ListaE.size()<1){
            for (int i = 0; i < lista.size(); i++) {
                Registro e = lista.get(i);
                if(e.getFecha().getYear()==fecha.getYear()){
                    ListaE.add(e);
                }
            }    
        }
        return ListaE;
    }
    
    public static ArrayList<Registro> TablaBusquedaVarios(String clave){
        ArrayList<Registro> ListaE =  new ArrayList<Registro>();
        clave = clave.toLowerCase();
        for (int i = 0; i < lista.size(); i++) {
            Registro e = lista.get(i);
            if(e.getPersona().getCedula().toLowerCase().startsWith(clave)
                    ||e.getPersona().getNombre().toLowerCase().startsWith(clave)
                    ||e.getPersona().getApellidoP().toLowerCase().startsWith(clave)
                    ||e.getPersona().getFacultad().toLowerCase().startsWith(clave)
                    ||e.getPersona().getCarrera().toLowerCase().startsWith(clave)){
                ListaE.add(e);
            }
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
    
    public static void leer() throws IOException {
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
    }
    
    public static ArrayList<Registro> ordenamientoBurbuja(){
        ArrayList<Registro> al = lista;
        for (int i = 0; i < al.size() - 1; i++) {
            for (int j = 0; j < al.size() - i - 1; j++) {
                if (al.get(j).getFecha().compareTo(al.get(j+1).getFecha()) < 0) {
                    Registro pe = al.get(j);
                    al.set(j, al.get(j+1));
                    al.set(j+1, pe);
                }
            }
        }
        return al;
    }
}
