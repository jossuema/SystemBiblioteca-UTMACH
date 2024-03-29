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
        return new Date(ld.getYear()-1900, ld.getMonthValue()-1, ld.getDayOfMonth());
    }
    
    /*
        lb[2] = Year
        lb[1] = Month
        lb[0] = Date
    */
    public static Date crearFecha(String date){
        String[] lb = date.split("-");
        return new Date(Integer.parseInt(lb[2])-1900, Integer.parseInt(lb[1])-1, Integer.parseInt(lb[0]));
    }
    
    public static long DiasDiferencia(Date primera, Date segunda){
        long elapsedms = primera.getTime() - segunda.getTime();
        long diff = elapsedms/(1000 * 60 * 60 * 24);
        return diff;
    }
}
