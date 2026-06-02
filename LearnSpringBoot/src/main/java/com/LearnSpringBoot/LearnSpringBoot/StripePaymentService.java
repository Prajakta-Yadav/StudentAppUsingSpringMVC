package com.LearnSpringBoot.LearnSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements  PaymentSevice{

    @Override
    public String pay(){
        String payment = "Stripe payment";
        System.out.println("Payment From: " +payment);
        return payment;
    }
}
