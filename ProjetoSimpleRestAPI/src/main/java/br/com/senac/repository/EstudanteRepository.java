package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

}
