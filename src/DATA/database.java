/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class database {
    Connection conexion = null;
    String password = "maikol12"; //contraseña de base de datos
    String user = "sa";// usuario de base de datosº
    String url = "jdbc:sqlserver://DESKTOP-OG4JPI7:1433;database=habitacion";
    
    public Connection conexion() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Conexion realizada");
        } catch (SQLException ex) {
           // System.out.println("Error en la conexion a la BD : " + ex);
        }
        return conexion;
    }
    public void guardar_datos(String piso,String tipo,String nhabita,String codi,String ncama,String estado,Date fecha,String observa, Double precio) 
    {
        conexion(); 
        int registros;
        PreparedStatement sentencia = null;
        String sentenciaSQL = "INSERT INTO habitacion (piso_habit, tipo_habit, numero_habit, codigo_habit, estado_habit, fecha_habit, observacion_habit , precio_habit, cama_habit) VALUES (?,?,?,?,?,?,?,?,?)";
      
        try { 
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, piso);
            sentencia.setString(2, tipo);
            sentencia.setString(3, nhabita);
            sentencia.setString(4, codi);
            sentencia.setString(5, estado);
            sentencia.setDate(6, fecha);
            sentencia.setString(7, observa);
            sentencia.setDouble(8, precio);
            sentencia.setString(9, ncama);
            registros = sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRO COMPLETO");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL REGISTRO: " + ex);
        }

    }
    
}
