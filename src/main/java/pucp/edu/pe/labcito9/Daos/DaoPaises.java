package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BPaises;

import java.sql.*;
import java.util.ArrayList;

public class  DaoPaises extends BaseDao{

    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/lab9?serverTimezone=America/Lima";

    public ArrayList<BPaises> obtenerListaPaises(String filter) {
        ArrayList<BPaises> listaPaises = new ArrayList<>();
        String sentenciaSQL = "select * from paises p where p.continente like ? order by p.nombre;";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            String filtro = "%" + filter + "%";
            pstmt.setString(1,filtro);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int idPais=rs.getInt(1);
                String nombrePais = rs.getString(2);
                String nombreContinente = rs.getString(3);
                int poblacion = rs.getInt(4);
                double tamanio = rs.getInt(5);
                listaPaises.add(new BPaises(idPais,nombrePais,nombreContinente,poblacion,tamanio));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaPaises;
    }

    public void actualizarPais(int idPais, String nombre, int poblacion, double tamanio) {


        String sentenciaSQL = "update paises set nombre = ?, poblacion = ?, tamanio = ? where idpais = ?";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2,poblacion);
            pstmt.setDouble(3,tamanio);
            pstmt.setInt(4,idPais);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirPais(String nombrePais, String continentePais,int poblacion,double tamanio ){

        System.out.println("Entre a anadir pais");
        String sentenciaSQL = "insert into paises (nombre,continente,poblacion,tamanio)\n" +
                "values (?,?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,nombrePais);
            pstmt.setString(2,continentePais);
            pstmt.setInt(3,poblacion);
            pstmt.setDouble(4,tamanio);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void eliminarPais(int idPais) {


        String sentenciaSQL = "delete from paises where idpais = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setInt(1, idPais);
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public BPaises obtenerPaisPorId(String idPais){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sentenciaSQL = " SELECT * FROM paises WHERE idpais = ?;";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,idPais);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id_pais = rs.getInt(1);
                    String nombre = rs.getString(2);
                    int poblacion = rs.getInt(4);
                    double tamanio = rs.getDouble(5);
                    return new BPaises(id_pais,nombre,poblacion,tamanio);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
