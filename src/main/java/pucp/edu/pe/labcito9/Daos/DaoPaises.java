package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BPaises;

import java.sql.*;
import java.util.ArrayList;

public class DaoPaises {

    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/lab9?serverTimezone=America/Lima";

    public ArrayList<BPaises> obtenerListaPaises(String filter) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<BPaises> listaPaises = new ArrayList<>();
        String sentenciaSQL = "select p.nombre, p.continente, p.poblacion, p.tamanio from paises p where p.continente like ?;";
        try(Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            String filtro = "%" + filter + "%";
            pstmt.setString(1,filtro);
            ResultSet rs = pstmt.executeQuery();
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

    public void actualizarPais(BPaises pais) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sentenciaSQL = "update paises set nombre = ?, poblacion = ?, tamanio = ? where idpais = ?";


        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.setString(1, pais.getNombre());
            pstmt.setInt(2,pais.getPoblacion());
            pstmt.setDouble(3,pais.getTamanio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirPais(String nombrePais, String continentePais,int poblacion,double tamanio ) throws  SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sentenciaSQL = "insert into paises (nombre,continente,poblacion,tamanio)\n" +
                "values (?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,nombrePais);
            pstmt.setString(2,continentePais);
            pstmt.setInt(3,poblacion);
            pstmt.setDouble(4,tamanio);
            pstmt.executeUpdate();

        } /*catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    public void eliminarPais(String idPais) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sentenciaSQL = "delete from paises where idpais = ?;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setString(1, idPais);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
