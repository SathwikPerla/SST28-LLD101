public class AddOnFactory {

    public static AddOnPricing get(AddOn a) {
        return switch (a) {
            case MESS -> new MessAddOn();
            case LAUNDRY -> new LaundryAddOn();
            case GYM -> new GymAddOn();
        };
    }
}