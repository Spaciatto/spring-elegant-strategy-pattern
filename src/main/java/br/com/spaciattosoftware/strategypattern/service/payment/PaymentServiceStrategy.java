package br.com.spaciattosoftware.strategypattern.service.payment;

import br.com.spaciattosoftware.strategypattern.model.payment.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class PaymentServiceStrategy {

    private final List<PaymentService> paymentServiceList;
    private final Map<String, PaymentService> paymentServiceMap;

    public PaymentService findPaymentService(final PaymentType paymentType) {
        return paymentServiceList.stream()
                .filter(service -> service.findType(paymentType))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public PaymentService findPaymentService(final String paymentServiceBeanName) {
        return paymentServiceMap.getOrDefault(paymentServiceBeanName, null);
    }

}
