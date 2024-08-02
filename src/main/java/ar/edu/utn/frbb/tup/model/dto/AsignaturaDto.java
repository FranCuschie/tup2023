package ar.edu.utn.frbb.tup.model.dto;

import ar.edu.utn.frbb.tup.model.EstadoAsignatura;

public class AsignaturaDto {
    private int nota;

    private EstadoAsignatura estado;

    public void setNota(int nota) {
        this.nota = nota;
    }


    public int getNota() {
        return nota;
    }

    public EstadoAsignatura getCondicion() {
        return this.estado;
    }


}