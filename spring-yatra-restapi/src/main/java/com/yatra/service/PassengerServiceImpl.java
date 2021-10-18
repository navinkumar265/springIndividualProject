package com.yatra.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatra.exception.PassengerIdNotFoundException;
import com.yatra.model.Passenger;
import com.yatra.repository.IPassengerRepository;
/**
 * @author NavinkumarD
 *
 */
@Service
public class PassengerServiceImpl implements IPassengerService {

	IPassengerRepository passengerRepository;

	@Autowired
	public void setPassengerRepository(IPassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		passengerRepository.save(passenger);

	}

	@Override
	public void deletePassenger(int passengerId) {
		passengerRepository.deleteById(passengerId);

	}

	@Override
	public List<Passenger> getAll() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger getByPassengerId(int id)throws PassengerIdNotFoundException{
		Passenger passenger= passengerRepository.findById(id).get();
		if(passenger==null)
			throw new PassengerIdNotFoundException("no passenger found");
		return passenger;
		
	}

	@Override
	public List<Passenger> getByGender(String gender) {
		return passengerRepository.findByGender(gender);
	}

	@Override
	public List<Passenger> getFlightById(int passengerId) {
		return passengerRepository.findFlightById(passengerId);
	}

}
