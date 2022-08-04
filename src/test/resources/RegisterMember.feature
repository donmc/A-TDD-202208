Feature: Register Member

  Scenario: Successful Registration

    When member registers with username "donmc" and email "don@improving.com"
    Then member account exists with username "donmc"
    And member has status of "Red"
    And member has ytd miles of 0
    And member has balance miles of 10000

  Scenario: Duplicate Username
    Given member registers with username "donmc" and email "don@improving.com"
    When member registers with username "donmc" and email "don@don.com"
    Then should get error "DUPE!"

  Scenario Outline: Invalid Email
    When member registers with username "<username>" and email "<email>"
    Then should get error "BAD EMAIL!"
    Examples:
      | username | email      |
      | don      | don@don.   |
      | bob      | bob.com    |
      | mary     | @chase.com |


