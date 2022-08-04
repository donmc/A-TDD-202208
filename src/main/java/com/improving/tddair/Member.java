package com.improving.tddair;

public class Member {
    private final String username;
    private final String email;
    private Status status;
    private int ytdMiles;
    private int balanceMiles;
    private int seatUpgradeBalance;
    private CAS cas;

    public Member(String username, String email) {
        this.username = username;
        this.email = email;
        this.status = Status.Red;
        this.ytdMiles = 0;
        this.balanceMiles = 10000;
        this.seatUpgradeBalance = 0;
    }

    public String getUsername() {
        return username;
    }

    public Status getStatus() {
        return status;
    }

    public int getYtdMiles() {
        return ytdMiles;
    }

    public int getBalanceMiles() {
        return balanceMiles;
    }

    public void completeFlight(Flight flight) {
        ytdMiles += flight.getMileage();
        balanceMiles += flight.getMileage();
        status = Status.calculateStatusFor(ytdMiles);

    }

    public int getSeatUpgradeBalance() {
        return this.seatUpgradeBalance;
    }

    public void purchaseSeatUpgradesUsingMiles(int quantity) {
        seatUpgradeBalance += quantity;
        balanceMiles -= status.getSeatUpgradeMilesCost() * quantity;
    }

    public void setCas(CAS cas) {
        this.cas = cas;
    }

    public void purchaseSeatUpgradesUsingCC(int quantity, String ccNum) {
        int amount = status.getSeatUpgradeDollarCost() * quantity;
        boolean isAuthorized = cas.authorize(ccNum, amount);
        if (isAuthorized) {
            seatUpgradeBalance += quantity;
        }
    }
}
