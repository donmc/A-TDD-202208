package com.improving.stepdefs;

import com.improving.tddair.Member;
import com.improving.tddair.TddAirApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {

    private TddAirApplication app;
    private Member member;
    private String errorMessage;

    public StepDefinition() {
        app = new TddAirApplication();
        System.out.println("Const!");
    }

    @When("member registers with username {string} and email {string}")
    public void member_registers_with_username_and_email(String username, String email) {
        try {
            app.registerMember(username, email);
        }catch (Exception e) {
            this.errorMessage = e.getMessage();
        }
    }
    @Then("member account exists with username {string}")
    public void member_account_exists_with_username(String username) {
        member = app.lookupMember(username);
        Assertions.assertEquals(username, member.getUsername());
    }
    @Then("member has status of {string}")
    public void member_has_status_of(String status) {
        Assertions.assertEquals(status, member.getStatus().toString());

    }
    @Then("member has ytd miles of {int}")
    public void member_has_ytd_miles_of(Integer ytdMiles) {
        Assertions.assertEquals(ytdMiles, member.getYtdMiles());
    }
    @Then("member has balance miles of {int}")
    public void member_has_balance_miles_of(Integer balanceMiles) {
        Assertions.assertEquals(balanceMiles, member.getBalanceMiles());
    }

    @Then("should get error {string}")
    public void shouldGetError(String message) {
        Assertions.assertEquals(message, errorMessage);
    }

    @Given("member with {int}")
    public void memberWithStartMiles(int startMiles) {
        app = new TddAirApplication();
        app.addFlight("TST", "TST", startMiles, "TST", 123);
        app.registerMember("test", "test@test.com");
        member = app.lookupMember("test");
        app.completeFlight("test", "TST123");

    }

    @When("they complete flight {string}")
    public void they_complete_flight(String flightNumber) {
        app.completeFlight("test", flightNumber);
    }
}
