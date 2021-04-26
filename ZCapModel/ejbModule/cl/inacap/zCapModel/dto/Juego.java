package cl.inacap.zCapModel.dto;

import java.time.LocalDate;

public class Juego {
	
	private String nombre;
	private String descripcion;
	private Consola consola;
	private boolean apto;
	private int precio;
	private LocalDate fechaLanzamiento;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Consola getConsola() {
		return consola;
	}
	public void setConsola(Consola consola) {
		this.consola = consola;
	}
	public boolean getApto() {
		return apto;
	}
	public void setApto(boolean apto) {
		this.apto = apto;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	
	

}
