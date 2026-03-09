package com.example.payments;

import java.util.Objects;

/*
 * ADAPTER for FastPay SDK
 *
 * Problem:
 * FastPayClient uses a different method signature:
 *      payNow(custId, amount)
 *
 * Our system expects:
 *      charge(customerId, amountCents)
 *
 * This adapter converts the system interface to the FastPay SDK interface.
 */

public class FastPayAdapter implements PaymentGateway {

    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents) {
        return client.payNow(customerId, amountCents);
    }
}