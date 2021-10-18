package com.yatra.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yatra.model.FlightDetails;
/**
 * @author NavinkumarD
 *
 */
@Repository
public interface IFlightDetailsRepository extends JpaRepository<FlightDetails, Integer>{
	
//	@Query(value="select * from flightdetails inner join flight f where f.source=?1 and f.destination=?2",nativeQuery = true)
	@Query("from FlightDetails fd inner join fd.flight f where f.source=?1 and f.destination=?2")
	List<FlightDetails> findDetails(String source,String destination);
	
	
	@Query("from FlightDetails fd inner join fd.flight f where f.flightId=?1")
	FlightDetails findLuggageCapacityById(int flightId);
}
