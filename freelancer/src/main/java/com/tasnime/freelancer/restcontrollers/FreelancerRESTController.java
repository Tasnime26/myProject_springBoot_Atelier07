package com.tasnime.freelancer.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tasnime.freelancer.entities.Freelancer;
import com.tasnime.freelancer.service.FreelancerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FreelancerRESTController {
	@Autowired
	FreelancerService freelancerService ;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Freelancer> getAllFreelancers() {
		return freelancerService.getAllFreelancers();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Freelancer getFreelancerById(@PathVariable("id") Long id) {
	return freelancerService.getFreelancer(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Freelancer createFreelancer(@RequestBody Freelancer freelancer) {
	return freelancerService.saveFreelancer(freelancer);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Freelancer updateFreelancer(@RequestBody Freelancer freelancer) {
	return freelancerService.updateFreelancer(freelancer);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteFreelancer(@PathVariable("id") Long id)
	{
		freelancerService.deleteFreelancerById(id);
	}
	@RequestMapping(value="/freelsdom/{idDom}",method = RequestMethod.GET)
	public List<Freelancer> getFreelancersByDomId(@PathVariable("idDom") Long idDom) {
	return freelancerService.findByDomaineIdDom(idDom);
	}
}
