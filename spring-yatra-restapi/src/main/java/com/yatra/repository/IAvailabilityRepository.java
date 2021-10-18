package com.yatra.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yatra.model.Availability;
/**
 * @author NavinkumarD
 *
 */
@Repository
public interface IAvailabilityRepository extends JpaRepository<Availability, Integer>{
	
//	@Query(value="select * from availability a inner join flight f on f.flight_id=a.availability_id where a.date=?1",nativeQuery = true)
//	@Query(value="select * from flight_availability fa inner join availability a on fa.flight_id=a.flight_id where a.date=?1",nativeQuery = true)

	@Query("from Availability a inner join a.flightList f where a.date=?1")
	List<Availability> findByAvailability(LocalDate date);
	
	List<Availability> findByStopType(String stopType);
	
//	@Query(value="select * from flight f inner join availability a where f.source=?1 and f.destination=?2",nativeQuery = true)
	@Query("from Availability a inner join a.flightList f where f.source=?1 and f.destination=?2")
	List<Availability> findBySourceAndDestination(String source,String destination);
	
	@Query("from Availability a inner join a.flightList f where f.source=?1 and f.destination=?2 and a.classType=?3")
	List<Availability> findClass(String source,String destination,String classType);
}
