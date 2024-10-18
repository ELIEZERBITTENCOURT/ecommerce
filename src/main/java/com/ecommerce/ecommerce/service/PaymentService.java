package com.ecommerce.ecommerce.service;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class PaymentService {

    public PaymentIntent criarPagamento(Float valor) throws StripeException {
        long valorCentavos = (long) (valor * 100);

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount(valorCentavos)
            .setCurrency("brl")  // Alterar a moeda conforme necessário
            .build();

        return PaymentIntent.create(params);
    }

    public PaymentIntent confirmarPagamento(String paymentIntentId) throws StripeException {
        PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
        return paymentIntent.confirm();
    }
}
