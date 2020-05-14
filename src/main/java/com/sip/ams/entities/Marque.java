package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // genere les clé primaire id
	private long id;
	
	@NotBlank(message = "Nom est obligatoire") // si le user à lesser ce champ vide ce msg va affiché
	@Length(min=2 , max=10)
	@Column(name = "nom")
	private String nom;

	@Column(name = "pays")
	private String pays;


	public Marque() {
	}


	public Marque(long id, @NotBlank(message = "Nom est obligatoire") @Length(min = 2, max = 10) String nom,
			String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}

}
