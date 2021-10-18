package com.yatra.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "flightdetails")
public class FlightDetails {
	@Id
	@GeneratedValue(generator = "flightdetails_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="flightdetails_gen",sequenceName="flightdetails_seq",initialValue = 501,allocationSize = 1)
	private Integer detailId;
	@Column(length=20)
	private String type;
	@Column(length=20)
	private String meal;
	private double luggageCapacity;
	private double duration;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flight_id")
	private Flight flight;

	public FlightDetails(String type, String meal, double luggageCapacity, double duration, Flight flight) {
		super();
		this.type = type;
		this.meal = meal;
		this.luggageCapacity = luggageCapacity;
		this.duration = duration;
		this.flight = flight;
	}
	

}
