package br.com.spaciattosoftware.strategypattern;

import br.com.spaciattosoftware.strategypattern.model.payment.PaymentType;
import br.com.spaciattosoftware.strategypattern.service.payment.PaymentService;
import br.com.spaciattosoftware.strategypattern.service.payment.PaymentServiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyPatternApplication implements CommandLineRunner {

	@Autowired
	private PaymentServiceStrategy paymentServiceStrategy;

	public static void main(String[] args) {
		SpringApplication.run(StrategyPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("---------- Calling by Enum Type ----------");
		PaymentService paymentService = paymentServiceStrategy.findPaymentService(PaymentType.PAYPAL);
		System.out.println(paymentService.execute());

		paymentService = paymentServiceStrategy.findPaymentService(PaymentType.CREDIT_CARD);
		System.out.println(paymentService.execute());

		paymentService = paymentServiceStrategy.findPaymentService(PaymentType.PIX);
		System.out.println(paymentService.execute());

		System.out.println("---------- Calling by Class Bean Name ----------");
		paymentService = paymentServiceStrategy.findPaymentService("payPalPaymentServiceImpl");
		System.out.println(paymentService.execute());

		paymentService = paymentServiceStrategy.findPaymentService("creditCardPaymentServiceImpl");
		System.out.println(paymentService.execute());

		paymentService = paymentServiceStrategy.findPaymentService("pixPaymentServiceImpl");
		System.out.println(paymentService.execute());

		System.exit(0);
	}
}
