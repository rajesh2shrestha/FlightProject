package com.transactionalProject.demo.service;

import com.transactionalProject.demo.dto.FlightBookingRequest;
import com.transactionalProject.demo.entity.PassengerInfo;
import com.transactionalProject.demo.entity.PaymentInfo;
import com.transactionalProject.demo.repo.PassengerInfoRepository;
import com.transactionalProject.demo.repo.PaymentInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlightBookingServiceTest {
    @InjectMocks
    private FlightBookingService flightBookingService;

    //declare dependency
    @Mock
    private PassengerInfoRepository passengerInfoRepository;
    @Mock
    private PaymentInfoRepository paymentInfoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookFlightTicket() {

        PassengerInfo passengerInfo = new PassengerInfo();
        passengerInfo.setPId(1L);
        passengerInfo.setFare(100.00);

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAccountNo("1234567");

        FlightBookingRequest flightBookingRequest = new FlightBookingRequest(passengerInfo, paymentInfo);

        // Mocking behavior
        when(passengerInfoRepository.save(passengerInfo)).thenReturn(passengerInfo);



    }
}