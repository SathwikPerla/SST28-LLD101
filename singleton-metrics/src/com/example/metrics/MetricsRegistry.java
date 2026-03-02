package com.example.metrics;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Flag to block reflection-based second creation
    private static boolean instanceCreated = false;

    private final Map<String, Long> counters = new HashMap<>();

    // PRIVATE constructor (Singleton)
    private MetricsRegistry() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() - Singleton already created");
        }
        instanceCreated = true;
    }

    // Lazy + Thread-safe using static holder
    private static class Holder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Preserve singleton during deserialization
    @Serial
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}