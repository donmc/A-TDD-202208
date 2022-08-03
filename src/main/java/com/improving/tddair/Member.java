package com.improving.tddair;

public class Member {
    private final String username;
    private final String email;

    public Member(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
}
