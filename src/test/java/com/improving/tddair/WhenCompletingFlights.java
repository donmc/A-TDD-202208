package com.improving.tddair;

import io.cucumber.java.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhenCompletingFlights {

    private TddAirApplication app;
    private Member member;

    @BeforeEach
    void given() {
        app = new TddAirApplication();
        String username = "donmc";
        app.addFlight("TST", "TST", 1000, "TEST", 1000);
        app.addFlight("TST", "TST", 10000,"TEST", 10000);

        app.registerMember(username, "don@improcing.com");
        app.completeFlight(username, "TEST1000");
        member = app.lookupMember(username);
    }

    @Test
    void shouldUpdateYtdMiles() {
        assertEquals(1000, member.getYtdMiles());
    }

    @Test
    void shouldUpdateBalanceMiles() {
        assertEquals(11000, member.getBalanceMiles());
    }

    @Test
    void shouldUpdateStatusToGreen() {
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");

        assertEquals(Status.Green, member.getStatus());

    }

    @Test
    void shouldUpdateStatusToBlue() {
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");

        assertEquals(Status.Blue, member.getStatus());

    }

    @Test
    void shouldUpdateStatusToGold() {
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");
        app.completeFlight("donmc", "TEST10000");

        assertEquals(Status.Gold, member.getStatus());

    }

}