/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.util.Date;

/**
 *
 * @author negri
 */
public class Registro {
    private Usuario Persona;
    private Date Fecha;
    private boolean LibroPrestado;

    public Usuario getPersona() {
        return Persona;
    }

    public void setPersona(Usuario Persona) {
        this.Persona = Persona;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Boolean getLibroPrestado() {
        return LibroPrestado;
    }

    public void setLibroPrestado(Boolean LibroPrestado) {
        this.LibroPrestado = LibroPrestado;
    }

    public Registro(Usuario Persona, Date Fecha, boolean LibroPrestado) {
        this.Persona = Persona;
        this.Fecha = Fecha;
        this.LibroPrestado = LibroPrestado;
    }

    public Registro() {
    }
    
}
