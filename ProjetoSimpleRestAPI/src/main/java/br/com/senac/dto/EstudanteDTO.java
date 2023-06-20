package br.com.senac.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstudanteDTO {

	
	private Long id;
	
	@NotNull(message= "O Campo Nome é requerido")
	private String nome;
	

	@NotNull(message= "O Campo email é requerido")
	private String email;
	

	private LocalDate dataNascimento;
	
}
