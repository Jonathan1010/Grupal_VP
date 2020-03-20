package Modelo;

import Modelo.Alumno;
import static Modelo.AlumnoBD.guardarAlumnoBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class AlumnoBD {
    private static ArrayList<String> Lista;

    public static void guardarAlumnoBD(Alumno alumno) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/alumno", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("insert into alumno values('" + alumno.getCedula()
                    + "','" + alumno.getNombre() + "','" + alumno.getApellido() + "','" + alumno.getTeléfono() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.print("Error en la conexion" + ex);
        }
    }

    public static void eliminar(String cedula) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/alumno", "root", "root");
            System.out.print("Conexion Establecida");
            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("delete from alumno where cedula = '" + cedula + "'");

            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            System.out.print("Error en la conexion" + e);
        }
    }
//
        public static Alumno buscarAlumno(String cedula) {
        Alumno alumno = new Alumno();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/alumno", "root", "root");
            System.out.print("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet buscar = sentencia.executeQuery("select * from alumno where cedula = '" + cedula + "'");
            while (buscar.next()) {
                String Cedula = buscar.getString("Cedula");
                String Nombre = buscar.getString("Nombre");
                String Apellido = buscar.getString("Apellido");
                String Telefono = buscar.getString("Telefono");

                alumno.setCedula(Cedula);
                alumno.setNombre(Nombre);
                alumno.setApellido(Apellido);
                alumno.setTeléfono(Telefono);

            }

            sentencia.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Conexion no establecida" + e);
        }
        //return cedula;
        return alumno;
    

    }
        
  
        
        
    public void actualizarAlumno(Alumno alumno){
             try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/alumno", "root", "root");
            System.out.print("Conexion establecida!");

            Statement sentencia = conexion.createStatement();
            
            int update = sentencia.executeUpdate("update alumno set Cedula = '" + alumno.getCedula() + "'," + "Nombre='" 
                    + alumno.getNombre() + "' , " + "Apellido= '" + alumno.getApellido() + "' , " + "Telefono = '" + alumno.getTeléfono());
                    
                
            sentencia.close();
            conexion.close();
        } catch (Exception t) {
            System.out.print("Error en la conexion" + t);
        }
            
            
            
            
            
            
            
            
        }
        
        public static ArrayList cargar(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/alumno", "root", "root");
            System.out.print("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet buscar = sentencia.executeQuery("select * from estudiante");
            Alumno a;
            Lista = new ArrayList<>();
            while(buscar.next()){
                
                String nombre = buscar.getString("Nombre");
                String apellido = buscar.getString("Apellido");
                
                Lista.add(nombre + "" + apellido);    
                
            }
            sentencia.close();
            conexion.close();
                  
            } catch (Exception l) {               
                System.out.println("Error en la conexion" + l);            
            }
     
        return Lista;  
        }
}


