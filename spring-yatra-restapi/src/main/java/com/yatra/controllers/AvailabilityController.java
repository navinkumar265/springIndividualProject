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

import com.yatra.model.Availability;
import com.yatra.model.FlightDetails;
import com.yatra.service.IAvailabilityService;
import com.yatra.service.IFlightDetailsService;

/**
 * @author NavinkumarD
 *
 */
@RestController
@RequestMapping("/flight-availability")
public class AvailabilityController {

	@Autowired
	IAvailabilityService availabilityService;

	@PostMapping("/flights")
	Availability add(@RequestBody Availability availability) {
		return availabilityService.addAvailability(availability);
	}

	@GetMapping("/flights")
	public List<Availability> getAll() {
		return availabilityService.getAll();

	}

	@GetMapping("/flights/availability/date/{date}")
	public List<Availability> getByAvailability(@PathVariable("date") String date) {
		return availabilityService.getByAvailability(LocalDate.parse(date));

	}

	@GetMapping("/flights/availability/stoptype/{stoptype}")
	public List<Availability> getByAvailabilityStopType(@PathVariable("stoptype") String stopType) {
		return availabilityService.getByStopType(stopType);

	}

	@GetMapping("/flights/source/{source}/destination/{destination}")
	public List<Availability> getBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
		return availabilityService.getBySourceAndDestination(source, destination);
	}

	@GetMapping("/flights/source/{source}/destination/{destination}/classtype/{classType}")
	List<Availability> getClass(@PathVariable String source,@PathVariable String destination,@PathVariable String classType) {
		return availabilityService.getClass(source, destination,classType);
	}

}
