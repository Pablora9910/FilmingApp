package es.studium.filmingapp;

import java.io.Serializable;

public class SeriePOJO implements Serializable {

    private final int caratula;
    private final String titulo;
    private final String director;
    private  final String reparto;
    private final int clasificacion;
    private final String sinopsis;
    private final int temporadas;

    public SeriePOJO(int caratula, String titulo, String director, String reparto, int clasificacion, String sinopsis, int temporadas) {
        this.caratula = caratula;
        this.titulo = titulo;
        this.director = director;
        this.reparto = reparto;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas;
    }

    public int getCaratula() {
        return caratula;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getReparto() {
        return reparto;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public String getSinopsis() {
        return sinopsis;
    }

}
