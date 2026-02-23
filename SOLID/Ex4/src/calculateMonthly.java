private Money calculateMonthly(BookingRequest req) {

    double base = RoomPricingFactory.get(req.roomType).price();

    double add = 0.0;
    for (AddOn a : req.addOns) {
        add += AddOnFactory.get(a).price();
    }

    return new Money(base + add);
}