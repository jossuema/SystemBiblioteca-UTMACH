/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author negri
 */
public class Conexion {
    private static Connection conexion = null;
    private static final String user = "root";
    private static final String psw = "Root800#";
    private static final String url = "jdbc:mysql://localhost:3306/dblibreria";
    private static BasicDataSource dataSource = null;
    
    public Conexion(){}
    
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(psw);
            dataSource.setInitialSize(10);
        }
        return dataSource;
    }
    
    public static Connection obtenerConexion()throws SQLException{ 
        return getDataSource().getConnection();
    }
    
    public static void closeConexion() throws SQLException{
        conexion.close();
    }
}
