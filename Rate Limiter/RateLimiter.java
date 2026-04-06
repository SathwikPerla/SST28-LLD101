public class RateLimiter {

    private final RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allow(String key) {
        return strategy.allow(key);
    }
}