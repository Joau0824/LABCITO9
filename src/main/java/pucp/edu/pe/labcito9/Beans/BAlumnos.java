package pucp.edu.pe.labcito9.Beans;

public class BAlumnos extends BParticipante {

    private int codigoAlumno;
    private double promedioPonderado;
    private String condicion;
    private int idUniversidad;

    public BParticipante getParticipante() {
        return participante;
    }

    public void setParticipante(BParticipante participante) {
        this.participante = participante;
    }

    private BParticipante participante;


    public BAlumnos(int codigoAlumno, double promedioPonderado, String condicion, int idUniversidad, BParticipante participante) {
        this.codigoAlumno = codigoAlumno;
        this.promedioPonderado = promedioPonderado;
        this.condicion = condicion;
        this.idUniversidad = idUniversidad;
        this.participante = participante;
    }

    public BAlumnos() {
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public double getPromedioPonderado() {
        return promedioPonderado;
    }

    public void setPromedioPonderado(double promedioPonderado) {
        this.promedioPonderado = promedioPonderado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }



}
