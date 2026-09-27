package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.*;

@Service
public class ServicioEstudiantes {
	
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public void agregar(Estudiante estudiante) {
	    
	    Estudiante encontrado = buscarPorCedula(estudiante.getCedula());
	    
	    // is null no existe, permite agregar
	    if (encontrado == null) {
	        estudiantes.add(estudiante);
	    } else {
	        System.out.println("Estudiante ya existe");
	    }
	}

	public Estudiante buscarPorCedula(String cedula) {
	    
	    for (Estudiante estudiante: estudiantes) {
	        if (estudiante.getCedula().equals(cedula)) {
	            return estudiante;
	        }
	    }
	    return null;
	}
	
	public void eliminar(String cedula) {
	    
	    Estudiante encontrado = buscarPorCedula(cedula);
	    
	    // is null, no existe, no elimina
	    if (encontrado == null) {
	        System.out.println("Estudiante no existe para eliminar");
	        return;
	    }
	    
	    for (int i = 0; i < estudiantes.size(); i++) {
	        if (estudiantes.get(i).getCedula().equals(cedula)) {
	            estudiantes.remove(i);
	        }
	    }
	}

	public Estudiante actualizar(String cedula, Estudiante nuevo) {
		
		Estudiante encontrado = buscarPorCedula(cedula);
		
		if(encontrado == null) {
			return null;
		}
		
	    for (Estudiante estudiante: estudiantes) {
	        if (estudiante.getCedula().equals(cedula)) {
	            // opcion 1
	            //estudiante = nuevo;
	            
	            // opcion 2
	            estudiante.setNombre(nuevo.getNombre());
	            estudiante.setApellido(nuevo.getApellido());
	            
	            return estudiante;
	        }
	        
	    }
	    return null;
	}
	
	public ArrayList<Estudiante> listar(){
		return estudiantes;
	}
}
