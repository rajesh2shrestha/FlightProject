package com.transactionalProject.demo.dto;

import com.transactionalProject.demo.entity.PassengerInfo;
import com.transactionalProject.demo.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
