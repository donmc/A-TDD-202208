package com.improving.tddair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhenRegisteringMember {

    private Member member;
    private String username;
    private TddAirApplication app;

    @BeforeEach
    void given() {
        username = "donmc";
        String email = "don@improving.com";
        app = new TddAirApplication();
        app.registerMember(username, email);

        member = app.lookupMember(username);
    }

    @Test
    void doesMemberExist() {
        assertNotNull(member);
    }

    @Test
    void shouldHaveCorrectUsername() {
        assertEquals(username, member.getUsername());
    }

    @Test
    void shouldHaveRedStatus() {
        assertEquals(Status.Red, member.getStatus());
    }

    @Test
    void shouldHave0ytdMiles() {
        assertEquals(0, member.getYtdMiles());
    }

    @Test
    void shouldHaveBonusBalanceMiles() {
        assertEquals(10000, member.getBalanceMiles());
    }


    @Test
    void shouldHave0SeatUpgrades() {
        assertEquals(0, member.getSeatUpgradeBalance());
    }

    @Test
    void shouldNotAllowDuplicateUsername() {
        try {
            app.registerMember(username, "don@don.com");
            fail("Should have thrown an exception!");
        } catch (DuplicateUsernameException e) {
            assertEquals("DUPE!", e.getMessage());
        } catch (Exception e) {
            fail("Wrong Exception Thrown!");
        }

    }

    @Disabled
    void shouldNotAllowInvalidEmail() {

    }

    @Test
    void shouldRegisterAnotherMember() {
        app.registerMember("bob", "bob@improving.com");
        Member member = app.lookupMember("bob");
        assertEquals("bob", member.getUsername());
    }
}