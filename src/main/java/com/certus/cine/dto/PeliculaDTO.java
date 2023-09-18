package com.certus.cine.dto;

import java.sql.Date;

public class PeliculaDTO {

	private Long id;
	private String titulo;
	private String genero;
	private String clasificacion;
	private String sipnosis;
	private String director;
	private  Date fecha_estreno;
	private int duracion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getSipnosis() {
		return sipnosis;
	}
	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getFecha_estreno() {
		return fecha_estreno;
	}
	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public PeliculaDTO() {
		super();
	} 
	
	
	
	
}
