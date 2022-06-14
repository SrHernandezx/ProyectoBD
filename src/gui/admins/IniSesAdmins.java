package gui.admins;

import gui.inicio.Inicio;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import proyectobd.ConsultasSQL;


public class IniSesAdmins extends javax.swing.JFrame {
    private static int intentos;
        private static IniSesAdmins instancia = null;
    
    public IniSesAdmins() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
    }
    
    public static IniSesAdmins getInstancia(){
        
        synchronized(IniSesAdmins.class){
            
            if (instancia == null) {
                
                instancia = new IniSesAdmins();
            }
        }
        return instancia;
    }
    private void borrarFormulario() {
        
        jTextFieldAdministrador.setText("");
        jPasswordFieldAdministrador.setText("");
        jTextFieldAdministrador.requestFocus();
    }
    
    private void ingresar() {
        
        String usuario = jTextFieldAdministrador.getText();
        String contra = String.valueOf(jPasswordFieldAdministrador.getPassword());
        String info[] = ConsultasSQL.buscarAdministrador(usuario);
        
        if (info != null){
        
        if (info[0].equals(usuario)) {
            
            if (info[1].equals(contra)) {
                
                JOptionPane.showMessageDialog(null, "Sistema: Bienvenido " + usuario, "AgendITA: Login", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                IniSesAdmins menu = IniSesAdmins.getInstancia();
                menu.setVisible(true);

            } else {
                
                intentos++;
                
                if (intentos == 3) {
                    
                    JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "AgendITA: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);

                }
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "AgendITA: Login", JOptionPane.ERROR_MESSAGE);
                borrarFormulario();
            }

        } else {
            intentos++;
            
            if (intentos == 3) {
                JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "AgendITA: Login", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Usuario No escontrado", "AgendITA: Login", JOptionPane.ERROR_MESSAGE);
            borrarFormulario();   
            }    
            
            } else {

                intentos++;
                
                if (intentos == 3) {
                    JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "AgendITA: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);

                }
                JOptionPane.showMessageDialog(null, "Usuario No encontrado", "AgendITA: Login", JOptionPane.ERROR_MESSAGE);
                borrarFormulario();
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAdministrador = new javax.swing.JTextField();
        jPasswordFieldAdministrador = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(105, 180, 255));

        jButton2.setBackground(new java.awt.Color(105, 180, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Atras.png"))); // NOI18N
        jButton2.setToolTipText("Atras.");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ITA1.jpg"))); // NOI18N
        jLabel1.setText("iconoita");

        jTextFieldAdministrador.setBackground(new java.awt.Color(105, 180, 255));
        jTextFieldAdministrador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextFieldAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldAdministradorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldAdministradorMouseExited(evt);
            }
        });
        jTextFieldAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdministradorActionPerformed(evt);
            }
        });

        jPasswordFieldAdministrador.setBackground(new java.awt.Color(105, 180, 255));
        jPasswordFieldAdministrador.setText("jPasswordField1");
        jPasswordFieldAdministrador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Contraseña: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPasswordFieldAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordFieldAdministradorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordFieldAdministradorMouseExited(evt);
            }
        });
        jPasswordFieldAdministrador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldAdministradorKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(105, 180, 255));
        jButton1.setText("Aceptar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jTextFieldAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordFieldAdministrador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(52, 52, 52)))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jPasswordFieldAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Inicio inic = new Inicio();
        inic.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldAdministradorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldAdministradorMouseEntered
        jTextFieldAdministrador.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTextFieldAdministradorMouseEntered

    private void jTextFieldAdministradorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldAdministradorMouseExited
        jTextFieldAdministrador.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldAdministradorMouseExited

    private void jTextFieldAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdministradorActionPerformed

    private void jPasswordFieldAdministradorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldAdministradorMouseEntered
        jPasswordFieldAdministrador.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jPasswordFieldAdministradorMouseEntered

    private void jPasswordFieldAdministradorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldAdministradorMouseExited
        jPasswordFieldAdministrador.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPasswordFieldAdministradorMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ingresar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordFieldAdministradorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldAdministradorKeyTyped
        char car = evt.getKeyChar();
        if (car == KeyEvent.VK_ENTER) {
            ingresar();
        }
    }//GEN-LAST:event_jPasswordFieldAdministradorKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniSesAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniSesAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniSesAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniSesAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniSesAdmins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldAdministrador;
    private javax.swing.JTextField jTextFieldAdministrador;
    // End of variables declaration//GEN-END:variables
}
