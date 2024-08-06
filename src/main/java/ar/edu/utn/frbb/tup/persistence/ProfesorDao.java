package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;

import java.util.List;

public interface ProfesorDao {

    Profesor saveProfesor(Profesor profesor);
    Profesor findProfesor(Long idProfesor) throws ProfesorNotFoundException;

    Profesor deleteProfesor(Long idProfesor) throws ProfesorNotFoundException;

    List<Materia> getMateriasDictadas(Long id) throws ProfesorNotFoundException;

}
