package com.LearnSpringBoot.LearnSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// CommandLineRunner -> this interface run application after ready with context & Spring application
public class LearnSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
	}
   // private RazorPayService paymentService = new RazorPayService(); //tightly coupling
   // @Autowired // Instead of constructor we use @Autowired to inject the object dependency
    //@Autowired cannot make the object variable final. but constructor did it.
    private final PaymentSevice paymentService;  //without new keyword inject the object
    //This called constructor dependency injection.
    public  LearnSpringBootApplication(PaymentSevice paymentService){
        this.paymentService = paymentService;
    }

    @Override     //CommandLineRunner Interface abstrat method override
    public void run(String... args) throws Exception {
        String payment = paymentService.pay();
        System.out.println("Payment Done: " + payment);

    }
}
