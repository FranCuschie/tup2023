package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;

public interface AlumnoDao {
    Alumno saveAlumno(Alumno a);

    Alumno findAlumno(Long idAlumno) throws AlumnoNotFoundException;

    Alumno deleteAlumno(Long id) throws AlumnoNotFoundException;

}
