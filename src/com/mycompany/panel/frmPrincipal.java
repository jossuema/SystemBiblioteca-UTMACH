/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.panel;

import com.mycompany.controlador.Global;
import com.mycompany.controlador.cFecha;
import com.mycompany.controlador.cargarDatos;
import java.awt.CardLayout;
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author negri
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        cargarDatos.principal();
        
        //String date = "12/11/2022";
        //System.out.println(new Date(2022, 11, 12).toGMTString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        panelFondo = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1650, 1030));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(24, 38, 73));
        jPanel3.setMinimumSize(new java.awt.Dimension(1650, 130));
        jPanel3.setPreferredSize(new java.awt.Dimension(1650, 130));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel3KeyReleased(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(24, 38, 73));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(24, 38, 73));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/img/UTMACH.jpg"))); // NOI18N
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(1198, 130));
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1629, 140));

        menu.setBackground(new java.awt.Color(24, 38, 73));
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setAlignmentY(130.0F);
        menu.setMinimumSize(new java.awt.Dimension(300, 900));
        menu.setPreferredSize(new java.awt.Dimension(300, 900));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Reportes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        menu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 160, 70));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Usuarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        menu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 160, 70));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 160, 70));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Libros");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        menu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 160, 70));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Devolucion");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        menu.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 160, 70));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Prestamos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        menu.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 160, 70));

        panelCentral.setAlignmentX(300.0F);
        panelCentral.setAlignmentY(130.0F);
        panelCentral.setMinimumSize(new java.awt.Dimension(1350, 900));
        panelCentral.setPreferredSize(new java.awt.Dimension(1350, 900));
        panelCentral.setLayout(new java.awt.CardLayout());

        image.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        image.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        title.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        title.setText("Bienvenido");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel3.setText("Sistema de Gestión para Biblioteca de la UTMACH. Controle y administre de");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel5.setText("Esta herramienta le permitirá llevar un control completo y detallado de Biblioteca,");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setText("forma óptima y fácil el flujo de préstamos y devoluciones de Libros. ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel6.setText("tendrá acceso a herramientas especiales para tareas específicas, como lo son:");

        jLabel12.setText("      ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/img/librox.png"))); // NOI18N
        jLabel1.setText("    ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel11.setText("• Sección de Reportes de acciones en el sistema");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel13.setText("• Préstamos");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel7.setText("• Devoluciones");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel8.setText("• Registro de Usuarios y Libros Nuevos");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel9.setText("• Edición de Usuarios y Libros existentes");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel10.setText("• Eliminar todo tipo de Registros");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/img/librox.png"))); // NOI18N
        jLabel14.setText("             ");

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(569, 569, 569))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(259, 259, 259))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(733, 733, 733)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        panelCentral.add(panelFondo, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        //eliminar los dos caracteres del final del path
        path=path.substring(0,path.length()-2);
       
        path+="\\src\\com\\mycompany\\img\\logop.jpg";
        System.out.println("Path del Proyecto " + path);
        ImageIcon icon = new ImageIcon(path);
        setIconImage(icon.getImage());
        
        setExtendedState(this.getExtendedState() | frmPrincipal.MAXIMIZED_BOTH);
        panelCentral.add(panelFondo, "Fondo");
        panelCentral.add(new Libros(),"Libros");
        panelCentral.add(new panelUsuarios(), "Usuarios");
        panelCentral.add(new panelReporte(),"Reporte");
        panelCentral.add(new panelRegistro(),"Registro");
        panelCentral.add(new prestamo(),"Prestamo");
        panelCentral.add(new Devolucion(), "Devolucion");
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Reporte");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Usuarios");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Registro");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Libros");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Fondo");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jPanel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Devolucion");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            CardLayout cl = (CardLayout)(panelCentral.getLayout());
            cl.show(panelCentral, "Prestamo");
        }catch(Exception ex){}
        panelCentral.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
