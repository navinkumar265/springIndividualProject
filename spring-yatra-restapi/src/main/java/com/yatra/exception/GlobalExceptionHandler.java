package com.yatra.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yatra.model.APIErrors;

/**
 * @author NavinkumarD
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PassengerIdNotFoundException.class)
	public String handlePassengerIdNotFoundException(PassengerIdNotFoundException e,Model model) {
//		System.out.println(e.getMessage());
//		model.addAttribute("message",e.getMessage());
		String message=e.getMessage();
		LocalDateTime timestamp=LocalDateTime.now();
		String error ="no passenger found";
		APIErrors apierror=new APIErrors(timestamp,message,HttpStatus.CONFLICT.value(),error);
		return ("redirect:/");
	}
}
