import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowStrategy implements RateLimitingStrategy {

    private final int limit;
    private final long windowSizeMillis;

    private final ConcurrentHashMap<String, Window> map = new ConcurrentHashMap<>();

    public FixedWindowStrategy(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public boolean allow(String key) {
        long now = System.currentTimeMillis();

        map.putIfAbsent(key, new Window(now, new AtomicInteger(0)));
        Window window = map.get(key);

        synchronized (window) {
            if (now - window.startTime >= windowSizeMillis) {
                window.startTime = now;
                window.counter.set(0);
            }

            if (window.counter.incrementAndGet() <= limit) {
                return true;
            }
            return false;
        }
    }

    static class Window {
        long startTime;
        AtomicInteger counter;

        Window(long startTime, AtomicInteger counter) {
            this.startTime = startTime;
            this.counter = counter;
        }
    }
}