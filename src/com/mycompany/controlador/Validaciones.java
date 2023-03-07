/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author negri
 */
public class Validaciones {
    public static void pinta_text(JComboBox txt)
    {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }
    
    public static void pinta_text(JDateChooser txt)
    {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }
    
    public static void pinta_text(JTextField txt)
    {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }
    
    public static void pinta_text(JTextArea txt)
    {
        txt.setBorder(BorderFactory.createLineBorder(Color.gray));
        txt.setBackground(Color.white);
    }

    //verifica si es requerido
    public static boolean esRequerido(JTextField txt)
    {
        boolean ok=true;
        if (txt.getText().trim().equals(""))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    public static boolean esRequerido(JTextArea txt)
    {
        boolean ok=true;
        if (txt.getText().trim().equals(""))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }
    
    public static boolean esRequerido(JDateChooser txt)
    {
        boolean ok=true;
        if (txt.getDate()==null)
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }
    
    //verifica flotantes
    public static boolean esFlotante(JTextField txt)
    {
        boolean ok=true;
        if (!txt.getText().trim().matches("[0-9]{1,10}[.]{0,1}[0-9]{0,}"))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;

         /*
         //otro m�todo
        try{
            Double d=Double.parseDouble(txt.getText());
            return true;
        }catch(Exception ex){
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
        }
        return false;
        */
    }

    //verifica si es email
    public static boolean esEmail(JTextField txt)
    {
        boolean ok=true;
        //if (!txt.getText().trim().matches("[a-z]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}[.]{0,1}[a-z]{0,2}"))
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(txt.getText().trim());
        if(!mat.find()){
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    public static boolean esTelefono(JTextField txt)
    {
        boolean ok=true;
        if (!txt.getText().trim().matches("[0-9]{7,13}"))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    public static boolean esCedula(JTextField txt)
    {
        boolean ok=true;
        if(!((txt.getText().trim().length()==10)||(txt.getText().trim().length()==13))){
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    public static boolean esLetras(JTextField txt)
    {
        boolean ok=true;
        if (!txt.getText().trim().matches("[a-zA-Z������������ ]{1,}"))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }
    
    public static boolean esLetras(JTextArea txt)
    {
        boolean ok=true;
        if (!txt.getText().trim().matches("[a-zA-Z������������ ]{1,}"))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    //verifica n�meros
    public static boolean esNumero(JTextField txt)
    {
        boolean ok=true;
        if (!txt.getText().trim().matches("[0-9]{1,}"))
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }
    
    public static boolean comboBox(JComboBox txt)
    {
        boolean ok=true;
        if (txt.getSelectedIndex()==0)
        {
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }

    //verifica
    public static boolean esFecha(JTextField txt)
    {
        boolean ok=true;
        try{
            Date d= java.sql.Date.valueOf(txt.getText());
            //Formato (yyyy-[m]m-[d]d)
        }catch(Exception ex){
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setBackground(Color.pink);
            ok=false;
        }
        return ok;
    }
}
