Feature: Complete Flight

  Scenario Outline: Change status based on miles flown
    Given member with <startMiles>
    When they complete flight "<flightNumber>"
    Then member has status of "<status>"
    And member has ytd miles of <ytdMiles>
    And member has balance miles of <balanceMiles>

    Examples:
      | startMiles | flightNumber | status | ytdMiles | balanceMiles |
      | 1000       | QF191        | Red    | 8490     | 18490        |
      | 24000      | QF191        | Green  | 31490    | 41490        |
      | 45000      | QF191        | Blue   | 52490    | 62490        |
      | 70000      | QF191        | Gold   | 77490    | 87490        |