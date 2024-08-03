package ar.edu.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    private long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private long dni;
    private List<Materia> materiasDictadas;

    public Profesor() {
    }

    public Profesor(long dni, String nombre, String apellido, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.dni = dni;

        materiasDictadas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }


    public void setMateriasDictadas(Materia materia) {
        this.materiasDictadas.add(materia);
    }
}
