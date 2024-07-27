package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;

import java.util.ArrayList;

public interface ProfesorService {
    Profesor crearProfesor(ProfesorDto profesorDto);

    Profesor modificarProfesor(Long idProfesor, Profesor profesor);

    Profesor eliminarProfesor(Long idProfesor);

    ArrayList materiasDictadasOrdenadas(Profesor profe, ArrayList materias);

}
