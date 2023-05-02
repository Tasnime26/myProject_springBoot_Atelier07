package com.tasnime.freelancer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tasnime.freelancer.entities.Domaine;
import com.tasnime.freelancer.entities.Freelancer;

public interface FreelancerService {
	Freelancer saveFreelancer(Freelancer f);
	Freelancer updateFreelancer(Freelancer f);
	void deleteFreelancer(Freelancer f);
	 void deleteFreelancerById(Long id);
	 Freelancer getFreelancer(Long id);
	List<Freelancer> getAllFreelancers();
	Page<Freelancer> getAllFreelancerParPage(int page, int size);
	List<Freelancer> findByNomFreelancer(String nom);
	List<Freelancer> findByNomFreelancerContains(String nom);
	List<Freelancer> findByNomSalaire (String nom, Double salaire);
	List<Freelancer> findByDomaine (Domaine domaine);
	List<Freelancer> findByDomaineIdDom(Long id);
	List<Freelancer> findByOrderByNomFreelancerAsc();
	List<Freelancer> trierFreelancersNomsSalaire ();
	List<Domaine> getAllDomaine();
	

}
