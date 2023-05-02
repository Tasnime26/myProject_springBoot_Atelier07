package com.tasnime.freelancer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.tasnime.freelancer.entities.Freelancer;
import com.tasnime.freelancer.service.FreelancerService;

@SpringBootApplication
public class FreelancerApplication  implements CommandLineRunner  {
	@Autowired
	FreelancerService freelancerService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(FreelancerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*
		 * freelancerService.saveFreelancer(new Freelancer("raja barhoumi", 2600.0, new
		 * Date())); freelancerService.saveFreelancer(new Freelancer("youssef elgarsi",
		 * 2800.0, new Date())); freelancerService.saveFreelancer(new
		 * Freelancer("hanin amara ", 900.0, new Date()));
		 */
		repositoryRestConfiguration.exposeIdsFor(Freelancer.class);
	}
}
