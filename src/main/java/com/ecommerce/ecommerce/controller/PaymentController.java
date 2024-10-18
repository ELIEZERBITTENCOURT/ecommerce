package com.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@RestController
@RequestMapping("/api/pagamentos")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Endpoint para iniciar um pagamento
    @PostMapping("/iniciar")
    public PaymentIntent iniciarPagamento(@RequestParam Float valor) throws StripeException {
        return paymentService.criarPagamento(valor);
    }

    // Endpoint para confirmar um pagamento
    @PostMapping("/confirmar/{paymentIntentId}")
    public PaymentIntent confirmarPagamento(@PathVariable String paymentIntentId) throws StripeException {
        return paymentService.confirmarPagamento(paymentIntentId);
    }
}
