/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.entidades.Libro;
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
    
    
    
    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    //nombre del archivo csv
    public static String path = Global.getPath() + "data\\dataLibros.csv";

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
                Libro ob = new Libro(
                        row[0], row[1], cFecha.crearFecha(row[2])
                        , row[3], row[4], row[5], row[6], Integer.valueOf(row[7]), row[8], Integer.valueOf(row[9]), Boolean.valueOf(row[10]));
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
            file.append("ID").append(SEPARADOR);
            file.append("Titulo").append(SEPARADOR);
            file.append("Fecha").append(SEPARADOR);
            file.append("Autor").append(SEPARADOR);
            file.append("Categoria").append(SEPARADOR);
            file.append("Edicion").append(SEPARADOR);
            file.append("Idioma").append(SEPARADOR);
            file.append("Paginas").append(SEPARADOR);
            file.append("Descripcion").append(SEPARADOR);
            file.append("Stock").append(SEPARADOR);
            file.append("Disponible").append(NEXT_LINE);

            for (int i = 0; i < lista.size(); i++) {
                Libro ob = (Libro) lista.get(i);
                file.append(ob.getID()).append(SEPARADOR);
                file.append(ob.getTitulo()).append(SEPARADOR);
                file.append(cFecha.ImprimirFecha(ob.getFecha())).append(SEPARADOR);
                file.append(ob.getAutor()).append(SEPARADOR);
                file.append(ob.getCategoria()).append(SEPARADOR);
                file.append(ob.getEdicion()).append(SEPARADOR);
                file.append(ob.getIdioma()).append(SEPARADOR);
                file.append(String.valueOf(ob.getPaginas())).append(SEPARADOR);
                file.append(ob.getDescripcion()).append(SEPARADOR);
                file.append(String.valueOf(ob.getStock())).append(SEPARADOR);
                file.append(String.valueOf(ob.getDisponible())).append(NEXT_LINE);
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    
}
