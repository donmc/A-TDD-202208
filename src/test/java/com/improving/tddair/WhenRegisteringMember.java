package com.improving.tddair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhenRegisteringMember {

    private Member member;
    private String username;
    private TddAirApplication app;

    @BeforeEach
    void given() {
        username = "donmc";
        String email  = "don@improving.com";
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
    void shouldRegisterAnotherMember() {
        app.registerMember("bob", "bob@improving.com");
        Member member = app.lookupMember("bob");
        assertEquals("bob", member.getUsername());
    }
}