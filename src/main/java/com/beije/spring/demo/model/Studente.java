package com.beije.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;

@Entity(name="Studente")
@NamedQuery(name="tuttiglistudenti", query="From Studente")
public class Studente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome", length=50)
	private String nome;
	
	@Column(name="cognome", length=50)
	private String cognome;
	
	@Column(name="indirizzo", length=100)
	private String indirizzo;
	
	@Column(name="eta", length=3)
	private Integer eta;
	
	@Column(name="codiceFiscale", length=35)
	private String codiceFiscale;
	
	public Studente() {}
	
	public Studente(String nome, String cognome, String indirizzo, Integer eta, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.eta = eta;
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
}
