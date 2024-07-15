package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.ProfesorDto;

import java.util.ArrayList;

public interface ProfesorService {
    Profesor buscarProfesor(String profesorApellido);
    Profesor crearProfesor(ProfesorDto profe);

    ArrayList materiasDictadasOrdenadas(Profesor profe, ArrayList materias);

}
