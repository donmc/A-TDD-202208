package com.improving.tddair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void getFullFlightNumber_SUCCESS() {
        //setup (given)
        String airline = "AA";
        int flightNo = 2233;

        Flight flight = new Flight("DFW", "ORD", 920, airline, flightNo);

        //exercise (when)
        String fullFlightNo = flight.getFullFlightNumber();

        //outcome (then)
        assertEquals("AA2233", fullFlightNo);
    }

    @Test
    void getFullFlightNumber_NoAirline() {
        //setup (given)
        String airline = null;
        int flightNo = 2233;

        Flight flight = new Flight("DFW", "ORD", 920, airline, flightNo);

        //exercise (when)
        String fullFlightNo = flight.getFullFlightNumber();

        //outcome (then)
        assertEquals("UNKNOWN", fullFlightNo);
    }

    @Test
    void getFullFlightNumber_BadFlightNo() {
        //setup (given)
        String airline = "AA";
        int flightNo = -1;

        Flight flight = new Flight("DFW", "ORD", 920, airline, flightNo);

        //exercise (when)
        String fullFlightNo = flight.getFullFlightNumber();

        //outcome (then)
        assertEquals("UNKNOWN", fullFlightNo);
    }

    @Test
    void testIsLongHaulFlight_true() {
        Flight flight = new Flight("JAX", "LHR", 4000);

        boolean isLong = flight.isLongHaulFlight();

        assertTrue(isLong);
    }
}