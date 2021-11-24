package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Beans.BUniversidad;

import java.sql.*;
import java.util.ArrayList;

public class  DaoUniversidad extends BaseDao{

    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/lab9?serverTimezone=America/Lima";

    public ArrayList<BUniversidad> obtenerListaUniversidades(String filter) {
        ArrayList<BUniversidad> listaUniversidades = new ArrayList<>();
        String sentenciaSQL = "select *,p.nombre from universidades u inner join pais p on u.paises_idpais = p.idpais order by ? asc ;";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            String filtro = "%" + filter + "%";
            pstmt.setString(1,filtro);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int idUniversidad= rs.getInt(1);
                String nombre = rs.getString(2);
                int ranking = rs.getInt(3);
                int numeroAlumnos = rs.getInt(4);
                String urlFoto = rs.getString(5);
                String nombrePais= rs.getString(7);listaUniversidades.add(new BUniversidad(idUniversidad,nombre,ranking,numeroAlumnos,urlFoto,nombrePais));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaUniversidades;
    }

    public void actualizarUniversidad(int idUniversidad, String nombre, String ranking , int numeroAlumnos , String foto) {

        String sentenciaSQL = "update universidad set nombre = ?, ranking = ?, numeroAlumnos = ?, foto = ? where iduniversidad = ?;";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2,ranking);
            pstmt.setInt(3,numeroAlumnos);
            pstmt.setString(4,foto);
            pstmt.setInt(5,idUniversidad);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirUniversidad(String nombre, String ranking , int numeroAlumnos , String foto, int idpais ){

        String sentenciaSQL = "insert into universidad (nombre,ranking,numeroAlumnos,foto,paises_idpais)\n" +
                "values (?,?,?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2,ranking);
            pstmt.setInt(3,numeroAlumnos);
            pstmt.setString(4,foto);
            pstmt.setInt(5,idpais);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void eliminarUniversidad(int iduniversidad) {


        String sentenciaSQL = "delete from universidad where iduniversidad = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setInt(1, iduniversidad);
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public BUniversidad obtenerUniversidadPorId(String id){

        String sentenciaSQL = " SELECT * FROM universidad WHERE iduniversidad = ?;";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idUniversidad = rs.getInt(1);
                    String nombre = rs.getString(2);
                    int ranking = rs.getInt(3);
                    int numeroAlumnos = rs.getInt(4);
                    String urlFoto = rs.getString(5);
                    String nombrePais= rs.getString(6);
                    return new BUniversidad(idUniversidad,nombre,ranking,numeroAlumnos,urlFoto,nombrePais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}