package com.yatra.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString
@Entity
public class Passenger {
	@Id
	@GeneratedValue(generator = "passenger_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq", initialValue = 1001, allocationSize = 1)
	private Integer passengerId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String gender;
	private int age;
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;

	public Passenger(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

}
