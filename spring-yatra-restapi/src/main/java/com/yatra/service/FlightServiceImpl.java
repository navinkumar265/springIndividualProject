package com.yatra.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatra.model.Flight;
import com.yatra.repository.IFlightRepository;
/**
 * @author NavinkumarD
 *
 */
@Service
public class FlightServiceImpl implements IFlightService {
	
	IFlightRepository flightRepository;
	
	@Autowired
	public void setFlightRepository(IFlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public void addFlight(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
		
	}

	@Override
	public void deleteFlight(int flightId) {
		flightRepository.deleteById(flightId);
		
	}

	@Override
	public List<Flight> getAll() {
		return flightRepository.findAll();
	}

}
