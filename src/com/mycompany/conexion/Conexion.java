/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author negri
 */
public class Conexion {
    private static Connection conexion = null;
    private static String user = "root";
    private static String psw = "#";
    private static String url = "jdbc:mysql://localhost:3306/dblibreria";
    
    public Conexion(){}
    
    public Connection obtenerConexion()throws SQLException{ 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, psw);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
        return conexion;
    }
    
    public static void closeConnexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }
}
