package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProfesorDao {

    Profesor saveProfesor(Profesor profesor);
    Profesor findProfesor(Long idProfesor) throws ProfesorNotFoundException;

    Map<Long, Profesor> deleteProfesor(Long idProfesor) throws ProfesorNotFoundException;

    void update(Long idProfesor, Profesor profesor) throws ProfesorNotFoundException;

    List<Materia> getMateriasDictadas(Long id) throws ProfesorNotFoundException;


}
