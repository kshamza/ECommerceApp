Feature: Logged User could search for any product

  Background:
#    Given user opens browser and navigates to test site
    Given user navigates to login page
    And user successfully logs in

    # Test Scenario 1
  Scenario: user can search for any product
    When user enters a valid search term in the search box
    And user clicks the search button

    Then products display and their names contain the search term