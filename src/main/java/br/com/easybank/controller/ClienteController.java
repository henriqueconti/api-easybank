package br.com.easybank.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.easybank.model.Cliente;
import br.com.easybank.service.ClienteService;

@RestController
@RequestMapping("/easybank")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClientes(){
		List<Cliente> clientes = clienteService.getClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/clientes/id/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id")Long id){
		Cliente cliente = clienteService.getClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);	 
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> registerCliente(@RequestBody @Valid Cliente cliente){
		Cliente clienteCriado = clienteService.setNewCliente(cliente);
		return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> deletaCliente(@PathVariable(value = "id") Long id){
		clienteService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/clientes/cpf/{cpf}")
	public ResponseEntity<Cliente> getClienteByCpf(@PathVariable(value = "cpf") String cpf){
		Cliente cliente = clienteService.getClienteByCpf(cpf);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}
