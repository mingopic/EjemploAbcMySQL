/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mingo
 */
public class GrupoBD {
    static ConexionMySQL c;
    static String query;
    static ResultSet rs;
    
    public static List<Grupo> obtGrupos() throws SQLException
    {
        List<Grupo> lstGrupo = new ArrayList<>();   
        c = new ConexionMySQL();
        query = "call obtenerAlumnos";
        
        rs = c.ejecutarConsulta(query);
        
        if (rs.last()) 
        {
            rs.beforeFirst();
            //Recorremos el ResultSet registro a registro
            while (rs.next()) 
            {
                Grupo obj = new Grupo();
                obj.setIdAlumno(rs.getInt("idAlumno"));
                obj.setNombre(rs.getString("nombre"));
                obj.setGrupo(rs.getString("grupo"));
                obj.setPromedio(rs.getDouble("promedio"));
                
                lstGrupo.add(obj);
            }
        }
        
        rs.close();
        c.stmt.close();
        c.desconectar();
        return lstGrupo;
    }
    
    public static Grupo obtAlumno(int id) throws SQLException
    {
        Grupo grupo = new Grupo();
        c = new ConexionMySQL();
        query = "call obtenerAlumnoPorID (" + id + ");" ;
        
        rs = c.ejecutarConsulta(query);
        
        if (rs.last()) 
        {
            rs.beforeFirst();
            //Recorremos el ResultSet registro a registro
            while (rs.next()) 
            {
                grupo.setIdAlumno(rs.getInt("idAlumno"));
                grupo.setNombre(rs.getString("nombre"));
                grupo.setGrupo(rs.getString("grupo"));
                grupo.setPromedio(rs.getDouble("promedio"));
            }
        }
        
        rs.close();
        c.stmt.close();
        c.desconectar();
        return grupo;
    }
    
    public void insertarAlumno(Grupo g) throws SQLException
    {
        c = new ConexionMySQL();
        query = "call insertarAlumno ("
                + "'" + g.getNombre() + "'"
                + ",'" + g.getGrupo() + "'"
                + "," + g.getPromedio() +");";
        
        c.ejecutarInsertUpdate(query);
    }
}
