package gui.estudiantes;

import gui.cursos.Curso;
import gui.inicio.Inicio;
import java.awt.Color;
import javax.swing.JOptionPane;
import proyectobd.ConsultasSQL;


public class IniSesEstu extends javax.swing.JFrame {

    private static int intentos = 0;
   
    public IniSesEstu() {
        initComponents();
        this.setResizable(false);
        this.setTitle("ITA");   
        this.setLocationRelativeTo(null);    
        
    }
    
    private void borrarFormulario() {
        
        jTextFieldNumeroControl.setText("");
        jPasswordFieldContraseña.setText("");
        jTextFieldNumeroControl.requestFocus();
    }
    
    
    private void ingresar() {
        
        String numeroControl = jTextFieldNumeroControl.getText();
        String NIP = String.valueOf(jPasswordFieldContraseña.getPassword());
        String info[] = ConsultasSQL.logearseAlumnos(numeroControl);
        
        if (info != null){
        
            if (info[1].equals(numeroControl)) {
            
            if (info[2].equals(NIP)) {
                
                JOptionPane.showMessageDialog(null, "Sistema: Bienvenido " + numeroControl, "ITA: Login", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                Curso curso = Curso.getInstancia();
                curso.setVisible(true);

            } else {
                
                intentos++;
                
                if (intentos == 3) {
                    
                    JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "ITA: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);

                }
                JOptionPane.showMessageDialog(null, "Numero de control o NIP incorrecto", "ITA: Login", JOptionPane.ERROR_MESSAGE);
                borrarFormulario();
            }

        }
        else {
            intentos++;
            
            if (intentos == 3) {
                JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "ITA: Login", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            JOptionPane.showMessageDialog(null, "Alumno No escontrado", "AgendITA: Login", JOptionPane.ERROR_MESSAGE);
            borrarFormulario();   
            }    
            
            } else {

                intentos++;
                
                if (intentos == 3) {
                    JOptionPane.showMessageDialog(null, "Número máximo de intentos excedido", "ITA: Login", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);

                }
                JOptionPane.showMessageDialog(null, "Alumno No encontrado", "ITA: Login", JOptionPane.ERROR_MESSAGE);
                borrarFormulario();
            }
        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextFieldNumeroControl = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(105, 180, 255));

        jButton1.setBackground(new java.awt.Color(105, 180, 255));
        jButton1.setText("Aceptar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldNumeroControl.setBackground(new java.awt.Color(105, 180, 255));
        jTextFieldNumeroControl.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Número de Control:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jTextFieldNumeroControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldNumeroControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldNumeroControlMouseExited(evt);
            }
        });
        jTextFieldNumeroControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroControlActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ITA1.jpg"))); // NOI18N
        jLabel1.setText("iconoita");

        jButton2.setBackground(new java.awt.Color(105, 180, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Atras.png"))); // NOI18N
        jButton2.setToolTipText("Atras.");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordFieldContraseña.setBackground(new java.awt.Color(105, 180, 255));
        jPasswordFieldContraseña.setText("jPasswordField1");
        jPasswordFieldContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Contraseña: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPasswordFieldContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordFieldContraseñaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordFieldContraseñaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumeroControl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldNumeroControl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ingresar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNumeroControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroControlActionPerformed
                                         
           
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Inicio inic = new Inicio();
        inic.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldNumeroControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNumeroControlMouseEntered
        jTextFieldNumeroControl.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTextFieldNumeroControlMouseEntered

    private void jTextFieldNumeroControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNumeroControlMouseExited
        jTextFieldNumeroControl.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextFieldNumeroControlMouseExited

    private void jPasswordFieldContraseñaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseñaMouseEntered
        jPasswordFieldContraseña.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jPasswordFieldContraseñaMouseEntered

    private void jPasswordFieldContraseñaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseñaMouseExited
        jPasswordFieldContraseña.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPasswordFieldContraseñaMouseExited
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniSesEstu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniSesEstu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniSesEstu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniSesEstu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniSesEstu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JTextField jTextFieldNumeroControl;
    // End of variables declaration//GEN-END:variables
}
