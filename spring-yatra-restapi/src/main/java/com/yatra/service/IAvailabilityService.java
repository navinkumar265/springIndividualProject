package com.yatra.service;

import java.time.LocalDate;
import java.util.List;

import com.yatra.exception.FlightNotFoundException;
import com.yatra.model.Availability;
import com.yatra.model.Passenger;

/**
 * @author NavinkumarD
 *
 */
public interface IAvailabilityService {
	Availability addAvailability(Availability availability);
	void updateAvailability(Availability availability);
	void deleteAvailability(int availabilityId);
	
	List<Availability> getAll();
	List<Availability> getByAvailability(LocalDate date) throws FlightNotFoundException;
	List<Availability> getByStopType(String stopType);
	List<Availability> getBySourceAndDestination(String source,String destination);
	
	List<Availability> getClass(String source,String destination,String classType);

}
