package br.com.senac.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.domain.Estudante;
import br.com.senac.service.EstudanteService;

@RestController
@RequestMapping("estudante")
public class EstudanteController {

	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id){
		return estudanteService.buscarEstudantePorId(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		return estudanteService.buscarTodosEstudantes();
	}
	
	
}
