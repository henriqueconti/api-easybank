package br.com.easybank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easybank.exception.ResourceNotFoundException;
import br.com.easybank.model.Conta;
import br.com.easybank.repository.ContaRepository;
import br.com.easybank.service.ContaService;

@RestController
@RequestMapping("/easybank")
public class ContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	private final ContaService contaService;
	
	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}
	
	@GetMapping("/contas")
	public List<Conta> getAllContas(){
		return contaRepository.findAll();
	}
	
	@GetMapping("/contas/{id}")
	public ResponseEntity<Conta> buscaPorCpf(@PathVariable(value = "id") Long id){
		Optional<Conta> conta = contaRepository.findById(id);
		return new ResponseEntity<>(conta.get(), HttpStatus.OK);	 
	}
	
	@PostMapping("/contas")
	public ResponseEntity<Conta> registrar(@RequestBody Conta conta){
		Conta contaCriada = contaService.salvar(conta);
		return new ResponseEntity<>(contaCriada, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/contas/{id}")
	public ResponseEntity<?> deletaConta(@PathVariable(value = "id") Long id){
		Conta conta = contaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Conta", "id", id));
		contaRepository.delete(conta);
		
		return ResponseEntity.ok().build();
	}
}
