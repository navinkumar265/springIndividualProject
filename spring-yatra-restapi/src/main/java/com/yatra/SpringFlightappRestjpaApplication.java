package com.yatra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yatra.model.Availability;
import com.yatra.model.Flight;
import com.yatra.model.FlightDetails;
import com.yatra.model.Passenger;
import com.yatra.service.IAvailabilityService;
import com.yatra.service.IFlightDetailsService;
import com.yatra.service.IFlightService;
import com.yatra.service.IPassengerService;

/**
 * @author NavinkumarD
 *
 */
@SpringBootApplication
public class SpringFlightappRestjpaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringFlightappRestjpaApplication.class, args);
	}

	

}
