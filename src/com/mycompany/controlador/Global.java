/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.io.File;

/**
 *
 * @author negri
 */
public class Global {
     public static String getPath(){
        //extraer ruta del proyecto de forma din�mica
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        //eliminar los dos caracteres del final del path
        path=path.substring(0,path.length()-2);
       
        path+="\\src\\com\\mycompany\\";
        return path;
    }
}
