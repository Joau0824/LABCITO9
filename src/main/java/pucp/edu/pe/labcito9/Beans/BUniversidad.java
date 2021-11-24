package pucp.edu.pe.labcito9.Beans;

public class BUniversidad {


    private int idUniversidad;
    private String nombre;
    private int ranking;
    private int numeroAlumnos;
    private String foto;
    private int paises_id;

    public BUniversidad() {
    }

    public BUniversidad(int idUniversidad, String nombre, int ranking, int numeroAlumnos, String foto, int paises_id) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.ranking = ranking;
        this.numeroAlumnos = numeroAlumnos;
        this.foto = foto;
        this.paises_id = paises_id;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPaises_id() {
        return paises_id;
    }

    public void setPaises_id(int paises_id) {
        this.paises_id = paises_id;
    }

}
