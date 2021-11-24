package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BPaises;

import java.sql.*;
import java.util.ArrayList;

public class DaoPaises {

    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/lab9?serverTimezone=America/Lima";

    public ArrayList<BPaises> obtenerListaPaises() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<BPaises> listaPaises = new ArrayList<>();
        String sentenciaSQL = "select p.nombre, p.continente, p.poblacion, p.tamanio from paises p where p.continente = ?;";
        try(Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sentenciaSQL)){


            while(rs.next()){
                String nombrePais = rs.getString(2);
                String nombreContinente = rs.getString(3);
                int poblacion = rs.getInt(3);
                double tamanio = rs.getInt(4);
                listaPaises.add(new BPaises(nombrePais,nombreContinente,poblacion,tamanio));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaPaises;
    }


}
