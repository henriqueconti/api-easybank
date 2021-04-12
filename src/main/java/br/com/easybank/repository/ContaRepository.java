package br.com.easybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easybank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	Optional<Conta> getContaByNumeroConta(Integer numeroConta);
	
}
