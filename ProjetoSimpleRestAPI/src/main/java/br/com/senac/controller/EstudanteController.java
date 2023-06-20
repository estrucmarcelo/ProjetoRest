package br.com.senac.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.commons.ExampleValues;
import br.com.senac.domain.Estudante;
import br.com.senac.dto.EstudanteDTO;
import br.com.senac.service.EstudanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;


@RestController
@RequestMapping("estudante")
public class EstudanteController {

	private EstudanteService estudanteService;
	
	private ModelMapper mapper;
	
	public EstudanteController(ModelMapper mapper,EstudanteService estudanteService) {
		this.mapper = mapper;
		this.estudanteService = estudanteService;
	}
	
	
	
	@GetMapping("/{id}")
	@Operation(description = "Retorna os registros pelo id")
	public ResponseEntity<EstudanteDTO> buscarEstudantePorId(@PathVariable("id") @Schema(example = ExampleValues.idEstudante) Long id){
		Estudante estudante = estudanteService.buscarEstudantePorId(id);
		EstudanteDTO estudanteDTO =  mapper.map(estudante,EstudanteDTO.class);
		return ResponseEntity.ok().body(estudanteDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<EstudanteDTO>> buscarTodosEstudantes(){
		List<Estudante> list =  estudanteService.buscarTodosEstudantes();
		List<EstudanteDTO> listDTO = list.stream().map(estudante -> mapper.map(estudante, EstudanteDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<EstudanteDTO> cadastrarEstudante(@Valid
			@io.swagger.v3.oas.annotations.parameters.RequestBody(content= @Content(examples = {
					@ExampleObject(name="Exemplo de Estudante", value = ExampleValues.exemploEstudante)
			}))   
			@RequestBody EstudanteDTO estudanteDTO){
			
			Estudante estudanteObj = mapper.map(estudanteDTO, Estudante.class);
			
			estudanteObj = estudanteService.cadastrarEstudante(estudanteObj);
			
		return ResponseEntity.ok().body(estudanteDTO);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(id,estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerEstudante(@PathVariable Long id){
		return estudanteService.removerUsuario(id);
	}
	
	@GetMapping("paginacao")
	public Page<Estudante> buscarEstudantePorPaginacao(@RequestParam(required=true, defaultValue = "0") Integer pagina,
			@RequestParam(defaultValue  = "5") Integer itensPorPagina,@RequestParam(defaultValue  = "nome")  String ordenacao, 
			@RequestParam(defaultValue  = "ASC") String tipoOrdenacao){
		
		Direction direction = Direction.ASC;
		
		if(("DESC").equals(tipoOrdenacao)) {
			direction = Direction.DESC;
		}
		
		
		return estudanteService.buscaEstudantePorPaginacao(PageRequest.of(pagina, itensPorPagina,Sort.by(direction,ordenacao)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
