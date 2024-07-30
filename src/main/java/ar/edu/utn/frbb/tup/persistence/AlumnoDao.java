package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;

public interface AlumnoDao {
    Alumno saveAlumno(Alumno a);

    Alumno findAlumno(Long idAlumno);

    Alumno loadAlumno(Long dni);

    Alumno deleteAlumno(Long id);

}
