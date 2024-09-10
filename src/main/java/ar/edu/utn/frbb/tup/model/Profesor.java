package ar.edu.utn.frbb.tup.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Para no tener problemas con el formato Json
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Profesor {

    private long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private long dni;
    private List<Materia> materiasDictadas = new ArrayList<>(); // Lista de materias

    public Profesor() {
    }

    public Profesor(long dni, String nombre, String apellido, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.dni = dni;
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


    // Para que los assertsequals y comparacion de objetos funcione.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(id, profesor.id) &&
                Objects.equals(nombre, profesor.nombre) &&
                Objects.equals(apellido, profesor.apellido) &&
                Objects.equals(titulo, profesor.titulo) &&
                Objects.equals(dni, profesor.dni) &&
                Objects.equals(materiasDictadas, profesor.materiasDictadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, titulo, dni, materiasDictadas);
    }
}
