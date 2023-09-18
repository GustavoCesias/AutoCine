package com.certus.cine.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="peliculas", uniqueConstraints = {@UniqueConstraint(columnNames =   {"titulo"})})
public class Pelicula {

	@Id
	@GeneratedValue(strategy =   GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "genero", nullable = false)
	private String genero;

	@Column(name = "clasificacion", nullable = false)
	private String clasificacion;

	@Column(name = "sipnosis", nullable = false)
	private String sipnosis;

	@Column(name = "director", nullable = false)
	private String director;

	@Column(name = "fecha_estreno", nullable = false)
	private  Date fecha_estreno;

	@Column(name = "duracion", nullable = false)
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

	public Pelicula() {
		super();
	}

	public Pelicula(Long id, String titulo, String genero, String clasificacion, String sipnosis, String director,
			Date fecha_estreno, int duracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.clasificacion = clasificacion;
		this.sipnosis = sipnosis;
		this.director = director;
		this.fecha_estreno = fecha_estreno;
		this.duracion = duracion;
	}




}
