package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BPaises;
import pucp.edu.pe.labcito9.Beans.BParticipante;

import java.sql.*;
import java.util.ArrayList;

public class DaoParticipante extends BaseDao {

    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/lab9?serverTimezone=America/Lima";


    public boolean edad(int edad){
        boolean valido = false;
        if(edad>18){
            valido=true;
        }
        return valido;
    }

    public boolean nombreValido(String nombre){
        boolean valido=false;
        try{
            int name=Integer.parseInt(String.valueOf(nombre.charAt(0)));
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }

    public boolean apellidoValido(String apellido){
        boolean valido=true;

        try{
            int ape=Integer.parseInt(String.valueOf(apellido.charAt(0)));
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }

    public ArrayList<BParticipante> obtenerListaParticipantes() {
        ArrayList<BParticipante> listaParticipante = new ArrayList<>();
        String sentenciaSQL = "select pa.idparticipante, pa.nombre,pa.apellido,pa.edad,p.nombre,pa.genero from participante pa inner join paises p on (p.idpais = pa.idpais);";

        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            ResultSet rs = pstmt.executeQuery();
            System.out.println("PROPA");
            while(rs.next()){
                int idparticipante = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                int edad=rs.getInt(4);
                String nacionalidad = rs.getString(5);
                String genero=rs.getString(6);
                listaParticipante.add(new BParticipante(idparticipante,nombre,apellidos,edad,genero,nacionalidad));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaParticipante;
    }

    public void actualizarParticipante(String nombre, String apellido,int edad,String genero,int idPais,int idparticipante) {


        String sentenciaSQL = "update participante set nombre = ?, apellido = ?, edad = ?, genero = ?, idpais= ? where idparticipante = ?";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,nombre);
            pstmt.setString(2,apellido);
            pstmt.setInt(3,edad);
            pstmt.setString(4,genero);
            pstmt.setInt(5,idPais);
            pstmt.setInt(6,idparticipante);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void anadirParticipante(String nombre, String apellido,int edad,String genero,int idpais){


        String sentenciaSQL = "insert into participante (nombre,apellido,edad,genero,idpais)\n" +
                "values (?,?,?,?,?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,nombre);
            pstmt.setString(2,apellido);
            pstmt.setInt(3,edad);
            pstmt.setString(4,genero);
            pstmt.setInt(5,idpais);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void eliminarParticipante(int idParticipante) {


        String sentenciaSQL = "delete from participante where idparticipante = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setInt(1, idParticipante);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public BParticipante obtenerParticipantePorId(String idParticipante){


        String sentenciaSQL = "select pa.nombre,pa.apellido,pa.edad,p.nombre,pa.genero from participante pa inner join paises p on (p.idpais = pa.idpais) where idparticipante = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,idParticipante);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString(1);
                    String apellidos = rs.getString(2);
                    int edad=rs.getInt(3);
                    String nacionalidad = rs.getString(4);
                    String genero=rs.getString(5);
                    return new BParticipante(Integer.parseInt(idParticipante),nombre,apellidos,edad,nacionalidad,genero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int buscarIdpais(String pais){
        String sentenciaSQL="select p.idpais from paises p where p.nombre like ?;";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,pais+"%");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int idpais = rs.getInt(1);
            System.out.println(idpais);
            return idpais;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
