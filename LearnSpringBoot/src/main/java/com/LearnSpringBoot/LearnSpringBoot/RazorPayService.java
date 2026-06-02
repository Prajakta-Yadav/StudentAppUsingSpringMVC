package com.LearnSpringBoot.LearnSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component  // this annotation scan by IoC container and create this class bean(object)
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPayService implements PaymentSevice{


    public String pay(){
        String payment = "Razorpay payment";
        System.out.println("Payment From: " +payment);
        return payment;
    }
}
