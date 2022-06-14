package proyectobd;

import gui.inicio.Inicio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;


public class ProyectoBD {


    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("\"C:\\xampp\\xampp_start.exe\"");
            p.waitFor();
            
        try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
            }    
            
            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        Inicio inicio = Inicio.getInstancia();
            inicio.setVisible(true);
        
    }   catch (IOException ex) {
            Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProyectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}