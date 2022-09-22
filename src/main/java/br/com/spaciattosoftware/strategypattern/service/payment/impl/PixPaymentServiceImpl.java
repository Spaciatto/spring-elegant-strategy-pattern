package br.com.spaciattosoftware.strategypattern.service.payment.impl;

import br.com.spaciattosoftware.strategypattern.model.payment.PaymentType;
import br.com.spaciattosoftware.strategypattern.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PixPaymentServiceImpl implements PaymentService {

    @Override
    public String execute() {
        return PixPaymentServiceImpl.class.getName();
    }

    @Override
    public Boolean findType(PaymentType paymentType) {
        return paymentType == PaymentType.PIX;
    }
}
