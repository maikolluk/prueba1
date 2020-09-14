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
    
}
