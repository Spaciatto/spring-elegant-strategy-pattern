package br.com.spaciattosoftware.strategypattern.model.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {

    PAYPAL("PAYPAL"),
    CREDIT_CARD("CREDIT_CARD"),
    PIX("PIX");

    private final String paymentType;

}
