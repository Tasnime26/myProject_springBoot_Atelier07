package com.tasnime.freelancer.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomFreel", types = { Freelancer.class })
public interface FreelancerProjection {
	public String getNomFreelancer();
}
