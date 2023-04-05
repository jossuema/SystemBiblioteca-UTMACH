/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import com.mycompany.controlador.TListaLibros;
import com.mycompany.controlador.cFecha;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author negri
 */
public class Reporte {

    public Reporte(String Cedula, String IDLibro, Date fechaSalida, Date fechaEntrega, boolean Devuelto, int Retraso, String Nota, int id) {
        this.Cedula = Cedula;
        this.IDLibro = IDLibro;
        this.fechaSalida = fechaSalida;
        this.fechaEntrega = fechaEntrega;
        this.Devuelto = Devuelto;
        this.Retraso = Retraso;
        this.Nota = Nota;
        this.ID = id;
    }
    
    private String Cedula;
    private String IDLibro;
    private Date fechaSalida;
    private Date fechaEntrega;
    private boolean Devuelto;
    private int Retraso;
    private int ID;
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public String DiasRetraso(){
        if(!Devuelto){
            long dias = cFecha.DiasDiferencia(cFecha.FechaActual(), fechaEntrega);
            System.out.println(dias);
            if(dias<1){
                return "A tiempo";
            }else{
                return (dias+" Dias");
            }
            
        }
        return (Retraso+" Dias");
    }
    
    public void Devolver(){
        this.Devuelto = true;
        
        TListaLibros.getLibro(IDLibro).aumentarStock(1);
        long dias = cFecha.DiasDiferencia(cFecha.FechaActual(), fechaEntrega);
        if(dias>0){
            this.Retraso = (int) dias;
        }else{
            this.Retraso = 0;
        }
    }
    
    public int getRetraso() {
        return Retraso;
    }

    public void setRetraso(int Retraso) {
        this.Retraso = Retraso;
    }
    
    
    public boolean getDevuelto() {
        return Devuelto;
    }
    
    public String Estado(){
        if(Devuelto){
            return "Devuelto";
        }
        return "No devuelto";
    }

    public void setDevuelto(boolean Devuelto) {
        this.Devuelto = Devuelto;
    }
    
    private String Nota;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(String IDLibro) {
        this.IDLibro = IDLibro;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }
    
    public Reporte() {
    }

    public Reporte(String Cedula, String IDLibro, Date fechaSalida, Date fechaEntrega, String Nota){
        this.Cedula = Cedula;
        this.IDLibro = IDLibro;
        this.fechaSalida = fechaSalida;
        this.fechaEntrega = fechaEntrega;
        this.Nota = Nota;
        this.Retraso = 0;
        this.Devuelto = false;
    }
}
