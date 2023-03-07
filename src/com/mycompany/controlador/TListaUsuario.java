/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.entidades.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negri
 */
public class TListaUsuario {
    public static ArrayList<Usuario> lista = new ArrayList<Usuario>();
    
    public static void Eliminar(int i){
        lista.remove(i);
    }
    
    public static void Agregar(Usuario e){
        lista.add(e);
    }
    
    public static void Editar(Usuario e, int i){
        lista.set(i, e);
    }
    
    public static int Buscar(String ced){
        for (int i = 0; i < lista.size(); i++) {
            Usuario get = lista.get(i);
            if(get.getCedula().equals(ced)){
                return i;
            }
        }
        return -1;
    }
    
    public static Usuario getUsuario(int i){
        return lista.get(i);
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
        for (int i = 0; i < lista.size(); i++) {
            Usuario e = lista.get(i);
            if(e.getCedula().toLowerCase().startsWith(ced)){
                listaE.add(e);
            }
        }
        if(clave.equals("Completa")){
            return TablaPanelUsuario(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public static DefaultTableModel TablaBusquedaVarios(String ced, String clave){
        ArrayList<Usuario> listaE = new ArrayList<Usuario>();
        for (int i = 0; i < lista.size(); i++) {
            Usuario e = lista.get(i);
            if(e.getNombre().toLowerCase().startsWith(ced)||e.getApellidoP().toLowerCase().startsWith(ced)||e.getCarrera().toLowerCase().startsWith(ced)){
                listaE.add(e);
            }
        }
        if(clave.equals("Completa")){
            return TablaPanelUsuario(listaE);
        }
        return TablaCuatroColumnas(listaE);
    }
    
    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    //nombre del archivo csv
    public static String path = Global.getPath() + "data\\dataUsuario.csv";

    public static void leer() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            System.out.println("Datos del archivo: ");
            String line = br.readLine();
            System.out.println(line);
            lista.clear(); //limpiar lista de objetos del arreglo
            line = br.readLine();
            while (line != null) {
                String[] row = line.split(SEPARADOR);
                removeTrailingQuotes(row);
                Usuario ob = new Usuario(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
                Agregar(ob);//agregar a la lista	           
                System.out.println(Arrays.toString(row));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } finally {
            if (null != br) {
                br.close();
            }
        }
    }

    //eliminar comillas
    private static String[] removeTrailingQuotes(String[] fields) {
        String result[] = new String[fields.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }

    public static void guardar() throws IOException {
        FileWriter file;
        try {
            file = new FileWriter(path);
            final String NEXT_LINE = "\n";
            file.append("Cedula").append(SEPARADOR);
            file.append("Nombre").append(SEPARADOR);
            file.append("ApellidoP").append(SEPARADOR);
            file.append("ApellidoM").append(SEPARADOR);
            file.append("Domicilio").append(SEPARADOR);
            file.append("Telefono").append(SEPARADOR);
            file.append("Carrera").append(SEPARADOR);
            file.append("Facultad").append(NEXT_LINE);

            for (int i = 0; i < lista.size(); i++) {
                Usuario ob = (Usuario) lista.get(i);
                file.append(ob.getCedula()).append(SEPARADOR);
                file.append(ob.getNombre()).append(SEPARADOR);
                file.append(ob.getApellidoP()).append(SEPARADOR);
                file.append(ob.getApellidoM()).append(SEPARADOR);
                file.append(ob.getDomicilio()).append(SEPARADOR);
                file.append(ob.getTelefono()).append(SEPARADOR);
                file.append(ob.getCarrera()).append(SEPARADOR);
                file.append(ob.getFacultad()).append(NEXT_LINE);
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
