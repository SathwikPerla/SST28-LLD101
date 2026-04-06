import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowStrategy implements RateLimitingStrategy {

    private final int limit;
    private final long windowSizeMillis;

    private final ConcurrentHashMap<String, Deque<Long>> map = new ConcurrentHashMap<>();

    public SlidingWindowStrategy(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public boolean allow(String key) {
        long now = System.currentTimeMillis();

        map.putIfAbsent(key, new ArrayDeque<>());
        Deque<Long> queue = map.get(key);

        synchronized (queue) {

            while (!queue.isEmpty() && now - queue.peekFirst() >= windowSizeMillis) {
                queue.pollFirst();
            }

            if (queue.size() < limit) {
                queue.addLast(now);
                return true;
            }

            return false;
        }
    }
}