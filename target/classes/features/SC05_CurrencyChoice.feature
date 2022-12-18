Feature: Logged User could switch between currencies US-Euro

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

    # Test Scenario 1
  Scenario: user can switch from US Dollar to Euro
    When user selects euro from currency dropdown menu

    Then featured products displayed currency type and price will change