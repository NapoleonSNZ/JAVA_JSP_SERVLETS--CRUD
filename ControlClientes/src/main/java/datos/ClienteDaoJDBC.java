
package datos;

import dominio.Cliente;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC {
    
    
    private static final String SQL_SELECT = "SELECT id_cliente,nombre,apellido,email,telefono,saldo FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente,nombre,apellido,email,telefono,saldo FROM cliente WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre,apellido,email,telefono,saldo) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
    
    /*Metodo para LISTAR*/
    public List<Cliente> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        List<Cliente> clientes = new ArrayList<Cliente>();
    
        try {
            conn= Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while(rs.next()){
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
              
              clientes.add(new Cliente(idCliente,nombre,apellido,email,telefono,saldo));
            }
        } catch (Exception e) {
                e.printStackTrace(System.out);
        }finally{
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return clientes;
    }
    
    /*Metodo para BUSCAR*/
    public Cliente buscar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        
        try {
            conn= Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs=stmt.executeQuery();
                rs.next();
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
              
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setEmail(email);
                cliente.setTelefono(telefono);
                cliente.setSaldo(saldo);           
            
        } catch (Exception e) {
                e.printStackTrace(System.out);
        }finally{
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }
        return cliente;
    }
}
