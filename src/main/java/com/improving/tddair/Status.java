package com.improving.tddair;

public enum Status {
    Green(25000, 9000, 90), Blue(50000, 8000, 75), Gold(75000, 7000, 60), Red(0, 10000, 100);

    private final int threshold;
    private final int seatUpgradeMilesCost;
    private final int seatUpgradeDollarCost;

    Status(int threshold, int seatUpgradeMilesCost, int seatUpgradeDollarCost) {
        this.threshold = threshold;
        this.seatUpgradeMilesCost = seatUpgradeMilesCost;
        this.seatUpgradeDollarCost = seatUpgradeDollarCost;
    }

    public static Status calculateStatusFor(int ytdMiles) {

        Status status = Red;

        if (ytdMiles >= Green.threshold) {
            status = Status.Green;
        }
        if (ytdMiles >= Blue.threshold) {
            status = Status.Blue;
        }
        if (ytdMiles >= Gold.threshold) {
            status = Status.Gold;
        }
        return status;
    }

    public int getSeatUpgradeMilesCost() {
        return seatUpgradeMilesCost;
    }

    public int getSeatUpgradeDollarCost() {
        return seatUpgradeDollarCost;
    }
}
