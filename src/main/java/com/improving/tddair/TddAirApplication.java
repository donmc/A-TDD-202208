package com.improving.tddair;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private Map<String, Member> members = new HashMap<>();

	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String username, String email) {
		Member member = new Member(username, email);
		members.put(member.getUsername(), member);
	}

	public Member lookupMember(String username) {
		return members.get(username);
	}
}
