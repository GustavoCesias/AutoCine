package com.certus.cine.service;

import java.util.List;

import com.certus.cine.dto.PeliculaDTO;

public interface PeliculaServicio {

	public PeliculaDTO publicarPelicula(PeliculaDTO peliculaDTO);
	
	public List<PeliculaDTO> obtenerTodasLasPeliculas();
	
	public PeliculaDTO obtenerPeliculaPorId(long id);
	
	public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, long id);
	
	public void  eliminarPelicula(long id );
	
}
