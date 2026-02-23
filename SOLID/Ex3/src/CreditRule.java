import java.util.*;

public class CreditRule implements EligibilityRule {
    public Optional<String> check(StudentProfile s) {
        if (s.earnedCredits < 20)
            return Optional.of("credits below 20");
        return Optional.empty();
    }
}