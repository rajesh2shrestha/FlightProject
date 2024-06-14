package com.transactionalProject.demo.service;

import com.transactionalProject.demo.dto.FlightBookingAcknowledgement;
import com.transactionalProject.demo.dto.FlightBookingRequest;
import com.transactionalProject.demo.entity.PassengerInfo;
import com.transactionalProject.demo.entity.PaymentInfo;
import com.transactionalProject.demo.repo.PassengerInfoRepository;
import com.transactionalProject.demo.repo.PaymentInfoRepository;
import com.transactionalProject.demo.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional//(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        FlightBookingAcknowledgement acknowledgement = null;
        //Persisting info to the DB
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        //Validating paymentInfo
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
