package com.yatra.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yatra.model.Passenger;
/**
 * @author NavinkumarD
 *
 */
@Repository
public interface IPassengerRepository extends JpaRepository<Passenger, Integer>{
	
	List<Passenger> findByGender(String gender);
	
	@Query("from Passenger p inner join p.flight where p.passengerId=?1")
	List<Passenger> findFlightById(int passengerId);

}
