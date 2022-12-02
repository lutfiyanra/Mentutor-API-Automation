Feature: Post Login
  @login @positive
  Scenario: Post login admin with valid value
    Given Post login with all valid value as admin
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema

  @login @positive
  Scenario: Post login mentor with valid value
    Given Post login with all valid value as mentor
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema

  @login @positive
  Scenario: Post login mentee with valid value
    Given Post login with all valid value as mentee
    When Send request post login
    Then Should return 200 OK
    And Validate post login valid value json schema

  @login @negative
  Scenario: Post login with with invalid email
    Given Post login as admin with invalid email
    When Send request post login
    Then Should return respons body code 404 not found
    And Validate post login user not found json schema

  @login @negative
  Scenario: Post login with invalid password
    Given Post login as admin with invalid password
    When Send request post login
    Then Should return respons body code 400 bad request
    And Validate post login invalid input from client json schema

  @login @negative
  Scenario: Post login with invalid all data
    Given Post login as admin with invalid all data
    When Send request post login
    Then Should return respons body code 404 not found
    And Validate post login user not found json schema

  @login @negative
  Scenario: Post login with empty email
    Given Post login as admin with empty email
    When Send request post login
    Then Should return respons body code 400 bad request
    And Validate post login invalid input from client json schema

  @login @negative
  Scenario: Post login with empty password
    Given Post login as admin with empty password
    When Send request post login
    Then Should return respons body code 400 bad request
    And Validate post login invalid input from client json schema

  @login @negative
  Scenario: Post login with empty data
    Given Post login as admin with empty data
    When Send request post login
    Then Should return respons body code 400 bad request
    And Validate post login invalid input from client json schema