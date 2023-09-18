package com.certus.cine.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.cine.dto.PeliculaDTO;
import com.certus.cine.entity.Pelicula;
import com.certus.cine.repository.PeliculaRepository;
import com.certus.cine.exceptions.ResourceNotFoundExceptions;

@Service
public class PublicarPeliculaImpl implements PeliculaServicio{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public PeliculaDTO publicarPelicula(PeliculaDTO peliculaDTO) {
		Pelicula pelicula = mapearEntidad(peliculaDTO);
		
		Pelicula nuevaPelicula = peliculaRepository.save(pelicula);
		
		PeliculaDTO nuevaPeliculaDTO = mapearDTO(nuevaPelicula);
		return nuevaPeliculaDTO;
	}

	@Override
	public List<PeliculaDTO> obtenerTodasLasPeliculas() {
		List<Pelicula> peliculas = peliculaRepository.findAll();
		return peliculas.stream().map(pelicula -> mapearDTO(pelicula)).collect(Collectors.toList());
		
	}
	
	//Convierte a DTO
	private PeliculaDTO mapearDTO(Pelicula pelicula) {
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		peliculaDTO.setId(pelicula.getId());
		peliculaDTO.setTitulo(pelicula.getTitulo());
		peliculaDTO.setGenero(pelicula.getGenero());
		peliculaDTO.setClasificacion(pelicula.getClasificacion());
		peliculaDTO.setSipnosis(pelicula.getSipnosis());
		peliculaDTO.setDirector(pelicula.getDirector());
		peliculaDTO.setDuracion(pelicula.getDuracion());
		peliculaDTO.setFecha_estreno(pelicula.getFecha_estreno());
		
		return peliculaDTO;
	}
	
	//Convierte de DTO a Entidad
	private Pelicula mapearEntidad(PeliculaDTO peliculaDTO) {
		Pelicula pelicula = new Pelicula();
		
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setGenero(peliculaDTO.getGenero());
		pelicula.setClasificacion(peliculaDTO.getClasificacion());
		pelicula.setSipnosis(peliculaDTO.getSipnosis());
		pelicula.setDirector(peliculaDTO.getDirector());
		pelicula.setDuracion(peliculaDTO.getDuracion());
		pelicula.setFecha_estreno(peliculaDTO.getFecha_estreno());
		
		return pelicula;
	}
	
	@Override
	public PeliculaDTO obtenerPeliculaPorId(long id) {
		Pelicula pelicula = peliculaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Pelicula", "id",id));
		return mapearDTO(pelicula);
	}
	
	@Override
	public PeliculaDTO actualizarPelicula(PeliculaDTO peliculaDTO, long id) {
		Pelicula pelicula = peliculaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Pelicula", "id",id));
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setGenero(peliculaDTO.getGenero());
		pelicula.setClasificacion(peliculaDTO.getClasificacion());
		pelicula.setSipnosis(peliculaDTO.getSipnosis());
		pelicula.setDirector(peliculaDTO.getDirector());
		pelicula.setDuracion(peliculaDTO.getDuracion());
		pelicula.setFecha_estreno(peliculaDTO.getFecha_estreno());
		
		Pelicula peliculaActualizada = peliculaRepository.save(pelicula);
		return mapearDTO(peliculaActualizada);
	}
	
	@Override
	public void eliminarPelicula(long id) {
		Pelicula pelicula = peliculaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Pelicula", "id",id));
		peliculaRepository.delete(pelicula);
		
	}

}
