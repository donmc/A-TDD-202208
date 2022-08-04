package com.improving.tddair;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhenPurchasingSeatUpgrades {

    private TddAirApplication app;
    private Member member;

    private MemberMother mother = new MemberMother();


    @BeforeEach
    void given() {
        app = new TddAirApplication();
        app.registerMember("donmc", "e@mail.com");
        member = app.lookupMember("donmc");
    }


    @Test
    void shouldPurchaseSeatUpgradeBalanceWhenUsingMiles_RED() {
        int quantity = 1;
        member.purchaseSeatUpgradesUsingMiles(quantity);

        assertEquals(1, member.getSeatUpgradeBalance());
        assertEquals(0, member.getBalanceMiles());
    }

    @Test
    void shouldPurchaseSeatUpgradeBalanceWhenUsingMiles_GREEN() {
        int quantity = 1;

        member = mother.greenGuy;
        int startBalance = member.getBalanceMiles();
        member.purchaseSeatUpgradesUsingMiles(quantity);
        int balanceCost = startBalance - member.getBalanceMiles();

        assertEquals(1, member.getSeatUpgradeBalance());
        assertEquals(9000, balanceCost);
    }

    @Test
    void shouldPurchaseSeatUpgradeBalanceWhenUsingMiles_BLUE() {
        int quantity = 1;

        member = mother.blueGuy;
        int startBalance = member.getBalanceMiles();
        member.purchaseSeatUpgradesUsingMiles(quantity);
        int balanceCost = startBalance - member.getBalanceMiles();

        assertEquals(1, member.getSeatUpgradeBalance());
        assertEquals(8000, balanceCost);
    }

    @Test
    void shouldPurchaseSeatUpgradesWithCC() {

        SpyCas spy = new SpyCas();
        mother.redGuy.setCas(spy);

        mother.redGuy.purchaseSeatUpgradesUsingCC(2, SpyCas.VALID_CC);

        assertEquals(2, mother.redGuy.getSeatUpgradeBalance());
        assertEquals(200, spy.getChargedAmount());

    }

    @Test
    void shouldNotPurchaseSeatUpgradesWithBadCC() {
        SpyCas spy = new SpyCas();
        mother.redGuy.setCas(spy);

        mother.redGuy.purchaseSeatUpgradesUsingCC(2, SpyCas.INVALID_CC);

        assertEquals(0, mother.redGuy.getSeatUpgradeBalance());
        assertEquals(0, spy.getChargedAmount());
    }
}
