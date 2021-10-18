package com.yatra.service;

import java.util.List;

import com.yatra.model.Flight;

/**
 * @author NavinkumarD
 *
 */
public interface IFlightService {
	
	void addFlight(Flight flight);
	void updateFlight(Flight flight);
	void deleteFlight(int flightId);
	List<Flight> getAll();
	
	
}
