package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

import java.util.List;

public interface AsignaturaDao {
    Asignatura saveAsignatura(Materia materia);

    void saveAsignaturas(List<Materia> listaMaterias);

    Asignatura getAsignaturaById(long id) throws AsignaturaNotFoundException;

    void actualizarAsignatura(Asignatura asignatura) throws AsignaturaNotFoundException;

    List<Asignatura> getListAsignaturas();
}
