package com.yatra.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author NavinkumarD
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Flight {
	@Id
	@GeneratedValue(generator = "flight_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "flight_gen", sequenceName = "flight_seq", initialValue = 1, allocationSize = 1)
	private Integer flightId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String source;
	@Column(length = 20)
	private String destination;

	@OneToOne(mappedBy = "flight")
	@JsonIgnore
	FlightDetails flightDetails;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="flight_id")
	@JsonIgnore

	private Set<Passenger> passenger;

	@ManyToMany
	@JoinTable(name = "flight_availability", joinColumns = { @JoinColumn(name = "flight_id") }, inverseJoinColumns = {
			@JoinColumn(name = "availability_id") })
	@JsonIgnore
	private Set<Availability> availabilityList;

	public Flight(String name, String source, String destination) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Flight [name=" + name + ", source=" + source + ", destination=" + destination + "]";
	}

	public Flight(String name, String source, String destination, Set<Passenger> passenger) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.passenger = passenger;
	}

	public Flight(String source, String destination, Set<Availability> availabilityList,String name) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.availabilityList = availabilityList;
	}

	

}
