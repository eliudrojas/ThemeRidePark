package com.xds.jenkins.devops.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xds.jenkins.devops.entity.ThemeParkRide;

public interface ThemeParkRideRepository extends CrudRepository<ThemeParkRide, Long> {

	List < ThemeParkRide> findByName(String name);
}
