package ar.edu.utn.frbb.tup.model.dto;


import ar.edu.utn.frbb.tup.model.Materia;

import java.util.List;

public class MateriaDto {

    private String nombre;
    private int anio;
    private int cuatrimestre;
    private Long profesorId;
    private List<Materia> correlatividadess;

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
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

    public List<Materia> getCorrelatividadess() {
        return correlatividadess;
    }

    public void setCorrelatividadess(List<Materia> correlatividadess) {
        this.correlatividadess = correlatividadess;
    }
}