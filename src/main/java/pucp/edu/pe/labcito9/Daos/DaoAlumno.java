package pucp.edu.pe.labcito9.Daos;

import pucp.edu.pe.labcito9.Beans.BAlumnos;
import pucp.edu.pe.labcito9.Beans.BParticipante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAlumno extends BaseDao{

    public ArrayList<BAlumnos> obtenerListaAlumnos() {
        ArrayList<BAlumnos> listaAlumnos = new ArrayList<>();
        String sentenciaSQL = "select * from alumno a inner join participante p on (a.codigoAlumno = p.alumno_codigoAlumno);";

        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sentenciaSQL);){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int codigoAlumno = rs.getInt(1);
                double promedioPonderado = rs.getDouble(2);
                String condicion = rs.getString(3);
                int idUniversidad = rs.getInt(4);
                int idParticipante = rs.getInt(5);
                String nombreParticipante = rs.getString(6);
                String apellidoParticipante = rs.getString(7);
                int edad = rs.getInt(8);
                String genero = rs.getString(9);
                int idPais = rs.getInt(10);
                BParticipante participante = new BParticipante(idParticipante,nombreParticipante,apellidoParticipante,edad,genero,idPais,codigoAlumno);
                listaAlumnos.add(new BAlumnos(codigoAlumno,promedioPonderado,condicion,idUniversidad,participante));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaAlumnos;
    }
}
