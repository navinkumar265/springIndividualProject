package com.yatra.service;

import java.util.List;

import com.yatra.exception.PassengerIdNotFoundException;
import com.yatra.model.Passenger;

/**
 * @author NavinkumarD
 *
 */
public interface IPassengerService {
	Passenger addPassenger(Passenger passenger);
	void updatePassenger(Passenger passenger);
	void deletePassenger(int passengerId);
	List<Passenger> getAll();
	
	Passenger getByPassengerId(int id)throws PassengerIdNotFoundException;
	List<Passenger> getByGender(String gender);
	
	List<Passenger> getFlightById(int passengerId);
}
