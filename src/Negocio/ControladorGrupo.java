/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import AccesoDatos.GrupoBD;
import Modelo.Grupo;
import java.util.List;

/**
 *
 * @author mingo
 */
public class ControladorGrupo {
    public List<Grupo> obtGrupos()
    {
        try 
        {
            GrupoBD obj = new GrupoBD();
            return obj.obtGrupos();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public Grupo obtAlumno(int id)
    {
        try 
        {
            GrupoBD obj = new GrupoBD();
            return obj.obtAlumno(id);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void insertarAlumno(Grupo g)
    {
        try 
        {
            GrupoBD obj = new GrupoBD();
            obj.insertarAlumno(g);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
