package br.com.easybank.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.easybank.enumerated.TipoCliente;
import br.com.easybank.enumerated.TipoPessoa;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("nome_titular")
	@NotNull
	private String titularConta;
	
	@Column(unique = true)
	@CPF(message = "CPF invalido")
	@NotNull
	private String cpf; 
	
	@JsonProperty("data_nascimento")
	@NotNull
	private LocalDate dataNascimento;
	
	@JsonProperty("tipo_pessoa")
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoPessoa tipoPessoa;
	
	@JsonProperty("tipo_cliente")
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoCliente tipoCliente;
	
	@OneToMany
	private List<Conta> conta;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String titularConta, @CPF(message = "CPF invalido") String cpf,
			LocalDate dataNascimento, TipoPessoa tipoPessoa, TipoCliente tipoCliente) {
		this.id = id;
		this.titularConta = titularConta;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
		this.tipoCliente = tipoCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}

}
