package br.com.easybank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easybank.model.Conta;
import br.com.easybank.repository.ContaRepository;

@Service
public class ContaService {
	
	private final ContaRepository contaRepository;
	
	@Autowired
	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public Conta salvar(Conta conta) {
		return contaRepository.save(conta);
	}
	
//	public Conta buscaPorCpf(String cpfTitular) {
//		return contaRepository.buscaPorCpf(cpfTitular);
//	}
}
