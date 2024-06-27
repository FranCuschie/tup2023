package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;

public interface ProfesorService {
    Profesor buscarProfesor(long profesorId);
    Profesor CrearProfesor(ProfesorDto profesorDto);

    Profesor EliminarProfesor(long profesorId);
}
