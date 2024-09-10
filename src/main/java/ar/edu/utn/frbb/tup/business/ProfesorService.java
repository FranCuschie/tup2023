package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProfesorService {
    Profesor crearProfesor(ProfesorDto profesorDto);

    Profesor modificarProfesor(Long idProfesor) throws  ProfesorNotFoundException;

    Map<Long, Profesor> eliminarProfesor(Long idProfesor) throws ProfesorNotFoundException;

    Profesor buscarProfesorById(Long idProfesor) throws ProfesorNotFoundException;

    List<Materia> materiasDictadas(Long idProfesor) throws ProfesorNotFoundException;

    void actualizarProfesor(Profesor profesor) throws ProfesorNotFoundException;

}
