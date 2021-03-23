package br.com.easybank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "contas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dataAberturaConta"},
allowGetters = true)
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	@JsonProperty("nome_titular")
	private String titularConta;
	
	@NotNull
	@JsonProperty("cpf_titular")
	@Column(unique = true)
	@CPF(message = "CPF invalido")
	private String cpfTitular; 
	
	@JsonProperty("data_abertura_conta")
    @CreatedDate
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAberturaConta;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@JsonProperty("tipo_conta")
	private TipoConta tipoConta;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@JsonProperty("conta_poupanca")
	private ContaPoupanca contaPoupanca;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public LocalDate getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(LocalDate dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
}
