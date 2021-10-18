package com.yatra.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

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
@Entity
public class Availability {

	@Id
	@GeneratedValue(generator = "availability_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "availability_gen", sequenceName = "availability_seq", initialValue = 101, allocationSize = 1)
	private Integer availabilityId;
	private LocalDate date;
	private LocalTime time;
	private String stopType;
	private String classType;
	@ManyToMany(mappedBy = "availabilityList")
	private Set<Flight> flightList;

	public Availability(LocalDate date, LocalTime time, String stopType, String classType) {
		super();
		this.date = date;
		this.time = time;
		this.stopType = stopType;
		this.classType = classType;
	}

	@Override
	public String toString() {
		return "Availability [date=" + date + ", time=" + time + ", stopType=" + stopType + ", classType=" + classType
				+ "]";
	}

}
