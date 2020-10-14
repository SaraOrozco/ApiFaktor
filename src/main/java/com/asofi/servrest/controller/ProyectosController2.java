package com.asofi.servrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.asofi.servrest.entity.Proyectos;

import com.asofi.servrest.service.ProyectosService;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController2 {

	@Autowired //Realizamos la inyección de dependencias  
	private ProyectosService proyectosServices;
	
	//Crear proyecto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proyectos proyecto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectosServices.save(proyecto));
	}
	
	// Leer una proyecto
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long Idproyecto){
		Optional<Proyectos> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oproyectos);
	}
	// Leer una proyecto
		@GetMapping("/{id}/empresas")
    public ResponseEntity<?> read_empresas(@PathVariable(value = "id") Long Idproyecto){
			Optional<Proyectos> oproyectos = proyectosServices.findByID(Idproyecto);
			//Validamos que haya encontrado la proyecto
			if(!oproyectos.isPresent()) {
				//Devolvemos que no ha encontrado la proyecto
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oproyectos.get().getEmpresa());
		}
	
	//Actualizar una proyecto
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proyectos proyectoDetails,  @PathVariable(value = "id") Long Idproyecto){
		Optional<Proyectos> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		
		//Actualizamos los campos
		oproyectos.get().setNombre(proyectoDetails.getNombre());
		oproyectos.get().setEmpresa(proyectoDetails.getEmpresa());
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectosServices.save(oproyectos.get()));
		
	}
	//Borrar una proyecto
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long Idproyecto){
		Optional<Proyectos> oproyectos = proyectosServices.findByID(Idproyecto);
		//Validamos que haya encontrado la proyecto
		if(!oproyectos.isPresent()) {
			//Devolvemos que no ha encontrado la proyecto
			return ResponseEntity.notFound().build();
		}
		//Borramos el usuario
		proyectosServices.deteleById(Idproyecto);
		//Devolvemos rspuesta con código 200 = OK
		return ResponseEntity.ok().build();
	}
	
	//Leer Todas las proyectos
	@GetMapping
	public List<Proyectos> readAll(){
		//Utilizamos Streamsupport Api Java 8
		
		List<Proyectos> proyectos = StreamSupport // Usamos streamsupport que hereda de Object 
				.stream(proyectosServices.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return proyectos;
	}
 }
