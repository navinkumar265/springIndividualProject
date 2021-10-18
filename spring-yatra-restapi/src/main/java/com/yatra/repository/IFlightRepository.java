package com.yatra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yatra.model.Flight;
/**
 * @author NavinkumarD
 *
 */
@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{

	
	
}
