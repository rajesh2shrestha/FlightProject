package com.transactionalProject.demo;

import com.transactionalProject.demo.dto.FlightBookingAcknowledgement;
import com.transactionalProject.demo.dto.FlightBookingRequest;
import com.transactionalProject.demo.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class DemoApplication {

	@Autowired
	private FlightBookingService flightBookingService;
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return flightBookingService.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
