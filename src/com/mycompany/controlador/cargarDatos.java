/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.entidades.Libro;
import com.mycompany.entidades.Registro;
import com.mycompany.entidades.Reporte;
import com.mycompany.entidades.Usuario;
import java.util.Date;

/**
 *
 * @author negri
 */
public class cargarDatos {
    
    //Agrega los datos fernan
    
    
    
    public static void principal(){
        /*
        TListaLibros.Agregar(new Libro("1214434656", "Fundamentos de POO en JAVA", new Date(2015-1900, 8, 21), "Bertha Mazon", "Educativo", "1era Edicion", "Español", 166, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1234567891", "Fundamentos de TI", new Date(2015-1900, 8, 21), "Luis Lojan", "Educativo", "1era Edicion", "Español", 200, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1231126373", "Analisis Matematico", new Date(2015-1900, 8, 21), "Maritza Pinta", "Educativo", "1era Edicion", "Español", 100, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1182378912", "Algebra Lineal", new Date(2015-1900, 8, 21), "Maritza Pinta", "Educativo", "1era Edicion", "Español", 250, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1128937198", "Redes Electricas", new Date(2015-1900, 8, 21), "Johnny Novillo", "Educativo", "1era Edicion", "Español", 90, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1144331656", "Fundamentos de Programacion", new Date(2015-1900, 8, 21), "Bertha Mazon", "Educativo", "1era Edicion", "Español", 50, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1172378731", "Base de Datos", new Date(2015-1900, 8, 21), "Jofree Cartuche", "Educativo", "1era Edicion", "Español", 139, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1093289482", "Matematicas Discretas", new Date(2015-1900, 8, 21), "Luis Lojan", "Educativo", "1era Edicion", "Español", 221, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1097834862", "Herramientas de Planificacion de Proyectos", new Date(2015-1900, 8, 21), "Oscar Cardenas", "Educativo", "1era Edicion", "Español", 70, "Libro acerca de POO en JAVA", 20, true));
        TListaLibros.Agregar(new Libro("1893748239", "Comunicacion Academica", new Date(2015-1900, 8, 21), "Bertha Mazon", "Educativo", "1era Edicion", "Español", 145, "Libro acerca de POO en JAVA", 20, true));
        TListaUsuario.Agregar(new Usuario("0192030312", "Josue", "Malla", "Campoverde", "Huaquillas", "0964007642", "TI", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0918237837", "Fernando", "Jaya", "Erraez", "Pasaje", "0964007642", "Civil", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0112378733", "Francisco", "Mujica", "de los Monteros", "Pasaje", "0964007642.0", "Ambiental", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0123878483", "Johnny", "Arica", "Prado", "Pasaje", "0964235642", "TI", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0183278478", "Manuelito", "Hurtado", "Feliscisimo", "Machala", "0967734821.0", "Civil", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0189238943", "Martin", "Peña", "Delfin", "Tumbes", "0917236145", "Ambiental", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0812938748", "Kevin", "Roman", "Armijos", "El Guabo", "0964278347", "TI", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("1028398439", "Pedro", "Ramon", "Sornoza", "Guayakill", "098173267", "Civil", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0138742892", "Moises", "Caicedo", "Corozo", "Santo Domingo", "0916712637", "Ambiental", "Ing. Civil"));
        TListaUsuario.Agregar(new Usuario("0123974782", "Enner", "Valencia", "Lastra", "San Lorenzo", "0981723612", "TI", "Ing. Civil"));
        TListaReporte.Agregar(new Reporte("0192030312", "1214434656", new Date(2022-1900, 1,12), new Date(2022-1900, 1, 13), ""));
        TListaReporte.Agregar(new Reporte("0918237837", "1234567891", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TListaReporte.Agregar(new Reporte("0112378733", "1231126373", new Date(2022-1900, 1,12), new Date(2022-1900, 1, 13), ""));
        TListaReporte.Agregar(new Reporte("0123878483", "1182378912", new Date(2022-1900, 1,12), new Date(2022-1900, 1, 13), ""));
        TListaReporte.Agregar(new Reporte("0183278478", "1128937198", new Date(2022-1900, 1,12), new Date(2022-1900, 1, 13), ""));
        TListaReporte.Agregar(new Reporte("0189238943", "1144331656", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TListaReporte.Agregar(new Reporte("0812938748", "1172378731", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TListaReporte.Agregar(new Reporte("1028398439", "1093289482", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TListaReporte.Agregar(new Reporte("0138742892", "1097834862", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TListaReporte.Agregar(new Reporte("0182938944", "1893748239", new Date(2022-1900, 2, 10), new Date(2022-1900, 2, 15), ""));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(0), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(1), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(2), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(3), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(4), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(5), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(1), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(0), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(2), new Date(2022-1900, 13, 1), true));
        TlistaRegistro.Agregar(new Registro(TListaUsuario.getUsuario(4), new Date(2022-1900, 13, 1), true));
        */
        try{
            TListaLibros.leer();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        try{
            TListaUsuario.leer();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        try{
            TListaReporte.leer();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        try{
            TlistaRegistro.leer();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        
    }
}
