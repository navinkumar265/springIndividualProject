package com.yatra.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author NavinkumarD
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIErrors {

	LocalDateTime timestamp;
	String message;
	int stauts;
	String error;
}
