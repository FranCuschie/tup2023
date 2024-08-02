package ar.edu.utn.frbb.tup.model;

import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Asignatura {
    private Materia materia;
    private Long id;
    private EstadoAsignatura estado;
    private Integer nota;

    public Asignatura(Materia materia, Random id) {
    }
    public Asignatura(Materia materia) {
        this.materia = materia;
        this.id = id;
        this.estado = EstadoAsignatura.NO_CURSADA;
    }

    public Optional<Integer> getNota() {
        return Optional.ofNullable(nota);
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public static void setId(Long id) {
        this.id = id;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public EstadoAsignatura getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignatura estado) {
        this.estado = estado;
    }

    public String getNombreAsignatura(){
        return this.materia.getNombre();
    }

    public Materia getMateria() {
        return materia;
    }

    public void aprobarAsignatura(int nota) throws EstadoIncorrectoException {
        if (!this.estado.equals(EstadoAsignatura.CURSADA)) {
            throw new EstadoIncorrectoException("La materia debe estar cursada");
        }
        if (nota>=4) {
            this.estado = EstadoAsignatura.APROBADA;
            this.nota = nota;
        }
    }

    public void cursarAsignatura() throws EstadoIncorrectoException {
        if (this.estado.equals(EstadoAsignatura.CURSADA)){
            throw new EstadoIncorrectoException("La materia " + materia.getNombre() + " ya se encuentra cursada.");
        }
        if (this.estado.equals(EstadoAsignatura.APROBADA)){
            throw new EstadoIncorrectoException("La materia " + materia.getNombre() + " ya se encuentra aprobada.");
        }
        this.estado = EstadoAsignatura.CURSADA;
    }

    public List<Materia> getCorrelatividades(){
        return this.materia.getCorrelatividades();
    }
}
