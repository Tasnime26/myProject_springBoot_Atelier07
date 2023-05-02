package com.tasnime.freelancer;

import java.util.Date;
import java.util.List;
import com.tasnime.freelancer.entities.Domaine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.tasnime.freelancer.entities.Freelancer;

import com.tasnime.freelancer.repos.FreelancerRepository;
import com.tasnime.freelancer.service.FreelancerService;

@SpringBootTest
class FreelancerApplicationTests {

	@Autowired
	private FreelancerRepository freelancerRepository;
	@Autowired
	private FreelancerService  freelancerService ;
	@Test
	public void testCreateFreelancer() {
		Freelancer freel = new Freelancer("mayssa elgarsi",3000.500,new Date());
		freelancerRepository.save(freel);
	}
	@Test
	public void testFindFreelancer()
	{
		Freelancer f = freelancerRepository.findById(1L).get(); 
	System.out.println(f);
	}
	@Test
	public void testUpdateFreelancer()
	{
		Freelancer f = freelancerRepository.findById(1L).get();
	f.setSalaireFreelancer(1000.0);
	freelancerRepository.save(f);
	}
	@Test
	public void testDeleteFreelancer()
	{
		freelancerRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousFreelancers()
	{
	List<Freelancer> freels = freelancerRepository.findAll();
	for (Freelancer f : freels)
	{
	System.out.println(f);
	}
	}
	@Test
	public void testFindByNomFreelancerContains()
	{
	Page<Freelancer> freel = freelancerService.getAllFreelancerParPage(0,3);
	System.out.println(freel.getSize());
	System.out.println(freel.getTotalElements());
	System.out.println(freel.getTotalPages());
	freel.getContent().forEach(f -> {System.out.println(f.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testfindByNomFreelancer()
	{
	List<Freelancer> freel = freelancerRepository.findByNomFreelancer("Mayssa Elgarsi");
	for (Freelancer f : freel)
	{
	System.out.println(f);
	}
	}
	@Test
	public void testFindByNomfreelancerContains ()
	{
	List<Freelancer> freel=freelancerRepository.findByNomFreelancerContains("y");
	for (Freelancer f : freel)
	{
	System.out.println(f);
	} }
	@Test
	public void testfindByNomSalaire()
	{
	List<Freelancer> freel = freelancerRepository.findByNomSalaire("Mayssa Elgarsi", 1000.0);
	for (Freelancer f : freel)
	{
	System.out.println(f);
	}
	}

	@Test
	public void testfindByDomaine()
	{
		Domaine dom = new Domaine();
	dom.setIdDom(1L);
	List<Freelancer> freel = freelancerRepository.findByDomaine(dom);
	for (Freelancer f : freel)
	{
	System.out.println(f);
	}
	}
	
	@Test
	public void findByDomaineIdDom()
	{
	List<Freelancer> freel = freelancerRepository.findByDomaineIdDom(1L);
	for (Freelancer p : freel)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomFreelancerAsc()
	{
	List<Freelancer> freel = freelancerRepository.findByOrderByNomFreelancerAsc();
	for (Freelancer f : freel)
	{
	System.out.println(f);
	}
	}
	@Test
	public void testTrierFreelancersNomsSalairex()
	{
	List<Freelancer> freel = freelancerRepository.trierFreelancersNomsSalaire();
	for (Freelancer f : freel)
	{
	System.out.println(f);
	}
	}

}
