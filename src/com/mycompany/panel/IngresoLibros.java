/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.panel;

import com.mycompany.controlador.TListaLibros;
import com.mycompany.controlador.Validaciones;
import com.mycompany.entidades.Libro;
import java.awt.Color;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Nandobot
 */
public class IngresoLibros extends javax.swing.JPanel {

    /**
     * Creates new form IngresoLibros
     */
    
    String funcion;
    String CedG;
    public IngresoLibros(String fun) {
        initComponents();
        this.funcion = fun;
        if(funcion.equals("Editar")){
            jLabel1.setText("EDITAR LIBRO");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        langLbl = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        pagsLbl = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        descLbl = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        stockLbl = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        titleLbl = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        dateLbl = new javax.swing.JLabel();
        authorLbl = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        catLbl = new javax.swing.JLabel();
        edLbl = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        dispLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();
        langLbl1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        boxCategoria = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setMinimumSize(new java.awt.Dimension(1350, 900));
        setPreferredSize(new java.awt.Dimension(1350, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1350, 920));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 920));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 1074, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 90, 4, 589));

        langLbl.setText("Idioma");
        jPanel1.add(langLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 91, 465, 51));

        txtIdioma.setToolTipText("");
        txtIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdiomaActionPerformed(evt);
            }
        });
        txtIdioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdiomaKeyReleased(evt);
            }
        });
        jPanel1.add(txtIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 465, 40));

        pagsLbl.setText("Páginas");
        jPanel1.add(pagsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 242, 50));

        txtPaginas.setToolTipText("");
        txtPaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaginasKeyReleased(evt);
            }
        });
        jPanel1.add(txtPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 465, 40));

        descLbl.setText("Descripción");
        jPanel1.add(descLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 259, 40));

        txtDescripcion.setToolTipText("");
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 465, 40));

        stockLbl.setText("Stock");
        stockLbl.setToolTipText("");
        jPanel1.add(stockLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 439, 126, -1));

        txtStock.setToolTipText("");
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockKeyReleased(evt);
            }
        });
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 220, 40));

        titleLbl.setText("Título");
        jPanel1.add(titleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 529, 40));

        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTituloKeyReleased(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 529, 40));

        dateLbl.setText("Fecha de Publicación");
        jPanel1.add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 529, 40));

        authorLbl.setText("Autor");
        jPanel1.add(authorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 529, 40));

        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutorKeyReleased(evt);
            }
        });
        jPanel1.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 529, 40));

        catLbl.setText("Categoría");
        jPanel1.add(catLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 529, 40));

        edLbl.setText("Edición");
        jPanel1.add(edLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 529, 40));

        txtEdicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdicionKeyReleased(evt);
            }
        });
        jPanel1.add(txtEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 529, 40));

        dispLbl.setText("Disponibilidad");
        jPanel1.add(dispLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 439, 158, -1));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 200, 70));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 190, 70));

        title1.setFont(new java.awt.Font("Wide Latin", 3, 36)); // NOI18N
        title1.setText("AGREGAR NUEVO LIBRO");
        jPanel1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 20, 1070, 64));

        langLbl1.setText("ID");
        jPanel1.add(langLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 465, 30));

        txtID.setToolTipText("");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 530, 40));

        jRadioButton1.setText("Disponible");
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyReleased(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, -1, -1));

        jRadioButton2.setText("No disponible");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, -1, -1));

        boxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Informatica", "Ciencias Naturales", "Ciencias Sociales", "Fisica", "Matematica", "Literatura", "Otro", " " }));
        boxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxCategoriaKeyReleased(evt);
            }
        });
        jPanel1.add(boxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 530, 40));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 530, 50));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdiomaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        if(Validaciones.esCedula(txtID)){
            Validaciones.pinta_text(txtID);
        }
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyReleased
        if(Validaciones.esLetras(txtTitulo))
            Validaciones.pinta_text(txtTitulo);
    }//GEN-LAST:event_txtTituloKeyReleased

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        if(Validaciones.esRequerido(jDateChooser1))
            Validaciones.pinta_text(jDateChooser1);
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void txtAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyReleased
        if(Validaciones.esLetras(txtAutor))
            Validaciones.pinta_text(txtAutor);
    }//GEN-LAST:event_txtAutorKeyReleased

    private void boxCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxCategoriaKeyReleased
        if(Validaciones.comboBox(boxCategoria))
            Validaciones.pinta_text(boxCategoria);
    }//GEN-LAST:event_boxCategoriaKeyReleased

    private void txtEdicionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdicionKeyReleased
        if(Validaciones.esLetras(txtEdicion))
            Validaciones.pinta_text(txtEdicion);
    }//GEN-LAST:event_txtEdicionKeyReleased

    private void txtIdiomaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdiomaKeyReleased
        if(Validaciones.esLetras(txtIdioma))
            Validaciones.pinta_text(txtIdioma);
    }//GEN-LAST:event_txtIdiomaKeyReleased

    private void txtPaginasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginasKeyReleased
        if(Validaciones.esNumero(txtPaginas))
            Validaciones.pinta_text(txtPaginas);
    }//GEN-LAST:event_txtPaginasKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        if(Validaciones.esLetras(txtDescripcion))
            Validaciones.pinta_text(txtDescripcion);
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyReleased
        if(Validaciones.esNumero(txtStock))
            Validaciones.pinta_text(txtStock);
    }//GEN-LAST:event_txtStockKeyReleased

    private void jRadioButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyReleased
        if(!(jRadioButton1.isSelected()||jRadioButton2.isSelected())){
            jRadioButton1.setBorder(BorderFactory.createLineBorder(Color.red));
            jRadioButton1.setBackground(Color.pink);
            jRadioButton2.setBorder(BorderFactory.createLineBorder(Color.red));
            jRadioButton2.setBackground(Color.pink);
        }else{
            jRadioButton1.setBorder(BorderFactory.createLineBorder(Color.gray));
            jRadioButton1.setBackground(Color.white);
            jRadioButton2.setBorder(BorderFactory.createLineBorder(Color.gray));
            jRadioButton2.setBackground(Color.white);
        }
            
    }//GEN-LAST:event_jRadioButton1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(Validacion()){
            String id = txtID.getText();
            String titulo = txtTitulo.getText();
            Date dt = jDateChooser1.getDate();
            String autor = txtAutor.getText();
            String categoria = boxCategoria.getSelectedItem().toString();
            String edicion = txtEdicion.getText();
            String idioma = txtIdioma.getText();
            int paginas = Integer.valueOf(txtPaginas.getText());
            String descripcion = txtDescripcion.getText();
            int stock = Integer.parseInt(txtStock.getText());
            boolean disponible = jRadioButton1.isSelected();
            
            Libro e = new Libro(id, titulo, dt, autor, categoria, edicion, idioma, paginas, descripcion, stock, disponible);
            
            if(funcion.equals("Ingreso")){
                TListaLibros.Agregar(e);
            }else{
                TListaLibros.Editar(e, TListaLibros.Buscar(CedG));
                this.hide();
            }
            Libros.Listar();
            
            try{
                TListaLibros.guardar();
            }catch(Exception ex){}
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void setDatos(Libro e){
        CedG = String.valueOf(e.getID());
        txtID.setText(String.valueOf(e.getID()));
        txtTitulo.setText(e.getTitulo());
        txtAutor.setText(e.getAutor());
        txtEdicion.setText(e.getEdicion());
        txtIdioma.setText(e.getIdioma());
        txtDescripcion.setText(e.getDescripcion());
        jDateChooser1.setDate(e.getFecha());
        boxCategoria.setSelectedItem(e.getCategoria());
        txtPaginas.setText(String.valueOf(e.getPaginas()));
        txtStock.setText(String.valueOf(e.getStock()));
        if(e.getDisponible()){
            jRadioButton1.setSelected(true);
        }else{
            jRadioButton2.setSelected(true);
        }
    }
    
    private boolean Validacion(){
        String msj = "Los siguientes campos tienen errores: ";
        boolean ok = true;
        if(!(jRadioButton1.isSelected()||jRadioButton2.isSelected())){
            msj += "Disponibilidad, ";
            ok = false; 
        }
        
        if(jDateChooser1.getDate()==null){
            msj += "Fecha de publicacion, ";
            ok = false;
        }
        
        if(!Validaciones.esCedula(txtID)){
            msj += "ID, ";
            ok = false;
        }
        
        if(!Validaciones.esLetras(txtTitulo)){
            msj += "Titulo, ";
            ok = false;
        }
        
        if(!Validaciones.esLetras(txtAutor)){
            msj += "Autor, ";
            ok = false;
        }
        
        if(!Validaciones.esRequerido(txtEdicion)){
            msj += "Edicion, ";
            ok = false;
        }
        
        if(!Validaciones.esRequerido(txtIdioma)){
            msj += "Idioma, ";
            ok = false;
        }
        
        if(!Validaciones.esLetras(txtDescripcion)){
            msj += "Descripcion, ";
            ok = false;
        }
        
        if(!Validaciones.esNumero(txtPaginas)){
            msj += "Paginas, ";
            ok = false;
        }
        
        if(!Validaciones.esNumero(txtStock)){
            msj += "Stock, ";
            ok = false;
        }
        
        if(!Validaciones.comboBox(boxCategoria)){
            msj += "Categoria, ";
            ok = false;
        }
        
        if(TListaLibros.Buscar(txtID.getText())==-1){
            if(funcion.equals("Ingreso")){
                msj += "Ya existe un libro con el ID: "+txtID.getText();
                ok = false;
            }
        }
        
        if(ok){
            if(funcion.equals("Ingreso")){
                msj = "Libro ingresado correctamente";
            }else{
                msj = "Libro editado correctamente";
            }
        }
        
        JOptionPane.showMessageDialog(null, msj);
        return ok;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLbl;
    private javax.swing.JComboBox<String> boxCategoria;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel catLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel descLbl;
    private javax.swing.JLabel dispLbl;
    private javax.swing.JLabel edLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel langLbl;
    private javax.swing.JLabel langLbl1;
    private javax.swing.JLabel pagsLbl;
    private javax.swing.JLabel stockLbl;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
