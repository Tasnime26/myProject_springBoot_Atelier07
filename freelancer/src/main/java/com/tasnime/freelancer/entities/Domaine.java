package com.tasnime.freelancer.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idDom;
private String nomDom;
private String descriptionDom;

@OneToMany(mappedBy = "domaine")
@JsonIgnore
private List<Freelancer> freelancers;

}
