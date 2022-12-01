Feature: Post Login
  @login
  Scenario: Post login with valid value
    Given Post login with all valid value as admin
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema

  Scenario: Post login with valid value
    Given Post login with all valid value as mentor
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema

  Scenario: Post login with valid value
    Given Post login with all valid value as mentee
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema
