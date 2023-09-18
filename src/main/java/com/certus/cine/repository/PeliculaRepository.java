package com.certus.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.certus.cine.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

}
