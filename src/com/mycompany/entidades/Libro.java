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
public class Libro {
    private String ID;
    private String Titulo;
    private Date Fecha;
    private String Autor;
    private String Categoria;
    private String Edicion;
    private String Idioma;
    private int Paginas;
    private String Descripcion;
    private int Stock;
    private boolean Disponible;

    public String getID() {
        return ID;
    }
    
    public void aumentarStock(int i){
        this.Stock += i;
    }
    
    public void reducirStock(int i){
        this.Stock -= i;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getEdicion() {
        return Edicion;
    }

    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int Paginas) {
        this.Paginas = Paginas;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Libro(String ID, String Titulo, Date Fecha, String Autor, String Categoria, String Edicion, String Idioma, int Paginas, String Descripcion, int Stock, boolean Disponible) {
        this.ID = ID;
        this.Titulo = Titulo;
        this.Fecha = Fecha;
        this.Autor = Autor;
        this.Categoria = Categoria;
        this.Edicion = Edicion;
        this.Idioma = Idioma;
        this.Paginas = Paginas;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Disponible = Disponible;
    }

    public Libro() {
    }
    
}
