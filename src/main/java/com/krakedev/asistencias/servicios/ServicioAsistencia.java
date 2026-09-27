package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.Asistencia;
import com.krakedev.asistencias.Estudiante;
import com.krakedev.asistencias.RegistroAsistencia;

@Service
public class ServicioAsistencia {

    private ArrayList<RegistroAsistencia> registros = new ArrayList<>();

    private final ServicioEstudiantes servicioEstudiantes;

    public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
        this.servicioEstudiantes = servicioEstudiantes;
    }

    public RegistroAsistencia registrarAsistencia(String cedula) {
        // Buscar estudiante por cedula en servicioEstudiantes
        Estudiante encontrado = servicioEstudiantes.buscarPorCedula(cedula);

        // Si no existe el estudiante, retorna null
        if (encontrado == null) {
            return null;
        }

        // Crea la asistencia con la fecha y hora actuales, estado "P" = Presente
        Asistencia asistencia = new Asistencia(
                LocalDate.now(),
                LocalDateTime.now(),
                "P"
        );

        // Crea un registro asistencia, agrega a la lista, retorna el registro creado
        RegistroAsistencia registroAsistencia = new RegistroAsistencia(encontrado, asistencia);
        registros.add(registroAsistencia);

        return registroAsistencia;
    }

    public ArrayList<Asistencia> consultarAsistencia(String cedula) {
        // Retorna todas las asistencias del estudiante
        ArrayList<Asistencia> asistencias = new ArrayList<>();

        for (RegistroAsistencia reg : registros) {
            if (reg.getEstudiante().getCedula().equals(cedula)) {
                asistencias.add(reg.getAsistencia());
            }
        }

        return asistencias;
    }
}
