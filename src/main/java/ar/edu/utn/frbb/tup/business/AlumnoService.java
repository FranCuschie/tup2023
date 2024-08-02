package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.dto.AsignaturaDto;
import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

public interface AlumnoService {

    Asignatura actualizarEstadoAsignatura(Long idAlumno, Long idAsignatura, AsignaturaDto asignaturaDto) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException, AsignaturaNotFoundException, AsignaturaInexistenteException, CorrelatividadException;

    Alumno crearAlumno(AlumnoDto alumnoDto);

    Alumno buscarAlumno(Long idAlumno) throws AlumnoNotFoundException;

    Alumno eliminarAlumno(Long idAlumno) throws  AlumnoNotFoundException;
}
