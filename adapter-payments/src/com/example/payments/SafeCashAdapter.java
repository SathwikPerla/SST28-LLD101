package com.example.payments;

import java.util.Objects;

/*
 * ADAPTER for SafeCash SDK
 *
 * Problem:
 * SafeCashClient does not directly return a transaction id.
 * It returns a SafeCashPayment object.
 *
 * The adapter converts that object into the expected
 * PaymentGateway interface response.
 */

public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents) {

        SafeCashPayment payment = client.createPayment(amountCents, customerId);

        return payment.getTransactionId();
    }
}