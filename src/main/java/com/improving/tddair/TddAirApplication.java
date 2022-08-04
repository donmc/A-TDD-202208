package com.improving.tddair;


import java.util.HashMap;
import java.util.Map;

public class TddAirApplication {

    private final FlightDao flights = new FlightDao();
    private final Map<String, Member> members = new HashMap<>();


    public TddAirApplication() {
    }

    public void addFlight(String origin, String destination, int mileage, String airline, int number) {
        flights.addFlight(origin, destination, mileage, airline, number);
    }

    public void registerMember(String username, String email) {
        if (members.containsKey(username)) throw new DuplicateUsernameException("DUPE!");
        if (emailNotValid(email)) throw new IllegalArgumentException("BAD EMAIL!");
        Member member = new Member(username, email);
        members.put(member.getUsername(), member);
    }

    private boolean emailNotValid(String email) {
        return !email.contains("@");
    }

    public Member lookupMember(String username) {
        return members.get(username);
    }

    public void completeFlight(String username, String flightNumber) {
        Member member = members.get(username);
        Flight flight = flights.getFlightBy(flightNumber);
        member.completeFlight(flight);
    }
}
