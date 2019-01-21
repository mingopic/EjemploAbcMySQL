/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mingo
 */
public class ConexionMySQL {
    Connection c;
    public Statement stmt;
    
    public ConexionMySQL()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            stmt = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void conectar()
    {
        try {
            if (c == null || c.isClosed())
            {
                c = DriverManager.getConnection("jdbc:mysql://localhost:3307/escuela", "root", "root");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar()
    {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion()
    {
        return c;
    }
    
    public ResultSet ejecutarConsulta(String query) throws SQLException
    {
        ResultSet rs = null;
        
        conectar();
        stmt = getConexion().createStatement();
        rs = stmt.executeQuery(query);
        System.out.println(query);
        
        return rs;
    }
    
    public void ejecutarInsertUpdate(String query) throws SQLException
    {
        conectar();
        PreparedStatement st = getConexion().prepareStatement(query);
        System.out.println(st);
        st.executeUpdate();
        
        desconectar();
    }
}
