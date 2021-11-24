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
                int idUniversidad=rs.getInt(1);
                String nombre = rs.getString(2);
                int ranking = rs.getInt(3);
                int numeroAlumnos = rs.getInt(4);
                String urlFoto = rs.getString(5);
                String nombrePais= rs.getString(6);listaUniversidades.add(new BUniversidad(idUniversidad,nombre,ranking,numeroAlumnos,urlFoto,nombrePais));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaUniversidades;
    }

    public void actualizarPais(int idPais, String nombre, int poblacion, double tamanio) {

        String sentenciaSQL = "update paises set nombre = ?, poblacion = ?, tamanio = ? where idpais = ?";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2,poblacion);
            pstmt.setDouble(3,tamanio);
            pstmt.setInt(4,idPais);
            System.out.println(nombre);
            System.out.println(poblacion);
            System.out.println(tamanio);
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

    public BUniversidad obtenerUniversidadPorId(String id){

        String sentenciaSQL = " SELECT * FROM paises WHERE idpais = ?;";
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