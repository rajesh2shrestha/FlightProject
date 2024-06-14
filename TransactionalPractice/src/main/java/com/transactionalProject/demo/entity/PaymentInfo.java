package com.transactionalProject.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String paymentId;
    private String accountNo;
    private double amount;
    private String cardType;
    private Long passengerId;

}
