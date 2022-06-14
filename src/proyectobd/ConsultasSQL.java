/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jmveg
 */
public class ConsultasSQL {
    
    protected static String baseDeDatos = "jdbc:mysql://127.0.0.1/agendita";
    protected static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection conexion = null;
    public static PreparedStatement pstm = null;
    public static ResultSet rs = null;
    public static boolean conexionActiva = false;
    public static boolean servidorActivo = false;
    
    
    public static void levantarServidorXampp(){
        
        establecerSesion("root", "");
        conexionActiva = true;
        servidorActivo = true;
    }
    public static void establecerSesion(String usuario, String contra){
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(baseDeDatos, usuario, contra);
            conexionActiva = true;
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            conexionActiva = false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            conexionActiva = false;
        }
    }

    
    public static boolean conexionActiva(){
        
        return conexionActiva;
    }
    
    
    public static boolean servidorActivo(){
        
        return servidorActivo;
    }
    
    //Administradores
     public static String[] buscarAdministrador(String administrador){
        
        String[] datos = new String[2];
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT nombre, contra FROM administradores WHERE nombre " + "COLLATE utf8_spanish_ci = \"" + administrador + "\"";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.first();
                
                if(registros != 1){
                    
                    return null;
                    
                } else{
                    
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static Object[] buscarAdministrador (int id_admin){
        
        Object[] datos = new Object[3];
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT * FROM administradores WHERE id_admin = " + id_admin;
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.first();
            
                if(registros != 1){
                    
                    return null;
                    
                }
                else {

                    datos[0] = rs.getObject(1);
                    datos[1] = rs.getObject(2);
                    datos[2] = rs.getObject(3);   
                }
            } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static Object[][] buscarAdministradores(){
        
        Object[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_admin, nombre FROM administradores";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2);     
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }  
    
    
    public static String[][] buscarAdministradores(String administrador){
        
        String[][] datos = null;

        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_admin, nombre FROM administradores WHERE nombre LIKE '%" + administrador + "%'";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new String[registros][2];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getString(1);
                    datos[contador][1] = rs.getString(2);     
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    public static void eliminarAdministrador(int id_admin){
        
        if(conexionActiva){

            try {
                
                String sql = "DELETE FROM administradores WHERE id_admin = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_admin);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al elinar el registro", "Eliminar", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void insertarAdministrador(String nombre, String contra){
        
        if(conexionActiva){

            try {
                
                String sql = "INSERT INTO administradores (nombre, contra) VALUES (?,?)";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombre);
                pstm.setString(2, contra);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente", "ITA: Agregar administrador", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "ITA: Agregar administrador", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    
    public static void modificarAdministrador (int id_admin, String nombre, String contra){
        
        if(conexionActiva){

            try {
                
                String sql = "UPDATE administradores SET " + "nombre = ?, contra = ?" + "WHERE id_admin = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombre);
                pstm.setString(2, contra);
                pstm.setInt(3, id_admin);

                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro modificado exitosamente", "ITA: Modificar administrador", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al modificar el registro", "ITA: administrador", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    //Alumnos
         public static Object [][] buscarAlumnos(){
        
        Object[][] datos = null;
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_alumno, nombres, apellido_paterno, apellido_materno, semestre, carrera , correo, NIP ,numero_control " + "FROM alumnos ";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][9];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    datos[contador][4] = rs.getObject(5);
                    datos[contador][5] = rs.getObject(6);
                    datos[contador][6] = rs.getObject(7);
                    datos[contador][7] = rs.getObject(8);
                    datos[contador][8] = rs.getObject(9);
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    
    
    
    public static Object[][] buscarAlumnos(String alumnos){
        
        Object[][] datos = null;
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT id_alumno, nombres, apellido_paterno, apellido_materno, semestre, carrera , correo, NIP ,numero_control "
                        + "FROM alumnos WHERE nombres LIKE '%" + alumnos + "%' " + "OR apellido_paterno LIKE '%"+ alumnos + "%' " + "OR apellido_materno LIKE '%" + alumnos + "%' ";
               
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.beforeFirst();
                datos = new Object[registros][9];
                int contador = 0;
 
                while(rs.next()){
                    
                    datos[contador][0] = rs.getObject(1);
                    datos[contador][1] = rs.getObject(2); 
                    datos[contador][2] = rs.getObject(3);
                    datos[contador][3] = rs.getObject(4);
                    datos[contador][4] = rs.getObject(5);
                    datos[contador][5] = rs.getObject(6);
                    datos[contador][6] = rs.getObject(7);
                    datos[contador][7] = rs.getObject(8);
                    datos[contador][8] = rs.getObject(9);
                    contador++;
                }
            } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }  
    
    public static String[] logearseAlumnos(String alumnos){
        
        String[] datos = new String[2];
        
        if(conexionActiva){
            
            try {
                
                String sql = "SELECT numero_control, NIP FROM alumnos WHERE nombre " + "COLLATE utf8_spanish_ci = \"" + alumnos + "\"";
                
                pstm = conexion.prepareStatement(sql);
                rs = pstm.executeQuery();
                rs.last();
                int registros = rs.getRow();
                rs.first();
                
                if(registros != 1){
                    
                    return null;
                    
                } else{
                    
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }
    public static void eliminarAlumno(int id_alumno){
        
        if(conexionActiva){

            try {
                
                String sql = "DELETE FROM alumnos WHERE id_alumno = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setInt(1, id_alumno);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el registro", "Eliminar", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void insertarAlumno(int id_alumno, String nombres, String apellido_paterno, String apellido_materno, int semestre, String carrera , String correo, int NIP , int numero_control){
        
        if(conexionActiva){

            try {
                
                String sql = "INSERT INTO alumnos (nombres, apellido_paterno, apellido_materno, semestre, carrera , correo, NIP ,numero_control) VALUES (?,?,?,?,?,?,?,?)";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombres);
                pstm.setString(2, apellido_paterno);
                pstm.setString(3, apellido_materno);
                pstm.setInt(4, semestre);
                pstm.setString(5,carrera);
                pstm.setString(6,correo);
                pstm.setInt(7, NIP);
                pstm.setInt(8, numero_control);
                
                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro insertado exitosamente", "ITA: Agregar administrador", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "El registro no se pudo insertar", "ITA: Agregar administrador", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    
    public static void modificarAlumno (int id_alumno, String nombres, String apellido_paterno, String apellido_materno,
            int semestre, String carrera , String correo, int NIP , int numero_control){
        
        if(conexionActiva){

            try {
                
                String sql = "UPDATE alumnos SET " + "nombres = ?, apellido_paterno = ?, apellido_materno = ?,semestre = ?, carrera = ? , correo = ?, NIP = ? , numero_control = ? " + "WHERE id_alumno = ?";
                
                pstm = conexion.prepareStatement(sql);
                pstm.setString(1, nombres);
                pstm.setString(2, apellido_paterno);
                pstm.setString(3, apellido_materno);
                pstm.setInt(4, semestre);
                pstm.setString(5,carrera);
                pstm.setString(6,correo);
                pstm.setInt(7, NIP);
                pstm.setInt(8, numero_control);;

                int resultado = pstm.executeUpdate();
                
                if(resultado == 1){
                    
                    JOptionPane.showMessageDialog(null, "Registro modificado exitosamente", "ITA: Modificar Alumnos", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al modificar el registro", "ITA: Alumnos", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
}
