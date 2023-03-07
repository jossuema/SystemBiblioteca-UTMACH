/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.entidades.Reporte;
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
    
    public static final String SEPARADOR = ";";
    public static final String QUOTE = "\"";
    //nombre del archivo csv
    public static String path = Global.getPath() + "data\\dataReporte.csv";

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
                Reporte ob = new Reporte(row[0], row[1], cFecha.crearFecha(row[2]), 
                        cFecha.crearFecha(row[3]), Boolean.valueOf(row[4]), Integer.valueOf(row[5]), "");
                try{
                    ob.setNota(row[6]);
                }catch(Exception ex){
                }
                
                System.out.println("Leyendo reporte");
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
            file.append("IDLibro").append(SEPARADOR);
            file.append("FechaSalida").append(SEPARADOR);
            file.append("FechaEntrega").append(SEPARADOR);
            file.append("Devuelto").append(SEPARADOR);
            file.append("Retraso").append(SEPARADOR);
            file.append("Nota").append(NEXT_LINE);

            for (int i = 0; i < lista.size(); i++) {
                Reporte ob = (Reporte) lista.get(i);
                file.append(ob.getCedula()).append(SEPARADOR);
                file.append(ob.getIDLibro()).append(SEPARADOR);
                file.append(cFecha.ImprimirFecha(ob.getFechaSalida())).append(SEPARADOR);
                file.append(cFecha.ImprimirFecha(ob.getFechaEntrega())).append(SEPARADOR);
                file.append(String.valueOf(ob.getDevuelto())).append(SEPARADOR);
                file.append(String.valueOf(ob.getRetraso())).append(SEPARADOR);
                file.append(String.valueOf(ob.getNota())).append(NEXT_LINE);
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
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
