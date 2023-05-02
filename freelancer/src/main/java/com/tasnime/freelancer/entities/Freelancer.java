package com.tasnime.freelancer.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Freelancer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFreelancer;
	
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomFreelancer;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double salaireFreelancer;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateinscription;
	@ManyToOne
	private Domaine domaine;
	
	public Freelancer() {
	super();
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	public Freelancer(String nomFreelancer, Double salaireFreelancer, Date dateinscription) {
	this.nomFreelancer = nomFreelancer;
	this.salaireFreelancer = salaireFreelancer;
	this.dateinscription = dateinscription;
	}
	public Long getIdFreelancer() {
		return idFreelancer;
	}
	public void setIdFreelancer(Long idFreelancer) {
		this.idFreelancer = idFreelancer;
	}
	public String getNomFreelancer() {
		return nomFreelancer;
	}
	public void setNomFreelancer(String nomFreelancer) {
		this.nomFreelancer = nomFreelancer;
	}
	public Double getSalaireFreelancer() {
		return salaireFreelancer;
	}
	public void setSalaireFreelancer(Double salaireFreelancer) {
		this.salaireFreelancer = salaireFreelancer;
	}
	public Date getDateinscription() {
		return dateinscription;
	}
	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}
	@Override
	public String toString() {
		return "Freelancer [idFreelancer=" + idFreelancer + ", nomFreelancer=" + nomFreelancer + ", salaireFreelancer="
				+ salaireFreelancer + ", dateinscription=" + dateinscription + "]";
	}
	
}
