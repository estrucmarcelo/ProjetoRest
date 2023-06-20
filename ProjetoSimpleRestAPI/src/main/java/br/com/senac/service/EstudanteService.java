package br.com.senac.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;
import br.com.senac.dto.EstudanteDTO;
import br.com.senac.exceptions.ObjectNotFoundException;
import br.com.senac.repository.EstudanteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {

	private EstudanteRepository estudanteRepository;

	public Estudante buscarEstudantePorId(Long id) {

		Optional<Estudante> obj =  estudanteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Estudante não encontrado: " + id));

		
	}

	public List<Estudante> buscarTodosEstudantes() {

		return estudanteRepository.findAll();
		
		

	}

	public Estudante cadastrarEstudante(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}

	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {

		if (estudanteRepository.existsById(id)) {
			Estudante est = estudanteRepository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(est);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	public ResponseEntity<String> removerUsuario(long id) {

		if (estudanteRepository.existsById(id)) {
			estudanteRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Estudante excluído com sucesso!");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não existe!");

	}
	
	public Page<Estudante> buscaEstudantePorPaginacao(PageRequest page){
		return estudanteRepository.findAll(page);
	}

}
