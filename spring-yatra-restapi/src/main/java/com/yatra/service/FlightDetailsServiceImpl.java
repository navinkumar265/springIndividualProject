package com.yatra.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatra.model.FlightDetails;
import com.yatra.repository.IFlightDetailsRepository;
/**
 * @author NavinkumarD
 *
 */
@Service
public class FlightDetailsServiceImpl implements IFlightDetailsService {

	IFlightDetailsRepository flightDetailsRepository;

	@Autowired
	public void setFlightDetailsRepository(IFlightDetailsRepository flightDetailsRepository) {
		this.flightDetailsRepository = flightDetailsRepository;
	}

	@Override
	public FlightDetails addFlightDetails(FlightDetails flightDetails) {
		return flightDetailsRepository.save(flightDetails);
	}

	@Override
	public void updateFlightDetails(FlightDetails flightDetails) {
		flightDetailsRepository.save(flightDetails);

	}

	@Override
	public void deleteFlightDetails(int detailId) {
		flightDetailsRepository.deleteById(detailId);
	}

	@Override
	public List<FlightDetails> getAll() {
		return flightDetailsRepository.findAll();
	}

	@Override
	public List<FlightDetails> getDetails(String source, String destination) {
		return flightDetailsRepository.findDetails(source, destination);
	}

	@Override
	public FlightDetails getLuggageCapacityById(int flightId) {
		return flightDetailsRepository.findLuggageCapacityById(flightId);
	}

}
