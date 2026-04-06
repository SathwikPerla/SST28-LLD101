public class Main {

    public static void main(String[] args) throws InterruptedException {

        RateLimiter limiter = new RateLimiter(
                new FixedWindowStrategy(5, 60_000));

        String key = "T1";

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allow(key);
            System.out.println("Request " + i + ": " + allowed);
        }

        // Switch strategy (no business logic change)
        RateLimiter slidingLimiter = new RateLimiter(
                new SlidingWindowStrategy(5, 60_000));

        for (int i = 1; i <= 7; i++) {
            boolean allowed = slidingLimiter.allow(key);
            System.out.println("Sliding Request " + i + ": " + allowed);
        }
    }
}