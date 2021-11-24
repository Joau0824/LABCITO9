package pucp.edu.pe.labcito9.Beans;

public class BParticipante {

    private int idParticipante;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int idPais;
    private int Alumno_codigo;


    public BParticipante() {
    }

    public BParticipante(int idParticipante, String nombre, String apellido, int edad, String genero, int idPais, int alumno_codigo) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.idPais = idPais;
        Alumno_codigo = alumno_codigo;
    }


    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getAlumno_codigo() {
        return Alumno_codigo;
    }

    public void setAlumno_codigo(int alumno_codigo) {
        Alumno_codigo = alumno_codigo;
    }




}
