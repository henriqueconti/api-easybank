package br.com.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easybank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
//	Conta findByCpf(String cpfTitular);
}
