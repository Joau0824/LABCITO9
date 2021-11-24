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
        String sentenciaSQL = "select p.nombre, p.continente, p.poblacion, p.tamanio from paises p where p.continente like ? order by p.nombre;";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            String filtro = "%" + filter + "%";
            pstmt.setString(1,filtro);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String nombrePais = rs.getString(1);
                String nombreContinente = rs.getString(2);
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


        String sentenciaSQL = "update paises set nombre = ?, poblacion = ?, tamanio = ? where idpais = ?";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.setString(1, pais.getNombre());
            pstmt.setInt(2,pais.getPoblacion());
            pstmt.setDouble(3,pais.getTamanio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirPais(String nombrePais, String continentePais,int poblacion,double tamanio ){


        String sentenciaSQL = "insert into paises (nombre,continente,poblacion,tamanio)\n" +
                "values (?,?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,nombrePais);
            pstmt.setString(2,continentePais);
            pstmt.setInt(3,poblacion);
            pstmt.setDouble(4,tamanio);
            pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void eliminarPais(String idPais) {


        String sentenciaSQL = "delete from paises where idpais = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setString(1, idPais);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
