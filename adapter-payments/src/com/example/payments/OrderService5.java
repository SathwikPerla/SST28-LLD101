
// Now depends only on PaymentGateway abstraction
// No direct dependency on external SDKs

package com.example.payments;

import java.util.Map;
import java.util.Objects;


public class OrderService5 {
    private final Map<String, PaymentGateway1> gateways;

    public OrderService5(Map<String, PaymentGateway1> gateways) {
        this.gateways = Objects.requireNonNull(gateways, "gateways");
    }

    // Smell: still switches; your refactor should remove this by ensuring map contains adapters.
    // Removed SDK-specific logic and delegated responsibility
    // to the appropriate adapter
    // Now OrderService only talks to the interface and delegates the work to
    // adapters. It no longer knows anything about SDKs.
    public String charge(String provider, String customerId, int amountCents) {
        Objects.requireNonNull(provider, "provider");
        PaymentGateway1 gw = gateways.get(provider);
        if (gw == null) throw new IllegalArgumentException("unknown provider: " + provider);
        return gw.charge(customerId, amountCents);
    }
}
