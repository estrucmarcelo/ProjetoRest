package br.com.senac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;

@Service
public class EstudanteService {

	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();

	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		Estudante estudante = listaEstudantes.get(id);
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(estudante);

	}
		
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		List listaEstudante = new ArrayList<Estudante>(listaEstudantes.values());
		if (listaEstudante.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listaEstudante);
	}
	
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		listaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
		Estudante estudanteEncontrado = listaEstudantes.get(id);
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		listaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	
	public ResponseEntity<String> removerUsuario(long id){
		Estudante estudanteEncontrado = listaEstudantes.get(id);
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		listaEstudantes.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("Detonado com sucesso!");
		
	}
	
	
	
	
	
	
	
	
	
}







