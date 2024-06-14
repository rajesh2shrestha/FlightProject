package com.transactionalProject.demo.utils;

import com.transactionalProject.demo.expection.InsufficientAmountExpecption;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();
    static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 5000.0);
        paymentMap.put("acc4", 8000.0);
    }




    public static boolean validateCreditLimit(String accNo, Double paidAmount){
        if(paidAmount > paymentMap.get(accNo)){
            throw new InsufficientAmountExpecption("insufficient fund ...!");
        }else {
            return true;
        }
    }
}
