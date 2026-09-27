package com.krakedev.asistencias.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.Asistencia;
import com.krakedev.asistencias.Estudiante;
import com.krakedev.asistencias.RegistroAsistencia;
import com.krakedev.asistencias.servicios.ServicioAsistencia;

@RestController
@RequestMapping("/asistencia")
public class ControladorAsistencia {

    private final ServicioAsistencia servicioAsistencia;

    public ControladorAsistencia(ServicioAsistencia servicioAsistencia) {
        this.servicioAsistencia = servicioAsistencia;
    }
    
    @PostMapping
    public RegistroAsistencia registrarAsistencia(@RequestBody Estudiante estudiante) {
        return servicioAsistencia.registrarAsistencia(estudiante.getCedula());
    }
    
    @GetMapping("/{cedula}")
    public ArrayList<Asistencia> consultarAsistencia(@PathVariable String cedula) {
        return servicioAsistencia.consultarAsistencia(cedula);
    }
}