package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;
import ar.edu.utn.frbb.tup.persistence.exception.ProfesorNotFoundException;

public interface ProfesorService {
    Profesor crearProfesor(ProfesorDto profesorDto);

    Profesor modificarProfesor(Long idProfesor) throws  ProfesorNotFoundException;

    Profesor eliminarProfesor(Long idProfesor) throws ProfesorNotFoundException;

    Profesor buscarProfesorById(Long idProfesor) throws ProfesorNotFoundException;

    Profesor materiasDictadas(Long idProfesor) throws ProfesorNotFoundException;

}
