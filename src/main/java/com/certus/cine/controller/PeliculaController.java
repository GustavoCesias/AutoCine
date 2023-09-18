package com.certus.cine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certus.cine.dto.PeliculaDTO;
import com.certus.cine.service.PeliculaServicio;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

	@Autowired
	private PeliculaServicio peliculaServicio;
	
	 @PostMapping
	 public ResponseEntity<PeliculaDTO> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO){
		 return new ResponseEntity<>(peliculaServicio.publicarPelicula(peliculaDTO),HttpStatus.CREATED);
	 }
	 @GetMapping()
	 public List<PeliculaDTO> listarPeliculas(){
		 return peliculaServicio.obtenerTodasLasPeliculas();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<PeliculaDTO> obtenerPeliculaPorId(@PathVariable(name = "id") long id){
		 return ResponseEntity.ok(peliculaServicio.obtenerPeliculaPorId(id));
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<PeliculaDTO> actualizarPelicula(@RequestBody PeliculaDTO peliculaDTO, @PathVariable(name = "id") long id){
		 PeliculaDTO nuevaPeliculaDTO = peliculaServicio.actualizarPelicula(peliculaDTO, id) ;
		 return new ResponseEntity<>(nuevaPeliculaDTO,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id){
		 peliculaServicio.eliminarPelicula(id);
		 return new ResponseEntity<>("Publicacion eliminada con exito", HttpStatus.OK);
	 }
	 
	 
	 
	 
}
