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

// Adapter for FastPay SDK
// FastPay has a different method name (payNow),
// so this adapter converts it to our standard interface (charge).

//“This adapter simply maps our charge() method to FastPay’s payNow() method.”

public class FastPayAdapter2 implements PaymentGateway1 {

    private final FastPayClient client;

    public FastPayAdapter2(FastPayClient client) {
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents) {
        return client.payNow(customerId, amountCents);
    }
}