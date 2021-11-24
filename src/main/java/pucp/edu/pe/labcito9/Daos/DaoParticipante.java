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
        String sentenciaSQL = "select pa.nombre,pa.apellido,pa.edad,p.nombre,pa.genero from participante pa inner join paises p on (p.idpais = pa.idpais);";

        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){

                String nombre = rs.getString(1);
                String apellidos = rs.getString(2);
                int edad=rs.getInt(3);
                String nacionalidad = rs.getString(4);
                String genero=rs.getString(5);
                listaParticipante.add(new BParticipante(nombre,apellidos,edad,nacionalidad,genero));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaParticipante;
    }

    public void actualizarParticipante(int idPais, String nombre, int poblacion, double tamanio) {


        String sentenciaSQL = "update paises set nombre = ?, poblacion = ?, tamanio = ? where idpais = ?";


        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void anadirParticipante(String nombrePais, String continentePais,int poblacion,double tamanio ){


        String sentenciaSQL = "insert into paises (nombre,continente,poblacion,tamanio)\n" +
                "values (?,?,?,?);";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {

            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void eliminarParticipante(int idParticipante) {


        String sentenciaSQL = "delete from paises where idpais = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL);) {
            pstmt.setInt(1, idParticipante);
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public BPaises obtenerParticipantePorId(String idParticipante){


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sentenciaSQL = " SELECT * FROM paises WHERE idpais = ?;";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sentenciaSQL)) {
            pstmt.setString(1,idParticipante);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
