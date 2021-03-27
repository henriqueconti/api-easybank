package br.com.easybank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.easybank.enumerated.ContaPoupanca;
import br.com.easybank.enumerated.TipoConta;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name = "contas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dataAberturaConta", "numeroConta"},
allowGetters = true)
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@NotNull
	private Cliente cliente;
	
	@JsonProperty("data_abertura_conta")
    @CreatedDate
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAberturaConta;
	
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonProperty("tipo_conta")
	private TipoConta tipoConta;
	
    @JsonProperty("numero_conta")
    private Integer numeroConta;
    
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonProperty("conta_poupanca")
	private ContaPoupanca contaPoupanca;
    
    public Conta() {
    	this.numeroConta = gerarNumero();
    }

	public Conta(Long id, LocalDate dataAberturaConta, TipoConta tipoConta, Integer numeroConta,
			ContaPoupanca contaPoupanca) {
		this.id = id;
		this.dataAberturaConta = dataAberturaConta;
		this.tipoConta = tipoConta;
		this.numeroConta = gerarNumero();
		this.contaPoupanca = contaPoupanca;
	}

	public int gerarNumero() {
		Random gerador = new Random();
		return (gerador.nextInt(900000000) + 100000000);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
	
}
