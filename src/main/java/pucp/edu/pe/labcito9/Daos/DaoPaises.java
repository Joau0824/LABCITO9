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

    public void anadirPais(String nombrePais, String continentePais,int poblacion,double tamanio ) throws SQLException{

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

    public BPaises obtenerPaisPorId(String idPais){
        BPaises pais = null;
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
                    pais = new BPaises();
                    pais.setNombre(rs.getString(2));
                    pais.setContinente(rs.getString(3));
                    pais.setPoblacion(rs.getInt(4));
                    pais.setTamanio(rs.getDouble(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pais;

    }


}
