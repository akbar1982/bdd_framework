Feature: Login screen test scenarios

  @Run
  @Smoke
  Scenario: Validate title of login screen
    Given User in landing page of hotels.com
    Then  User clicks on sign in button
    And   User validates sign in page title

  @Run
  @Regression
  Scenario Outline: Validate text of sign in button on login screen
    Given User in landing page of hotels.com
    Then  User clicks on sign in button
    And   User validates "<signInText>" of the sign in button
    Examples:
      | signInText       |
      | Sign in          |
#      | sign in          |