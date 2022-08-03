package com.improving.stepdefs;

import com.improving.tddair.Member;
import com.improving.tddair.TddAirApplication;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {

    private TddAirApplication app;

    @When("member registers with username {string} and email {string}")
    public void member_registers_with_username_and_email(String username, String email) {
        app = new TddAirApplication();
        app.registerMember(username, email);
    }
    @Then("member account exists with username {string}")
    public void member_account_exists_with_username(String username) {
        Member member = app.lookupMember(username);
        Assertions.assertEquals(username, member.getUsername());
    }
    @Then("member has status of {string}")
    public void member_has_status_of(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("member has ytd miles of {int}")
    public void member_has_ytd_miles_of(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("member has balance miles of {int}")
    public void member_has_balance_miles_of(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
