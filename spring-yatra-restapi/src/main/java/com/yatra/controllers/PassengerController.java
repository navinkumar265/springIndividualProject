package com.yatra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatra.exception.PassengerIdNotFoundException;
import com.yatra.model.Passenger;
import com.yatra.service.IPassengerService;

/**
 * @author NavinkumarD
 *
 */
@RestController
@RequestMapping("/flight-passenger")
public class PassengerController {

	@Autowired
	IPassengerService passengerService;
	
	@PostMapping("/flights")
	Passenger addPassenger(@RequestBody Passenger passenger) {
		return passengerService.addPassenger(passenger);
	}

	@GetMapping("/flights")
	public List<Passenger> getAll() {
		return passengerService.getAll();

	}

	@GetMapping("/flights/id/{id}")
	public Passenger getByPassengerId(@PathVariable("id") int passengerId)  {
		return passengerService.getByPassengerId(passengerId);

	}
	
	@GetMapping("/flights/gender/{gender}")
	public List<Passenger> getByPassengerGender(@PathVariable("gender") String gender)  {
		return passengerService.getByGender(gender);

	}

	@GetMapping("/flights/flightdetails/{passengerId}")
	List<Passenger> getFlightById(@PathVariable int passengerId) {
		return passengerService.getFlightById(passengerId);
	}

	
}
