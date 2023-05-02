package com.tasnime.freelancer.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tasnime.freelancer.entities.Domaine;
import com.tasnime.freelancer.entities.Freelancer;
@RepositoryRestResource(path = "rest")
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
	List<Freelancer> findByNomFreelancer(String nom);
	List<Freelancer> findByNomFreelancerContains(String nom);
	/*@Query("select f from Freelancer f where f.nomFreelancer like %?1 and f.salaireFreelancer > ?2") 
	List<Freelancer> findByNomSalaire (String nom, Double salaire);*/
	@Query("select f from Freelancer f where f.nomFreelancer like %:nom and f.salaireFreelancer > :salaire")
	List<Freelancer> findByNomSalaire (@Param("nom") String nom,@Param("salaire") Double prix);
	@Query("select f from Freelancer f where f.domaine = ?1")
	List<Freelancer> findByDomaine (Domaine domaine);
	List<Freelancer> findByDomaineIdDom(Long id);
	List<Freelancer> findByOrderByNomFreelancerAsc();
	@Query("select f from Freelancer f order by f.nomFreelancer ASC, f.salaireFreelancer DESC")
	List<Freelancer> trierFreelancersNomsSalaire ();

}
