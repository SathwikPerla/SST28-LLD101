// Common interface (Target Interface in Adapter Pattern)
// I introduced this to standardize all payment providers.
// Now OrderService depends on this interface instead of specific SDKs.
// This helps decouple business logic from external systems.

package com.example.payments;

public interface PaymentGateway1 {
    String charge(String customerId, int amountCents);
}
