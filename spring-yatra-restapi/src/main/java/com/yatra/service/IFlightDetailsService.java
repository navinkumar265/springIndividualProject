package com.yatra.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.yatra.model.FlightDetails;

/**
 * @author NavinkumarD
 *
 */
public interface IFlightDetailsService {
	FlightDetails addFlightDetails(FlightDetails flightDetails);

	void updateFlightDetails(FlightDetails flightDetails);

	void deleteFlightDetails(int detailId);

	List<FlightDetails> getAll();

	List<FlightDetails> getDetails(String source,String destination);
	
	FlightDetails getLuggageCapacityById(int flightId);
	
	
}
