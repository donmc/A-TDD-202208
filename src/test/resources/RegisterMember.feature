Feature: Register Member

  Scenario: Successful Registration

    When member registers with username "donmc" and email "don@improving.com"
    Then member account exists with username "donmc"
    And member has status of "Red"
    And member has ytd miles of 0
    And member has balance miles of 10000
