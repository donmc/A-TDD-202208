package com.improving.tddair;

public class Member {
    private final String username;
    private final String email;
    private final Status status;
    private int ytdMiles;
    private int balanceMiles;

    public Member(String username, String email) {
        this.username = username;
        this.email = email;
        this.status = Status.Red;
        this.ytdMiles = 0;
        this.balanceMiles = 10000;
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
}
