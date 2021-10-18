package com.yatra.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatra.exception.FlightNotFoundException;
import com.yatra.model.Availability;
import com.yatra.model.FlightNotFound;
import com.yatra.repository.IAvailabilityRepository;
/**
 * @author NavinkumarD
 *
 */
@Service
public class AvailabilityServiceImpl implements IAvailabilityService {
	IAvailabilityRepository availabilityRepository;

	@Autowired
	public void setAvailabilityRepository(IAvailabilityRepository availabilityRepository) {
		this.availabilityRepository = availabilityRepository;
	}

	@Override
	public Availability addAvailability(Availability availability) {
		return availabilityRepository.save(availability);
	}

	@Override
	public void updateAvailability(Availability availability) {
		availabilityRepository.save(availability);
	}

	@Override
	public void deleteAvailability(int availabilityId) {
		availabilityRepository.deleteById(availabilityId);
	}

	@Override
	public List<Availability> getAll() {
		return availabilityRepository.findAll();
	}

	@Override
	public List<Availability> getByAvailability(LocalDate date) throws FlightNotFoundException{
		List<Availability> availabilityList= availabilityRepository.findByAvailability(date);
		if(availabilityList.isEmpty())
			throw new FlightNotFoundException(FlightNotFound.NOFLIGHTONDATE.toString());
		else 
			return availabilityList;
	}

	@Override
	public List<Availability> getByStopType(String stopType) {
		List<Availability> availabilityList= availabilityRepository.findByStopType(stopType);
		if(availabilityList.isEmpty())
			throw new FlightNotFoundException(FlightNotFound.NOFLIGHTSTOPTYPE.toString());
		else 
			return availabilityList;
	}

	@Override
	public List<Availability> getBySourceAndDestination(String source, String destination) {
		List<Availability> availabilityList= availabilityRepository.findBySourceAndDestination(source, destination);
		if(availabilityList.isEmpty())
			throw new FlightNotFoundException(FlightNotFound.NOROUTESFOUND.toString());
		else 
			return availabilityList;
	}

	@Override
	public List<Availability> getClass(String source, String destination,String classType) {
		List<Availability> availabilityList= availabilityRepository.findClass(source, destination,classType);
		if(availabilityList.isEmpty())
			throw new FlightNotFoundException(FlightNotFound.CLASSTYPENOTFOUND.toString());
		else 
			return availabilityList;
	}

}
