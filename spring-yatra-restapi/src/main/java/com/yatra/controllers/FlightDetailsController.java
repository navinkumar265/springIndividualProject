package com.yatra.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatra.model.FlightDetails;
import com.yatra.service.IFlightDetailsService;

/**
 * @author NavinkumarD
 *
 */
@RestController
@RequestMapping("/flight-flightdetails")
public class FlightDetailsController {

	@Autowired
	IFlightDetailsService flightDetailsService;
	
	@PostMapping("/flights")
	FlightDetails addFlightDetails(@RequestBody FlightDetails flightDetails) {
		return flightDetailsService.addFlightDetails(flightDetails);
	}

	@GetMapping("/flights")
	public List<FlightDetails> getAll() {
		return flightDetailsService.getAll();

	}

	@GetMapping("/flights/flightdetails/source/{source}/destination/{destination}")
	public List<FlightDetails> getById(@PathVariable("source") String source,@PathVariable("destination") String destination) {
		return flightDetailsService.getDetails(source,destination);

	}

	@GetMapping("/flights/luggage/flightid/{flightId}")
	FlightDetails getLuggageCapacityById(@PathVariable int flightId) {
		return flightDetailsService.getLuggageCapacityById(flightId);
	}

}
