package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Profesor;

public interface ProfesorDao {

    Profesor saveProfesor(Profesor profesor);
    Profesor findProfesor(String profesorApellido);

    Profesor loadProfesor(Long dni);

    Profesor deleteProfesor(String profesorApellido);

}
