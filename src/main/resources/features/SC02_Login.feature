@current-feature

Feature: User could log in with valid email and password

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page

    # Test Scenario 1
  Scenario: user can login with valid email and password
    When user enters valid email
    And user enters valid password
    And user clicks login button

    Then user is redirected to homepage
    And logout link appears after login