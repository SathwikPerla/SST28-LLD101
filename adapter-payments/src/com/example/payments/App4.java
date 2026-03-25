package com.example.payments;

import java.util.HashMap;
import java.util.Map;

// Acts as a composition root
// I register all adapters here instead of using SDKs directly.
// This allows dynamic selection of payment providers.

//Instead of creating SDK objects directly in OrderService,I moved that responsibility here and registered adapters in a map.
public class App4 {
    public static void main(String[] args) {
        Map<String, PaymentGateway1> gateways = new HashMap<>();
        // TODO: register adapters instead of raw SDKs
        gateways.put("fastpay", new FastPayAdapter2(new FastPayClient()));
        gateways.put("safecash", new SafeCashAdapter3(new SafeCashClient()));
        OrderService5 svc = new OrderService5(gateways);
        

        String id1 = svc.charge("fastpay", "cust-1", 1299);
        String id2 = svc.charge("safecash", "cust-2", 1299);
        System.out.println(id1);
        System.out.println(id2);
    }
}
