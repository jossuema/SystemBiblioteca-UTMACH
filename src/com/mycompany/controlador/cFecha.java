/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author negri
 */
public class cFecha {
    public static String ImprimirFecha(Date fecha){
        return (fecha.getDate()+"-"+(fecha.getMonth()+1)+"-"+(fecha.getYear()+1900));
    }
    
    public static String FechaSQL(Date fecha){
        String str = "";
        if(fecha.getMonth()<9)str="0";
        return ((fecha.getYear()+1900)+"-"+str+(fecha.getMonth()+1)+"-"+fecha.getDate());
    }
    
    public static Date FechaActual(){
        LocalDate ld = LocalDate.now();
        Date dt = new Date(ld.getYear()-1900, ld.getMonthValue()-1, ld.getDayOfMonth());
        return dt;
    }
    
    public static Date crearFecha(String date){
        String[] lb = date.split("-");
        Date dt = new Date(Integer.valueOf(lb[2])-1900, Integer.valueOf(lb[1])-1, Integer.valueOf(lb[0]));
        return dt;
    }
    
    public static long DiasDiferencia(Date primera, Date segunda){
        long elapsedms = primera.getTime() - segunda.getTime();
        long diff = elapsedms/(1000 * 60 * 60 * 24);
        return diff;
    }
}
