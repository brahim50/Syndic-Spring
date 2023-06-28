package com.syndic.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "lmmeuble")
public class Lmmeuble {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String address;
	private String nom;
	private String ville;
	private String numero;
	private int nbretage;
	private String image;
	
	@ManyToOne
	private Syndic syndic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNbretage() {
		return nbretage;
	}

	public void setNbretage(int nbretage) {
		this.nbretage = nbretage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Syndic getSyndic() {
		return syndic;
	}

	public void setSyndic(Syndic syndic) {
		this.syndic = syndic;
	}

	

}
