package br.com.easybank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easybank.exception.*;
import br.com.easybank.model.Conta;
import br.com.easybank.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	ContaRepository contaRepository;
	
	public List<Conta> getContas(){
		return contaRepository.findAll();
	}
	
	public Conta getContaById(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException("A conta de id: " + id + " não existe"));
	}
	
	public Conta setNewConta(Conta conta) {
		return contaRepository.save(conta);
	}
	
	public void deleteContaById(Long id) {
		contaRepository.deleteById(id);
	}
}
