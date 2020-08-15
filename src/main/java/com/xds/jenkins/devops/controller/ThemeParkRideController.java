package com.xds.jenkins.devops.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xds.jenkins.devops.entity.ThemeParkRide;
import com.xds.jenkins.devops.repository.ThemeParkRideRepository;

@RestController
public class ThemeParkRideController {
	
	@Autowired
	private final ThemeParkRideRepository thereParkRideRepository;

	public ThemeParkRideController(ThemeParkRideRepository thereParkRideRepository) {
		super();
		this.thereParkRideRepository = thereParkRideRepository;
	}
	
	
	@GetMapping (value="/ride", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable < ThemeParkRide > getRides () {
		return thereParkRideRepository.findAll();
	}
	
	@GetMapping (value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide getRide(@PathVariable ("id") Long id) {
		return thereParkRideRepository.findById(id).orElseThrow(() -> 
		new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid id %s", id)));
	}
	
	@PostMapping (value="/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide ride) {
			return thereParkRideRepository.save(ride);
	}
}
