package ar.edu.utn.frbb.tup.persistence.impl;

import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.AsignaturaDao;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

import java.util.*;

public class AsignaturaDaoMemoryImpl implements AsignaturaDao {

    private static final Map<Long, Asignatura> repositorioAsignaturas = new HashMap<>();

    @Override
    public Asignatura saveAsignatura(Materia materia) {
        // Genero un random en formato Long
        Random random = new Random();
        Asignatura asignatura = new Asignatura(materia, random.nextLong(999));
        repositorioAsignaturas.put(asignatura.getId(), asignatura);
        return asignatura;

    }

    @Override
    public void saveAsignaturas(List<Materia> listaMaterias) {
        for (Materia materia : listaMaterias){
            saveAsignatura(materia);
        }
    }

    @Override
    public Asignatura getAsignaturaById(long id) throws AsignaturaNotFoundException {
        Asignatura asignaturaExistente = repositorioAsignaturas.get(id);
        if (asignaturaExistente != null) {
            return asignaturaExistente;
        }
        else {
            throw new AsignaturaNotFoundException("No existe Asignatura con ese ID: " + id + ".");
        }
    }

    @Override
    public void actualizarAsignatura(Asignatura asignatura) throws AsignaturaNotFoundException {
        Asignatura asignatura2 = getAsignaturaById(asignatura.getId());
        repositorioAsignaturas.put(asignatura2.getId(), asignatura2);
    }

    @Override
    public List<Asignatura> getListAsignaturas() {
        final List<Asignatura> listaAsignaturas = new ArrayList<>();
        for (Asignatura asignatura : repositorioAsignaturas.values()){
            listaAsignaturas.add(asignatura);
        }
        return listaAsignaturas;
    }
}
