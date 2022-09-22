package br.com.spaciattosoftware.strategypattern.service.payment;

import br.com.spaciattosoftware.strategypattern.model.payment.PaymentType;

public interface PaymentService {

    String execute();
    Boolean findType(PaymentType paymentType);

}
