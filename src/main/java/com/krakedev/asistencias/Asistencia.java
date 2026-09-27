package com.krakedev.asistencias;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asistencia {

	private LocalDate fechaClase;
	private LocalDateTime fechaHoraRegistro;
	private String estado;
	
	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Asistencia(LocalDate fechaClase, LocalDateTime fechaHoraRegistro, String estado) {
		super();
		this.fechaClase = fechaClase;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.estado = estado;
	}
	
	public LocalDate getFechaClase() {
		return fechaClase;
	}
	
	public void setFechaClase(LocalDate fechaClase) {
		this.fechaClase = fechaClase;
	}
	
	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}
	
	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Asistencia [fechaClase=" + fechaClase + ", fechaHoraRegistro=" + fechaHoraRegistro + ", estado="
				+ estado + "]";
	}
	
	
}
