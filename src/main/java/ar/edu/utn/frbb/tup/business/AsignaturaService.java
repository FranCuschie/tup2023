package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

import java.util.List;

public interface AsignaturaService {

    Asignatura getAsignatura(Long id) throws AsignaturaNotFoundException;

    void actualizarAsignatura(Asignatura a) throws AsignaturaNotFoundException;

    List<Asignatura> obtenerAsignaturas();

}
