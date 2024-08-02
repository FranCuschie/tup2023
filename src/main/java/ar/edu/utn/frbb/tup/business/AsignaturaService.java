package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

public interface AsignaturaService {

    Asignatura getAsignatura(Long id) throws AsignaturaNotFoundException;

}
