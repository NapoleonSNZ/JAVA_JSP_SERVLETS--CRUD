/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/*@author NaPo*/

public class Conexion {
    
    //son 4 Constantes que se hacen en la clase conexion 
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="2512";
    private static BasicDataSource dataSource;
    
    //Creamos los metodos del DataSource
    public static DataSource getDataSource(){
        //si el dataSource No existe hará esto
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }
        //sino retornará del dataSource directamente
        return dataSource;
    }
    
    //Metodo para DEVOLVER la Conexion 
     public static Connection getConnection() throws SQLException{
         return getDataSource().getConnection();
     }
    
    //Métodos para CERRAR la Conexion 
    public static void Close(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void Close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void Close(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
