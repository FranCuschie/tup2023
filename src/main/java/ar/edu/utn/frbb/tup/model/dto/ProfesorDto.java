package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.Materia;

import java.util.List;

public class ProfesorDto {

    private final long id = 12;
    private final String nombre;
    private final String apellido;
    private final String titulo;

    private List<Materia> materiasDictadas;

    public ProfesorDto(String nombre, String apellido, String titulo, List<Materia> materiasDictadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.materiasDictadas = materiasDictadas;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(List<Materia> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }
}
