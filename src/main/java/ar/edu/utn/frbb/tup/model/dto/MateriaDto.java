package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.Profesor;

public class MateriaDto {

    private String nombre;
    private int anio;
    private int cuatrimestre;
    private String profesorApellido;

    public String getProfesorApellido() {
        return profesorApellido;
    }

    public void setProfesorApellido(String profesorApellido) {
        this.profesorApellido = profesorApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
