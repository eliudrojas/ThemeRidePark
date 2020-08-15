package com.xds.jenkins.devops;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xds.jenkins.devops.entity.ThemeParkRide;
import com.xds.jenkins.devops.repository.ThemeParkRideRepository;

@SpringBootApplication
@EnableJpaRepositories("com.xds.jenkins.devops.repository")
@ComponentScan("com.xds")
@EntityScan("com.xds.jenkins.devops.entity")
public class DevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevopsApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleData (ThemeParkRideRepository repository) {
		return (args) -> {
			repository.save(new ThemeParkRide(Long.valueOf("1"),"uno","uno",1,1));
			repository.save(new ThemeParkRide(Long.valueOf("2"),"dos","dos",2,2));
			repository.save(new ThemeParkRide(Long.valueOf("3"),"tres","tres",3,3));
		};
	}
}
