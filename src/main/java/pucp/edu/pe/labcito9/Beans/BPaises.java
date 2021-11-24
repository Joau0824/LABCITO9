package pucp.edu.pe.labcito9.Beans;

public class BPaises {


    private int idPais;
    private String nombre;
    private String continente;
    private int poblacion;
    private double tamanio;


    public BPaises() {
    }

    public BPaises(int idPais, String nombre, String continente, int poblacion, double tamanio) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.tamanio = tamanio;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }








}
