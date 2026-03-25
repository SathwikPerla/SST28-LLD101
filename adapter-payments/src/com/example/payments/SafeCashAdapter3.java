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


// Adapter for SafeCash SDK
// SafeCash returns an object instead of a transaction ID,
// so this adapter extracts the required data.

public class SafeCashAdapter3 implements PaymentGateway1 {

    private final SafeCashClient client;

    public SafeCashAdapter3(SafeCashClient client) {
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents) {

        SafeCashPayment payment = client.createPayment(amountCents, customerId);

        return payment.getTransactionId();
    }
}