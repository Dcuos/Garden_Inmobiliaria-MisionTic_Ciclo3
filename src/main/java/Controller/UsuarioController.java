package Controller;

import java.sql.ResultSet;
import java.sql.Statement;
import Beans.Cliente;
import Connection.DBConnection;
import com.google.gson.Gson;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String usuario, String contraseña) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM cliente WHERE usuario = '" + usuario + "' and contraseña = '" + contraseña + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String direccion_cliente = rs.getString("direccion_cliente");
                boolean premium = rs.getBoolean("premium");
                double saldo = rs.getDouble("saldo");
                Cliente cliente = new Cliente(usuario, contraseña, nombres, apellidos, telefono, direccion_cliente, premium, saldo);
                return gson.toJson(cliente);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String register(String usuario, String contraseña, String nombres, String apellidos,
            String telefono, String direccion_cliente, boolean premium, double saldo) {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "INSERT INTO cliente VALUES('"+usuario+"', '"+contraseña+"', '"+nombres+"', '"+apellidos+"', '"+telefono+"', '"+direccion_cliente+"', "+premium+", "+saldo+")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeLargeUpdate(sql);
            
                Cliente cliente = new Cliente(usuario, contraseña, nombres, apellidos, telefono, direccion_cliente, premium, saldo);
                st.close();
                return gson.toJson(cliente);
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";
    }
    @Override
    public String pedir(String usuario){
        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM cliente WHERE usuario = '"+usuario+"'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String contraseña = rs.getString("contraseña");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String direccion_cliente = rs.getString("direccion_cliente");
                boolean premium = rs.getBoolean("premium");
                double saldo = rs.getDouble("saldo");
                Cliente cliente = new Cliente(usuario, contraseña, nombres, apellidos, telefono, direccion_cliente, premium, saldo);
                return gson.toJson(cliente);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";
    }
    
}
